package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class MainApp {

	public static void main(String[] args) {
			String studentListPath = "src\\main\\Input\\student.xls";
			String programListPath = "src\\main\\Input\\program.xls";
			String allocationFilePath = "src\\main\\Output\\allocation.xls";
		    CounsellingProcess counsellingProcess = new CounsellingProcess(studentListPath,programListPath,allocationFilePath);
		    counsellingProcess.getListOfStudentsWithAllocatedPrograms();
		}


}

