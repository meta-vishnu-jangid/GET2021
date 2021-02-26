package main;

import main.SparseMatrix;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

	public static void main(String[] args) {
		
		Map<Integer,Map<Integer,Integer>> matrix = new HashMap<Integer,Map<Integer,Integer>>();
		Map<Integer,Map<Integer,Integer>> matrix2 = new HashMap<Integer,Map<Integer,Integer>>();
		
		//   2 0 3 0
		//   0 0 0 0
		//   1 0 2 89
		//   0 3 0 5
		
		Map<Integer,Integer> firstRowMap = new HashMap<Integer,Integer>();
		Map<Integer,Integer> thirdRowMap = new HashMap<Integer,Integer>();
		Map<Integer,Integer> fourthRowMap = new HashMap<Integer,Integer>();
		
		//Initializing First Row
		
		firstRowMap.put(0, 2);
		firstRowMap.put(2, 3);
		
		//Initializing Third Row
		thirdRowMap.put(0, 1);
		thirdRowMap.put(2, 2);
		thirdRowMap.put(3, 89);
		
		// Initializing Fourth Row
		fourthRowMap.put(1, 3);
		fourthRowMap.put(3, 5);
		
		matrix.put( 0 , firstRowMap);
		matrix.put( 2 , thirdRowMap);
		matrix.put(3, fourthRowMap);
		
		SparseMatrix sparseMatrix = new SparseMatrix(4,4,matrix);
		
		int[][] transposeMatrix = sparseMatrix.transpose();
		
		System.out.println("Transpose of Matrix ::  ");
		
		for(int[] rows : transposeMatrix ){
			for(int ele : rows ){
				System.out.print(ele + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println("\nis Matrix Symmetric : " + sparseMatrix.isSymmetric());

		int[][] additionMatrix = SparseMatrix.add(sparseMatrix, sparseMatrix);
		
		
		System.out.println("\nAddition  of Matrix with Itself ::   \n");
		
		for(int[] rows : additionMatrix ){
			for(int ele : rows ){
				System.out.print(ele + " ");
			}
			System.out.print("\n");
		}
		
        int[][] multiplicatioMatrix = SparseMatrix.multiply(sparseMatrix, sparseMatrix);
		
		
		System.out.println("\nMultiplicatio  of Matrix with Itself ::   \n");
		
		for(int[] rows : multiplicatioMatrix ){
			for(int ele : rows ){
				System.out.print(ele + " ");
			}
			System.out.print("\n");
		}
		
	}

}
