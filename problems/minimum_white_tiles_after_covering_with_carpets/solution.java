class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char f[] = floor.toCharArray();
        int dp[][] = new int[f.length][numCarpets+1];
        for(int i=0;i<f.length;i++) {
        	Arrays.fill(dp[i], -1);
        }
        int res = find(0, f, numCarpets, carpetLen, dp);
        return res;
    }
	private int find(int i, char[] f, int n, int l, int dp[][]) {
		if(i >= f.length) return 0;
		
		if(dp[i][n] != -1) return dp[i][n];
		
		int ans = 0;
		if(f[i] == '1') ans++;
		ans = ans + find(i+1, f, n, l, dp);
		if(n>0) ans = Math.min(ans, find(i+l, f, n-1, l, dp));
		
		return dp[i][n] = ans;
	}
}