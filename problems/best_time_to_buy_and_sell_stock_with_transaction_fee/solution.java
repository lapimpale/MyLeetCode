class Solution {
    public int maxProfit(int[] prices, int fee) {
      int n = prices.length, INF = (int)1e8;
    int[][] f = new int[n][2];
    for (int i = 0; i < n; i++) 
        for (int j = 0; j < 2; j++) f[i][j] = -INF;
    f[0][1] = -prices[0];
    f[0][0] = 0;
    for (int i = 1; i < n; i++) {
        f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i] - fee);
        f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
    }
    return Math.max(f[n - 1][0], f[n - 1][1]);  
    }
}