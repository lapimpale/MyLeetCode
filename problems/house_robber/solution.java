class Solution {
    public int rob(int[] nums) {
    
	// We first create an array of size nums
        int[] dp = new int[nums.length];
        dp = nums;
		// If there´s only one house we return the value
		//of the only house, we use an if here because we don´t the algo will
		// show a null pointer error later
        if(nums.length == 1){
            return  nums[0];
        }
        dp[1] = Math.max(nums[0],nums[1]);
		//We basically iterate from 2 to n in the array and store
		// if the value of the n house + the max till the house n-2 OR
		// the max value till the house n-1
        for(int i = 2 ; i< nums.length; i++){
            int temp = nums[i];
            dp[i] = Math.max(dp[i-2] + temp , dp[i-1]);
        }
        return dp[dp.length-1];
    }
}