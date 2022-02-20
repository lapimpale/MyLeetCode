class Solution {
		public long coutPairs(int[] nums, int k) {
//			long fans = 0;
//			for(int i = 0;i < nums.length;i++){
//				for(int j = i+1;j < nums.length;j++){
//					if((long)nums[i] * nums[j] % k == 0){
//						fans++;
//					}
//				}
//			}

			int[] f = new int[100001];
			for(int v : nums){
				f[v]++;
			}
			int[] g = new int[100001];
			for(int i = 1;i <= 100000;i++){
				for(int j = i;j <= 100000;j+=i){
					g[i] += f[j];
				}
			}
			long ans = 0;
			for(int i = 1;i <= 100000;i++){
				int u = k / gcd(i, k);
				ans += (long)g[u] * f[i];
			}
			for(int i = 1;i <= 100000;i++){
				if((long)i*i % k == 0){
					ans -= f[i] * f[i];
					ans += (long)f[i] * (f[i]-1);
				}
			}
//			assert fans == ans/2;
			return ans/2;
		}

		public int gcd(int a, int b) {
			while (b > 0) {
				int c = a;
				a = b;
				b = c % b;
			}
			return a;
		}
	}