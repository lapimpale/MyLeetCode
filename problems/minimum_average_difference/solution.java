class Solution {
    public int minimumAverageDifference(int[] nums) {
        long totalSum = 0;
        
        for(int num : nums){
            totalSum += num;
        }
        
        int ans = 0;
        long sum = 0;
        long avgDiff = 0;
        int minAvgDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            long partA = 0;
            long partB = 0;
            
            partA = Math.abs(sum/(i+1));
            
            if(i<nums.length-1){
            partB = Math.abs((totalSum-sum)/(nums.length-1-i));
            }
            avgDiff = Math.abs(partA - partB);
            if(minAvgDiff > avgDiff){
                minAvgDiff = (int) avgDiff;
                ans = i;
            }
        }
        return ans;
    }
}