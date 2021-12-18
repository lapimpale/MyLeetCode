class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(matrix == null || rows == 0)
            return false;
        int cols = matrix[0].length;
        int x = 0, y = cols - 1;
        while(x < rows && y >= 0)
        {
            int element = matrix[x][y];
            if(element == target)
                return true;
            if(target > element)
                x++;
            else y--;
        }
        return false;
        
    }
}