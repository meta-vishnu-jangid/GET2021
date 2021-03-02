package main;

public class NQueen {
	
	 /**
     * this method checks whether solution exists or not
     * @param n , dimension of matrix
     * @return true if solution exist, false otherwise
     */
    public boolean isPossible(int n)
    {
        int row = 0; 
        int[][] board = new int[n][n];
        
        // initializing the board
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = 0;
        
        boolean result = placeQueen(n, board, row);
                
        return result;
        
    }
    
    
    /**
     * places the queens on the board 
     * @param n , dimension of matrix
     * @param board , A 2d array
     * @param row , Row Index to begin with
     * @return if a Queen is placed or not
     */
    private boolean placeQueen(int n, int[][] board, int row )
    {
        boolean isPlaced = false;
        
        for(int column = 0; column < n; column++)
        {
        	boolean canPlaced = canPlaceQueen(board, row, column, n);
            
            if(canPlaced)
            {
            	isPlaced = true;
                board[row][column] = 1;
                row++;
                
                if(row == n ) //all queens are placed
                {
                	isPlaced = true;
                    break;
                }
                
                if(!placeQueen(n, board, row  ))
                {
                    row--;
                    board[row][column] = 0; //removing the queen in order to backtrack
                    isPlaced = false;
                }
                else{ 
                	 break;
                }
                   
            }
        }
        
//        if(isPlaced){
//        	for( int[] rows: board ){
//            	for(int ele : rows){
//            		System.out.print(ele + " ");
//            	}
//            	System.out.print("\n");
//            }
//        	System.out.print("\n");
//        }
        return isPlaced;
    }
    
    
    /**
     * checks whether queen can be placed at the given position on the board or not
     * @param 2d array representing board
     * @param row , Index of Row
     * @param column , Index of Column
     * @param n dimension of matrix
     * @return true if queen can be placed ,otherwise false
     */
    private boolean canPlaceQueen(int[][] board, int row, int column, int n)
    {
        int i, j;
        boolean canPlaced = true; 
        
        //checks if any queen is there in the same column
        for(i = 0; i < row ; i++) 
        {
            if(board[i][column] == 1)
            	canPlaced = false;
        }
        
        //checks if any queen exists in the upper left diagonal
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1)
            	canPlaced = false;
        }
        
        //checks if any queen exists in the upper right diagonal
        for (i = row, j = column; i >= 0 && j < n; i--, j++)
        {
            if (board[i][j] == 1)
            	canPlaced = false;
        }
                
        return canPlaced; 
    }
    
    
   
}
