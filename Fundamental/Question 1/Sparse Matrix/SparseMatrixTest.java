package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	/**
	 * Methods For testing Sparse Matrix Methods Result
	 */
	@Test
	public void Test() {
		
		int[][] matrix1 = {{ 0,0,2 },{0,2,3},{2,0,1},{2,2,2},{2,3,89},{3,1,3},{3,3,5}};
		int[][] matrix2 = {{ 0,0,2 },{0,2,3},{2,0,3},{2,2,2},{2,3,89},{3,2,89},{3,3,5}};
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(4,4,matrix1);
		SparseMatrix sparseMatrix2 = new SparseMatrix(4,4,matrix2);
		SparseMatrix sparseMatrix3 = new SparseMatrix(4,5,matrix2);
		
		//Test For isSymmetric
		assertEquals(false,sparseMatrix1.isSymmetric());
		assertEquals(true,sparseMatrix2.isSymmetric());
		assertEquals(false,sparseMatrix3.isSymmetric());
		
		//Test For Transpose
		assertArrayEquals(new int[][] {{2,0,1,0},{0,0,0,3},{3,0,2,0},{0,0,89,5}}, sparseMatrix1.transpose());
		assertArrayEquals(new int[][] {{2,0,3,0},{0,0,0,0},{3,0,2,89},{0,0,89,5}}, sparseMatrix2.transpose());
		assertArrayEquals(new int[][] {{2,0,3,0},{0,0,0,0},{3,0,2,89},{0,0,89,5},{0,0,0,0}}, sparseMatrix3.transpose());
		
		
		//Test For Addition
		
		int[][] additionMatrixActual = {{4,0,6,0},{0,0,0,0},{2,0,4,178},{0,6,0,10}};
		int[][] addMatrixResult = SparseMatrix.add(sparseMatrix1, sparseMatrix1);
		assertArrayEquals(additionMatrixActual, addMatrixResult);
		
		//Test For Multiplication
		int [][] multiplyMatrixActual =  {{7,0,12,267},{0,0,0,0},{4,267,7,623},{0,15,0,25}};
		int[][] multiplyMatrixResult = SparseMatrix.multiply(sparseMatrix1, sparseMatrix1);
        assertArrayEquals(multiplyMatrixActual, multiplyMatrixResult);
	}
	
	/**
	 * Test Case for Sparse MAtrix Addition Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestForAddition(){
		
		int[][] matrix1 = {{ 0,0,2 },{0,2,3},{2,0,1},{2,2,2},{2,3,89},{3,1,3},{3,3,5}};
		int[][] matrix2 = {{ 0,0,2 },{0,2,3},{2,0,3},{2,2,2},{2,3,89},{3,2,89},{3,3,5}};
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(4,4,matrix1);
		SparseMatrix sparseMatrix3 = new SparseMatrix(4,5,matrix2);
		
		//Test For Addition
		SparseMatrix.add(sparseMatrix1, sparseMatrix3);
		
	}
	
	/**
	 * Test Case for Sparse MAtrix Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestForMultiplication(){
		
		int[][] matrix1 = {{ 0,0,2 },{0,2,3},{2,0,1},{2,2,2},{2,3,89},{3,1,3},{3,3,5}};
		int[][] matrix2 = {{ 0,0,2 },{0,2,3},{2,0,3},{2,2,2},{2,3,89},{3,2,89},{3,3,5}};
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(4,4,matrix1);
		SparseMatrix sparseMatrix3 = new SparseMatrix(5,4,matrix2);
		
		//Test For Addition
		SparseMatrix.multiply(sparseMatrix1, sparseMatrix3);
		
	}

}
