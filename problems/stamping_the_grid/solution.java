class Solution {

    private void build(int[][] grid , int height , int width) {
        // build count
        int i , j , n = grid.length , m = grid[0].length;
        for (i = 0;i < n;i ++) {
            count[i][0] = grid[i][0];
            if (i > 0) {
                count[i][0] += count[i - 1][0];
            }
        }
        for (j = 0;j < m;j ++) {
            count[0][j] = grid[0][j];
            if (j > 0) {
                count[0][j] += count[0][j - 1];
            }
        }
        for (i = 1;i < n;i ++) {
            for (j = 1;j < m;j ++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1] - count[i - 1][j - 1] + grid[i][j];
            }
        }
        // build candidate
        for (i = 0;i < n;i ++) {
            for (j = 0;j < m;j ++) {
                if (grid[i][j] == 0 && i + height - 1 < n && j + width - 1 < m) {
                    int total = query(i , j , i + height - 1 , j + width - 1);
                    if (total == 0) {
                        candidate[i][j] = 1;
                    }
                }
            }
        }
        for (i = 0;i < n;i ++) {
            candidateSum[i][0] = candidate[i][0];
            if (i > 0) {
                candidateSum[i][0] += candidateSum[i - 1][0];
            }
        }
        for (j = 0;j < m;j ++) {
            candidateSum[0][j] = candidate[0][j];
            if (j > 0) {
                candidateSum[0][j] += candidateSum[0][j - 1];
            }
        }
        for (i = 1;i < n;i ++) {
            for (j = 1;j < m;j ++) {
                candidateSum[i][j] = candidateSum[i - 1][j] + candidateSum[i][j - 1] - candidateSum[i - 1][j - 1] + candidate[i][j];
            }
        }
    }

    private int query(int x1 , int y1 , int x2 , int y2) {
        int sum = count[x2][y2];
        if (x1 - 1 >= 0) {
            sum -= count[x1 - 1][y2];
        }
        if (y1 - 1 >= 0) {
            sum -= count[x2][y1 - 1];
        }
        if (x1 - 1 >= 0 && y1 - 1 >= 0) {
            sum += count[x1 - 1][y1 - 1];
        }
        return sum;
    }

    private boolean check(int x1 , int y1 , int x2 , int y2) {
        int sum = candidateSum[x2][y2];
        if (x1 - 1 >= 0) {
            sum -= candidateSum[x1 - 1][y2];
        }
        if (y1 - 1 >= 0) {
            sum -= candidateSum[x2][y1 - 1];
        }
        if (x1 - 1 >= 0 && y1 - 1 >= 0) {
            sum += candidateSum[x1 - 1][y1 - 1];
        }
        return sum > 0;
    }

    private int[][] count;
    private int[][] candidateSum;
    private int[][] candidate;

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int i , j , n = grid.length , m = grid[0].length;
        count = new int[n][m];
        candidate = new int[n][m];
        candidateSum = new int[n][m];
        build(grid , stampHeight , stampWidth);
        for (i = 0;i < n;i ++) {
            for (j = 0;j < m;j ++) {
                if (grid[i][j] == 0) {
                    int x = Math.max(0 , i - stampHeight + 1) , y = Math.max(0 , j - stampWidth + 1);
                    if (!check(x , y , i , j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}