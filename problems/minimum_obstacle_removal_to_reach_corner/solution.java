class Solution {
		public int minimumObstacles(int[][] map) {
			int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			int n = map.length;
			int m = map[0].length;

			int[][] d = new int[n][m];
			int I = 999999999;
			for(int i = 0;i < n;i++) {
				Arrays.fill(d[i], I);
			}

			Deque<int[]> q = new ArrayDeque<int[]>();
			q.add(new int[]{0, 0});
			d[0][0] = 0;

			while(!q.isEmpty()){
				int[] cur = q.poll();
				int r = cur[0], c = cur[1];
				for(int k = 0;k < dr.length;k++) {
					int nr = r + dr[k], nc = c + dc[k];
					if(nr >= 0 && nr < n && nc >= 0 && nc < m){
						if(map[nr][nc] == 0 && d[nr][nc] > d[r][c]) {
							d[nr][nc] = d[r][c];
							q.addFirst(new int[]{nr, nc});
						}
						if(map[nr][nc] == 1 && d[nr][nc] > d[r][c] + 1) {
							d[nr][nc] = d[r][c] + 1;
							q.addLast(new int[]{nr, nc});
						}
					}
				}
			}
			return d[n-1][m-1];
		}

	}