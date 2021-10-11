class Solution {
    public int coinChange(int[] arr, int total) {
        int[] dp = new int[total+1];
        Arrays.fill(dp,total+1);
        dp[0] = 0;
        for(int i=0;i<=total;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]<=i){
                    dp[i] = Math.min(dp[i],1+dp[i-arr[j]]);
                }
            }
        }
        return dp[total] > total ? -1 : dp[total];
    }
}