class Solution {
		public int num(char c)
		{
			if(c == '7' || c == '9')return 4;
			return 3;
		}

		public int countTexts(String pressedKeys) {
			char[] s = pressedKeys.toCharArray();
			int n = s.length;
			final int mod = 1000000007;
			long[] dp = new long[n+1];
			dp[0] = 1;
			for(int i = 1;i <= n;i++){
				char l = s[i-1];
				for(int j = 1;j <= num(l) && i-1-j+1 >= 0 && l == s[i-1-j+1];j++){
					dp[i] += dp[i-j];
				}
				dp[i] %= mod;
			}
			return (int)dp[n];
		}
	}