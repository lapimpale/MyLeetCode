class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int i=0;
        int j=matrix[0].length-1;
        while(validateBounderies(matrix,i,j))
        {
            if(target == matrix[i][j])
            {
                return true;
            }
            if(target < matrix[i][j])
            {
                j--;
            }
           else if(target>matrix[i][j])
            {
                i++;
            }
        }
        return false;
    }
    private boolean validateBounderies(int[][] matrix,int i,int j)
    {
        if(i<matrix.length && j<matrix[0].length && i>=0 && j>=0)
            return true;
        return false;
    }
}