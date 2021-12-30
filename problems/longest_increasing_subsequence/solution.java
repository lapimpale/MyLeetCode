class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (j == 0 || nums[i] > nums[j - 1]) {
                    dp[j] = Math.max(1 + dp[i + 1], dp[j]);
                }
            }
        }
        
        return dp[0];
    }
}