class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // create array with extra row that is defaulted to 0 
        int[][] dp = new int[matrix.length + 1][matrix.length + 1];
        
        // rows from bottom to top - start at the last row in the matrix and look down to the 0 defaulted row in dp[][]
        for (int i = matrix.length - 1; i >= 0; i--) {
            // columns
            for (int j = 0; j < matrix.length; j++) {  
                // if the element is at the left column
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                // if the element is at a right column
                else if (j == matrix.length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                }   
                // if the element is in the middle
                else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i+1][j], dp[i+1][j-1]), dp[i+1][j+1]);
                }
            }
        }
        
        int minPath = Integer.MAX_VALUE;
        // loop through all the min paths at the top and find the smallest path
        for (int col = 0; col < matrix.length; col++) {
            minPath = Math.min(minPath, dp[0][col]);
        }
        
        return minPath;
    }
}