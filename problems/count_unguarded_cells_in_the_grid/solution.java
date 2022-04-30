	class Solution {
		public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
			int[][] ng = new int[m][n];
			for(int i = 0;i < m;i++){
				Arrays.fill(ng[i], 1);
			}
			for(int[] g : guards){
				ng[g[0]][g[1]] = -1;
			}
			for(int[] g : walls){
				ng[g[0]][g[1]] = -2;
			}
			for(int i = 0;i < m;i++){
				for(int j = 0;j < n;j++){
					if(ng[i][j] == -1){
						for(int k = j-1;k >= 0 && ng[i][k] >= 0;k--){
							ng[i][k] = 0;
						}
						for(int k = j+1;k < n && ng[i][k] >= 0;k++){
							ng[i][k] = 0;
						}
						for(int k = i-1;k >= 0 && ng[k][j] >= 0;k--)ng[k][j] = 0;
						for(int k = i+1;k < m && ng[k][j] >= 0;k++)ng[k][j] = 0;
					}
				}
			}
			int ans = 0;
			for(int i = 0;i < m;i++){
				for(int v : ng[i]){
					if(v == 1)ans++;
				}
			}
			return ans;
		}
	}