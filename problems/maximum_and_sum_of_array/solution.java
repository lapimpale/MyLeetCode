class Solution {
		public int maximumANDSum(int[] a, int m) {
			int[] dp = new int[1<<2*m];
			for(int i = 1;i < 1<<2*m;i++){
				int u = i>>>m;
				int l = i&(1<<m)-1;
				if((u&l) != u)continue;

				int num = Integer.bitCount(i)-1 < a.length ? a[Integer.bitCount(i)-1] : 0;
				for(int j = 0;j < m;j++){
					if(l<<~j<0){
						int bef = i;
						if(u<<~j<0){
							bef ^= 1<<j+m;
						}else{
							bef ^= 1<<j;
						}
						dp[i] = Math.max(dp[i], dp[bef] + (num&j+1));
//						tr(bef, i, num, j+1, dp[i]);
					}
				}
			}
			return dp[(1<<2*m)-1];
		}
	}