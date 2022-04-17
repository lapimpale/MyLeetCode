class Solution {
		public int longestPath(int[] par, String s) {
			int n = par.length;
			int[][] g  = parentToG(par);
			int[][] pars = parents(g, 0);
			int[] ord = pars[1];
			int[] dp = new int[n];
			int ans = 1;
			for(int i = n-1;i >= 0;i--){
				int cur = ord[i];
				int max1 = -999999;
				int max2 = -999999;
				for(int e : g[cur]){
					if(par[cur] == e)continue;
					if(s.charAt(e) == s.charAt(cur))continue;
					if(dp[e] > max1){
						max2 = max1;
						max1 = dp[e];
					}else if(dp[e] > max2){
						max2 = dp[e];
					}
				}
				ans = Math.max(ans, max1 + 1);
				ans = Math.max(ans, max1 + max2 + 1);
				dp[cur] = Math.max(1, max1 + 1);
			}
			return ans;
		}

		public int[][] parentToG(int[] par)
		{
			int n = par.length;
			int[] ct = new int[n];
			for(int i = 0;i < n;i++){
				if(par[i] >= 0){
					ct[i]++;
					ct[par[i]]++;
				}
			}
			int[][] g = new int[n][];
			for(int i = 0;i < n;i++){
				g[i] = new int[ct[i]];
			}
			for(int i = 0;i < n;i++){
				if(par[i] >= 0){
					g[par[i]][--ct[par[i]]] = i;
					g[i][--ct[i]] = par[i];
				}
			}
			return g;
		}

		public int[][] parents(int[][] g, int root) {
			int n = g.length;
			int[] par = new int[n];
			Arrays.fill(par, -1);

			int[] depth = new int[n];
			depth[0] = 0;

			int[] q = new int[n];
			q[0] = root;
			for (int p = 0, r = 1; p < r; p++) {
				int cur = q[p];
				for (int nex : g[cur]) {
					if (par[cur] != nex) {
						q[r++] = nex;
						par[nex] = cur;
						depth[nex] = depth[cur] + 1;
					}
				}
			}
			return new int[][]{par, q, depth};
		}


	}