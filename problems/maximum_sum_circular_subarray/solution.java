class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
          int n = nums.length;
        
        if(n==1) return nums[0];
        
        // Kadane's Algo - Find contiguous subarray with maximum sum
        // Reverse Kadane's Algo - Find contiguous subarray with minimum sum
        
        int curr_max = nums[0];
        int curr_min = nums[0];
        
        int ans_max = nums[0];
        int ans_min = nums[0];
        
        int total = nums[0];   //Find total sum
        
        for(int i=1;i<n;i++){
            
            //For calculating total sum
            total += nums[i];
            
            
            //finding max sum subarray
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            ans_max = Math.max(ans_max, curr_max);
            
            //finding min sub subarray
            curr_min = Math.min(nums[i], curr_min + nums[i]);
            ans_min = Math.min(ans_min, curr_min);
        }
        
        //If all the elements of the array are not negative
        if(ans_max > 0){
            
            return Math.max(ans_max, total-ans_min);
        }
        
        //If all the elements of the array are negative
        return ans_max;
    }
}