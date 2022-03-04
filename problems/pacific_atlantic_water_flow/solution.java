class Solution {
     int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // Traverse all possible grid cells from the top and bottom row
        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific, heights[0][col]);
            dfs(heights, rows - 1, col, atlantic, heights[rows - 1][col]);
        }
        
        // Traverse all possible grid cells from the leftmost and rightmost columns
        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific, heights[row][0]);
            dfs(heights, row, cols - 1, atlantic, heights[row][cols - 1]);
        }
        
        // Accumulate the result by checking if the cell can be visited from the Pacific AND the Atlantic Ocean
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }
    
	// All possible directions to go from the current cell
    int[][] directions = new int[][] {
        {0, -1},  // Left
        {0, 1},   // Right
        {-1, 0},  // Up
        {1, 0}    // Down
    };
    
    public void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if (!isNodeValid(row, col)) return;
        if (visited[row][col]) return;
        if (heights[row][col] < prevHeight) return;
        visited[row][col] = true;
        for (int[] direction: directions) {
            dfs(heights, row + direction[0], col + direction[1], visited, heights[row][col]);
        }
    }
    
    public boolean isNodeValid(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
}