package main;

import main.SparseMatrix;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

	public static void main(String[] args) {
		
		int[][] matrix = {{ 0,0,2 },{0,2,3},{2,0,1},{2,2,2},{2,3,89},{3,1,3},{3,3,5}};
		
		//   2 0 3 0
		//   0 0 0 0
		//   1 0 2 89
		//   0 3 0 5
		
		
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
