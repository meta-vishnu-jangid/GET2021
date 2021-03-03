package main;

import main.IntSet;

public class MainApp {

	public static void main(String[] args) {
		
		int[] arr1 = { 1 ,2 ,3 ,4 ,4};
		int[] arr2 = {5, 6, 7, 8, 99 };
		Integer[] arr3 = { 1 , 2 };
		
		IntSet intSet1 = new IntSet(arr1);
		IntSet intSet2 = new IntSet(arr2);
		IntSet intSet3 = new IntSet(arr3);
		
		
		System.out.print("Set1: ");
		for(int item : intSet1 ){
			System.out.print(item + " ");
		}
		
		System.out.print("\nSet2: ");
		for(int item : intSet2 ){
			System.out.print(item + " ");
		}
		
		System.out.print("\nSet3: ");
		for(int item : intSet3 ){
			System.out.print(item + " ");
		}
		
		System.out.print("\nSet1 Size: ");
		System.out.print(intSet1.size());
		
		System.out.print("\nIs '1' is member of Set1: " + intSet1.isMember(1));
		System.out.print("\nIs '1' is member of Set1: " + intSet1.isMember(5));
		
		System.out.print("\nIs Set3 is subset of Set1: " + intSet1.hasSubSet(intSet3));
		System.out.print("\nIs Set2 is subset of Set1: " + intSet1.hasSubSet(intSet2));
		
		System.out.print("\nCompliment of Set1 :"  );
		for(int item : intSet1.getCompliment() ){
			System.out.print(item + " ");
		}
		
		System.out.print("\n\nUnion of Set1 and Set2 :"  );
		for(int item : intSet1.union(intSet2) ){
			System.out.print(item + " ");
		}
		System.out.print("\nUnion of Set1 and Set3 :"  );
		for(int item : intSet1.union(intSet3) ){
			System.out.print(item + " ");
		}
		
	}

}
