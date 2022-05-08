class Solution {
		public boolean hasValidPath(char[][] grid) {
			int n = grid.length, m = grid[0].length;
			boolean[][][] dp = new boolean[n][m][201];
			if(grid[0][0] == ')')return false;
			dp[0][0][1] = true;
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					if(i+1 < n) {
						int ne = grid[i+1][j];
						for (int k = 0; k <= 200; k++) {
							int nk = k + (ne == '(' ? 1 : -1);
							if(nk >= 0 && nk <= 200) {
								dp[i + 1][j][nk] |= dp[i][j][k];
							}
						}
					}
					if(j+1 < m) {
						int ne = grid[i][j+1];
						for (int k = 0; k <= 200; k++) {
							int nk = k + (ne == '(' ? 1 : -1);
							if(nk >= 0 && nk <= 200) {
								dp[i][j+1][nk] |= dp[i][j][k];
							}
						}
					}
				}
			}
			return dp[n-1][m-1][0];
		}
	}