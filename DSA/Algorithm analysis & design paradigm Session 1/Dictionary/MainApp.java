package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("Enter JSON string : ");
		Scanner sc = new Scanner(System.in);
		String jsonString = sc.nextLine();
		
		JDictionary jDictionary = new JDictionary(jsonString);
		
		jDictionary.add("Hello","World");
		jDictionary.add("Hello","Worl");
		jDictionary.add("ZAz","zaz");
		jDictionary.add("xaxaxa","2");
		
		System.out.println("Strep 1 :\n");
		
		Pair[] sortedList = jDictionary.getSortedList();
		for(Pair pair : sortedList ){
			System.out.println("Key : "  + pair.getKey() + ", Value : " +pair.getValue());
		}
		
		jDictionary.add("Xaxaxa","3");
		jDictionary.add("Xaxaxa","4");
		jDictionary.add("Hallo","4");
		jDictionary.add("Hallp","4");
		jDictionary.add("Y","5");
		jDictionary.remove("Hello");
		
		System.out.println("\nStrep 2 :\n");
		
		sortedList = jDictionary.getSortedList();
		for(Pair pair : sortedList ){
			System.out.println("Key : "  + pair.getKey() + ", Value : " +pair.getValue());
		}
		
		System.out.println("\nStrep 3 :\n");
		
		sortedList = jDictionary.getSortedListInRange("Y", "z");
		for(Pair pair : sortedList ){
			System.out.println("Key : "  + pair.getKey() + ", Value : " +pair.getValue());
		}
		
	}

}
