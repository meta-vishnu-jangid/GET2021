package main;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;   
import org.apache.poi.ss.usermodel.Row;  

/**
 * Class for Counseling Process
 * @author vishnu.jangid_metacu
 *
 */
public class CounsellingProcess {
	
	private FileInputStream  studentList;
	private FileInputStream  ProgramList;
	private String allocationFilePath;
	
	/**
	 * Initialize Counseling Process
	 * @param studentListPath String, path of Student List with their Prefernece.
	 * @param programListPath String, path of Program List with their Capacity. 
	 * @param allocationFilePath String, path of file at which data is to be stored
	 * @throws AssertionError if File Not Found 
	 */
	public CounsellingProcess(String studentListPath, String programListPath, String allocationFilePath) throws AssertionError {
		
			try {
				this.studentList = new FileInputStream(new File(studentListPath));
				this.ProgramList = new FileInputStream(new File(programListPath));
				this.allocationFilePath = allocationFilePath;
			} catch (FileNotFoundException e) {
				throw new AssertionError("File not Found");
			}
			
	}
	
	/**
	 * Get List of Student With Allocated Programs in A Excel File
	 * @throws AssertionError if there is an error in Reading File Content
	 */
	public void getListOfStudentsWithAllocatedPrograms() throws AssertionError{
		
		CircularQueue<Student> studentQueue = new CircularQueue<Student>(100);
		Map<String, String> allocationMap = new HashMap<String, String>(); 
		Map<String, Integer> programMap = new HashMap<String, Integer>(); 
		
		HSSFWorkbook studentWorbook = null;
		HSSFWorkbook programWorbook = null;
		try {
			studentWorbook = new HSSFWorkbook(this.studentList);
			programWorbook = new HSSFWorkbook(this.ProgramList);
		} catch (IOException e) {
			throw new AssertionError("Input Ouput Exception");
		}
				
		HSSFSheet studentSheet = studentWorbook.getSheetAt(0);
		HSSFSheet programSheet = programWorbook.getSheetAt(0);
		
		// Inserting Students into CicularQueue for Counseling
		int row_no = 0;
		int col_no = 0;
		for(Row row : studentSheet){
			col_no = 0;
			String nameOfStudent = null;
			ArrayList<String> preferences = new ArrayList<String>();
			for(Cell cell : row){
				if(col_no == 0){
					nameOfStudent = cell.getStringCellValue().trim();
				}
				else{
					preferences.add(cell.getStringCellValue().trim());
				}
				col_no++;
			}
			if(row_no > 0){
				studentQueue.enQueue(new Student(nameOfStudent,preferences));
			}
			row_no ++;
		}
		
		//Reading Program List from Excel File
		row_no = 0;
		col_no = 0;
		String programName = null;
		int capacity = 0;
		for(Row row : programSheet){
			col_no = 0;
			if(row_no > 0){
				for(Cell  cell : row){
					if(col_no == 0){
						programName = cell.getStringCellValue().trim();
					}
					else if(col_no == 1){
						capacity = (int)cell.getNumericCellValue();
					}
					col_no++;
				}
				programMap.put(programName, capacity);
			}			
			row_no++;
		}
		
		// Allocating Programs to Students in A MAP
		while(!studentQueue.isEmpty()){
			Student student = studentQueue.deQueue();
			System.out.println(student.getName() +" : ");
			ArrayList<String> preferences = student.getListOfPreference();
			boolean flag = false;
			for(String preference : preferences){
				System.out.println("        " + preference);
				System.out.println("           " + programMap.getOrDefault(preference, 0));
				if(programMap.getOrDefault(preference, 0) > 0){
					flag = true;
					allocationMap.put(student.getName(),preference);
					programMap.put(preference,programMap.get(preference)-1);
					break;
				}
			}
			if(flag == false){
				allocationMap.put(student.getName(),"");
			}
		}
		
		
		
		//Output Allocation in Excel FIle 
		HSSFWorkbook allocationWorbook = new HSSFWorkbook();
		HSSFSheet allocationSheet = allocationWorbook.createSheet("Program Allocation");
		
		Row titleRow = allocationSheet.createRow(0);
		Cell studentNameCell = titleRow.createCell(0);
		Cell programAllocatedCell = titleRow.createCell(1);
		studentNameCell.setCellValue("Student Name");
		programAllocatedCell.setCellValue("Program Name");
		
		row_no = 1;
		for(String studentName : allocationMap.keySet()){
			Row tempRow = allocationSheet.createRow(row_no);
			Cell tempNameCell = tempRow.createCell(0);
			Cell tempProgramCell = tempRow.createCell(1);
			tempNameCell.setCellValue(studentName);
			tempProgramCell.setCellValue(allocationMap.getOrDefault(studentName, ""));
			row_no++;
		}
		
		try {
			FileOutputStream outputStream = new FileOutputStream(this.allocationFilePath);
			allocationWorbook.write(outputStream);
		} catch (Exception e) {
			throw new AssertionError("Error in Creating Output File");
		}
		
	}
}
