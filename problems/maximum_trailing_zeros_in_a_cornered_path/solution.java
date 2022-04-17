class Solution {
		public int count(int[][] a) {
			int n = a.length, m = a[0].length;
			int[][] twor = new int[n][m];
			int[][] fiver = new int[n][m];
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					if(j-1 >= 0){
						twor[i][j] = twor[i][j-1];
						fiver[i][j] = fiver[i][j-1];
					}
					int v = a[i][j];
					while(v % 2 == 0){
						v /= 2;
						twor[i][j]++;
					}
					while(v % 5 == 0){
						v /= 5;
						fiver[i][j]++;
					}
				}
			}
			int[][] twoc = new int[n][m];
			int[][] fivec = new int[n][m];
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					if(i-1 >= 0){
						twoc[i][j] = twoc[i-1][j];
						fivec[i][j] = fivec[i-1][j];
					}
					int v = a[i][j];
					while(v % 2 == 0){
						v /= 2;
						twoc[i][j]++;
					}
					while(v % 5 == 0){
						v /= 5;
						fivec[i][j]++;
					}
				}
			}
			int max = 0;
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					int two = twor[i][j] + twoc[i][j];
					int five = fiver[i][j] + fivec[i][j];
					int v = a[i][j];
					while(v % 2 == 0){
						v /= 2;
						two--;
					}
					while(v % 5 == 0){
						v /= 5;
						five--;
					}
					max = Math.max(max, Math.min(two, five));
				}
			}
			return max;
		}

		public int maxTrailingZeros(int[][] a) {
			int max = 0;
			for(int i = 0;i < 4;i++){
				a = rot(a);
				max = Math.max(max, count(a));
			}
			return max;
		}

		public int[][] rot(int[][] a)
		{
			int n = a.length, m = a[0].length;
			int[][] b = new int[m][n];
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					b[j][n-1-i] = a[i][j];
				}
			}
			return b;
		}

	}