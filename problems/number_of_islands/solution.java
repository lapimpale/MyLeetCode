class Solution {
   public int numIslands(char[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    dfs(grid, r, c);
                }
            }
        }
        return ans;
    }
    
    int[] dr = new int[] {1, -1, 0, 0};
    int[] dc = new int[] {0, 0, 1, -1};
    
    void dfs(char[][] grid, int r, int c) {
        if (!isValid(grid, r, c)) {
            return;
        }
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, r + dr[i], c + dc[i]);
        }
    }
    
    boolean isValid(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == '1';
    }
}