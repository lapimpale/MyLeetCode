class Solution {
    public int maxSubArray(int[] nums) {
        int sol=nums[0];
        int maxSum =0;
        for(int i=0; i<nums.length;i++){
            if(maxSum <0) maxSum =0;
            
            maxSum+= nums[i];
            if(maxSum>sol) sol = maxSum;
            }
            
            return sol;
    }
}