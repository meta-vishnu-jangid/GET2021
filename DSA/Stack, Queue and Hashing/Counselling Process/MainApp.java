package main;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainApp {

	public static void main(String[] args) {
		
			String studentListPath = "C:\\Users\\vishnu.jangid_metacu\\Desktop\\student.xls";
			String programListPath = "C:\\Users\\vishnu.jangid_metacu\\Desktop\\program.xls";
			String allocationFilePath = "C:\\Users\\vishnu.jangid_metacu\\Desktop\\allocation.xls";
		    CounsellingProcess counsellingProcess = new CounsellingProcess(studentListPath,programListPath,allocationFilePath);
		    counsellingProcess.getListOfStudentsWithAllocatedPrograms();
		
			
		}


}

