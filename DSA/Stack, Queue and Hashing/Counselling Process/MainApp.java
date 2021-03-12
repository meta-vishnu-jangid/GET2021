package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		
		
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Relative Path For Student File : ");
		String studentListPath = reader.readLine();   
		
		System.out.println("Enter Relative Path For Program List File : ");
		String programListPath = reader.readLine(); 
		
		System.out.println("Enter Relative Path For Ouptut  File : ");
		String allocationFilePath = reader.readLine();
			
		try{
			CounsellingProcess counsellingProcess = new CounsellingProcess(studentListPath,programListPath,allocationFilePath);
			counsellingProcess.getListOfStudentsWithAllocatedPrograms();
		}
		catch(AssertionError e){
			System.out.println(e.getMessage());
		}
		
		}


}

