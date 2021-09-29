class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int[] dp = new int[prices.length+1];
        int lmax = prices[prices.length-1];
        
        for(int i=prices.length-2;i>=0;i--){
            dp[i] = Math.max(dp[i+1],lmax-prices[i]);
            lmax = Math.max(dp[i+2]+prices[i],lmax);
        }
        return dp[0];
    }
}