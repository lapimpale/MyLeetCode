class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j<mat[0].length; j++)
                if (mat[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    mat[i][j] = -1;
        int distance = 0;
        int[][] dirs = new int[][]{{1,0}, {0, -1}, {-1, 0},{0,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            while(size-- > 0){
                int[] point = queue.poll();
                for (int[] dir:dirs){
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];
                    if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] != -1)
                        continue;
                    mat[r][c] = distance;
                    queue.add(new int[]{r,c});
                }
            }
        }
        return mat;
    }
}