class Solution {
		boolean ok(int[][] shut, int h, int[][] a)
		{
			int n = shut.length, m = shut[0].length;
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[]{0, 0});
			int[][] ds = new int[n][m];
			for(int i = 0;i < n;i++)Arrays.fill(ds[i], 1999999999);
			ds[0][0] = h;
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			while(!q.isEmpty()){
				int[] cur = q.poll();
				for(int k = 0;k < 4;k++){
					int nr = cur[0] + dr[k], nc = cur[1] + dc[k];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && a[nr][nc] == 0 && ds[nr][nc] > ds[cur[0]][cur[1]] + 1){
						int pl = nr == n-1 && nc == m-1 ? 1 : 0;
						if(ds[cur[0]][cur[1]] + 1 < shut[nr][nc] + pl) {
							ds[nr][nc] = ds[cur[0]][cur[1]] + 1;
							q.add(new int[]{nr, nc});
						}
					}
				}
			}
			return (ds[n-1][m-1] < 1e9);
		}

		public int maximumMinutes(int[][] a) {
			int n = a.length, m = a[0].length;
			Queue<int[]> q = new ArrayDeque<>();
			int[][] ds = new int[n][m];
			for(int i = 0;i < n;i++)Arrays.fill(ds[i], 1999999999);
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					if(a[i][j] == 1){
						ds[i][j] = 0;
						q.add(new int[]{i, j});
					}
				}
			}
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			while(!q.isEmpty()){
				int[] cur = q.poll();
				for(int k = 0;k < 4;k++){
					int nr = cur[0] + dr[k], nc = cur[1] + dc[k];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m && a[nr][nc] == 0 && ds[nr][nc] > ds[cur[0]][cur[1]] + 1){
						ds[nr][nc] = ds[cur[0]][cur[1]] + 1;
						q.add(new int[]{nr, nc});
					}
				}
			}

			int low = -1, high = 100000007;
			while(high - low > 1){
				int h = high+low>>1;
				if(ok(ds, h, a)){
					low = h;
				}else{
					high = h;
				}
			}
			if(low > 1e8)return 1000000000;
			return low;
		}
	}