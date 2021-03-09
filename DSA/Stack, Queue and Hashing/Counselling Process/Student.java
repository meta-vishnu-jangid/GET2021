package main;

import java.util.ArrayList;

/**
 * Class Structure for a Student 
 * @author vishnu.jangid_metacu
 *
 */
public class Student {

	private final String name;
	private final ArrayList<String> listOfPreference;

	/**
	 * Initialze Student Object
	 * @param name String, Name of Student
	 * @param listOfPreference ArrayList<String>, list of Preferences
	 */
	public Student(String name, ArrayList<String> listOfPreference) {
		this.name = name;
		this.listOfPreference = listOfPreference;
	}
	
	/**
	 * Get Name of Student
	 * @return String, name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to get List of Preference
	 * @return ArrayList<String>, list of Preference
	 */
	public ArrayList<String> getListOfPreference() {
		return listOfPreference;
	}
}