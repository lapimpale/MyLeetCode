class Solution {
    public long mostPoints(int[][] arr) {
        int n=arr.length;
        long[] dp=new long[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                dp[i]=arr[i][0];
                continue;
            }
            if(arr[i][1]+i+1 >= n){
                dp[i]=Math.max(arr[i][0],dp[i+1]);
            }
            else{
                dp[i]=Math.max(arr[i][0]+dp[i+arr[i][1]+1],dp[i+1]);
            }
        }
        return dp[0];
    }
   
}