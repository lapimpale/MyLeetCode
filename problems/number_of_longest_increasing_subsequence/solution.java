class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, ans = 0, len = 1;
        int [] dp = new int[n]; // dp[i] -> len of lis ending at index i
        int [] temp = new int[n]; // temp[i] -> # of lis ending at index i
        Arrays.fill(dp, 1); Arrays.fill(temp, 1); 
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (nums[i]>nums[j]) {
                    if (dp[j]+1>dp[i]) {
                        dp[i] = dp[j]+1;
                        temp[i] = temp[j];
                    }
                    else if(dp[j]+1==dp[i]) temp[i]+=temp[j];
                    if (dp[i]>len) {
                        len = dp[i];
                        ans = 0;
                    }
                }
            }
            if (dp[i]==len) ans += temp[i];
        }
        return ans;
    }
}