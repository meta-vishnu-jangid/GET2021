package main;

import java.util.HashMap;
import java.util.Map;


public class SparseMatrix {
	
	private final Map<Integer,Map<Integer,Integer>> matrix ;
	private final int no_of_rows ;
	private final int no_of_columns ;
	
	
	/**
	 * Initialize Sparse Matrix Object
	 * @param rows , requires no. of rows greater then 0
	 * @param columns , requires no. of columns greater then 0
	 * @param matrix , A Map which have matrix
	 */
	public SparseMatrix( int rows , int columns , Map <Integer , Map< Integer,Integer > > matrix ){
		this.matrix =  new HashMap<>(matrix) ;
		this.no_of_rows = rows ;
		this.no_of_columns = columns ;
	}
	
	
	
	/**
	 * Method to get element of Matrix at specified position.
	 * @param row_index , Index of Row 
	 * @param col_index , Index of Column
	 * @return the Element at required position
	 */
	private int get( int row_index  , int col_index ){
		Map <Integer,Integer> emptyMap = new HashMap<Integer,Integer>(); 
	  	return this.matrix.getOrDefault(row_index,emptyMap).getOrDefault(col_index, 0);
	}
	
	
	
	/**
	 * Method to get Transpose of Matrix.
	 * @return a 2d array which represent transpose matrix.
	 */
	public int[][] transpose(){
		
		int[][]	transposeMatrix = new int[this.no_of_columns][this.no_of_rows];
	    
		for( int row = 0 ; row < this.no_of_rows ; row++ ){
			for( int col = 0 ; col < this.no_of_columns ; col++ ){
				transposeMatrix[col][row] = this.get( row,col);
			}
		}
		
		return transposeMatrix;
	}
	
	
	
	/**
	 * Method to find if Matrix is Symmetric.
	 * @return true if Matrix is symmetric otherwise false.
	 */
	public boolean isSymmetric(){
		
		boolean isSymmetric = true ;
		
		if ( this.no_of_columns != this.no_of_rows  ){
			isSymmetric = false ;
		}
		else{
			
			for( int row = 0 ; row < this.no_of_rows ; row++ ){
				for( int col = 0 ; col < this.no_of_columns; col++ ){
					if( this.get(row, col)!= this.get(col, row) ){
						isSymmetric = false ;
						break;
					}
				}
			}
		}
		return isSymmetric ;
	}
	
	
	/**
	 * Method to add two Sparse matrix.
	 * @param sm1 , 1st Sparse Matrix
	 * @param sm2 , 2nd Sparse Matrix.
	 * @return a 2d array which represent addition result matrix.
	 */
	public static int[][] add( SparseMatrix sm1 , SparseMatrix sm2 ){
		
		int[][] resultantMatrix = new int[sm1.no_of_rows][sm1.no_of_columns];
		
		for( int row =0 ; row < sm1.no_of_rows ; row++ ){
			for( int col =0 ; col < sm1.no_of_columns ; col++ ){
				resultantMatrix[row][col] = sm1.get(row, col) + sm2.get(row, col);
			}
		}
		
		return resultantMatrix ;
		
	}

	
	
	/**
	 * Method to multiply two Sparse matrix.
	 * @param sm1 , 1st Sparse Matrix
	 * @param sm2 , 2nd Sparse Matrix.
	 * @return a 2d array which represent multiplication result matrix.
	 */
	public static int[][] multiply( SparseMatrix sm1 , SparseMatrix sm2 ){
		
		int[][] resultantMatrix = new int[sm1.no_of_rows][sm2.no_of_columns];
	 
		for( int row1 = 0 ; row1 < sm1.no_of_rows ; row1++ ){
			for( int col2 = 0 ; col2 < sm2.no_of_columns ; col2++ ){
				for ( int row2 = 0 ; row2 < sm2.no_of_rows ; row2 ++){
					resultantMatrix[row1][col2] += sm1.get(row1, row2)*sm2.get(row2, col2);
				}
			}
		}
		
		return resultantMatrix ;
		
	}
	
}
