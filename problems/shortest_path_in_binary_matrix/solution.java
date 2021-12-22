class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         int n = grid.length;
        int[][] dircs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1},{-1,1},{1,-1},{1,1}};
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        int level = 1;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                if(x == n-1 && y == n-1) return level;
                for(int[] d: dircs) {
                    if(d[0] + x>= 0 && d[0] + x < n && d[1] + y >= 0 && d[1] + y<n && grid[d[0]+x][d[1]+y] == 0 && !visit[d[0]+x][d[1]+y]) {
                        q.offer(new int[]{d[0]+x, d[1]+y});
                        visit[d[0]+x][d[1]+y] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}