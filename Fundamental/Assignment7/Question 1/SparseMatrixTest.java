package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	@Test
	public void test() {
		
		int[][] matrix = {{ 0,0,2 },{0,2,3},{2,0,1},{2,2,2},{2,3,89},{3,1,3},{3,3,5}};
		int[][] matrix2 = {{ 0,0,2 },{0,2,3},{2,0,3},{2,2,2},{2,3,89},{3,2,89},{3,3,5}};
		
		int[][] transposeMatrixActual = {{2,0,1,0},{0,0,0,3},{3,0,2,0},{0,0,89,5}};
		int[][] additionMatrixActual = {{4,0,6,0},{0,0,0,0},{2,0,4,178},{0,6,0,10}};
		int [][] multiplyMatrixActual =  {{7,0,12,267},{0,0,0,0},{4,267,7,623},{0,15,0,25}};
		
		SparseMatrix sparseMatrix = new SparseMatrix(4,4,matrix);
		SparseMatrix sparseMatrix2 = new SparseMatrix(4,4,matrix2);
		
		
		boolean isSymmetricResult = sparseMatrix.isSymmetric();
		
		int[][] transposeMatrixResult = sparseMatrix.transpose();
		
		int[][] addMatrixResult = SparseMatrix.add(sparseMatrix, sparseMatrix);
		int[][] multiplyMatrixResult = SparseMatrix.multiply(sparseMatrix, sparseMatrix);
		
		
		assertEquals(false,isSymmetricResult);
		assertEquals(true,sparseMatrix2.isSymmetric());
		
		assertArrayEquals(transposeMatrixActual, transposeMatrixResult);
		assertArrayEquals(additionMatrixActual, addMatrixResult);
		assertArrayEquals(multiplyMatrixActual, multiplyMatrixResult);
		
	}

}
