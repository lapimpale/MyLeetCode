class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        int count = 0;
        for (int num : nums){
            totalSum += num;
        }
        long currentSum = 0;
        for(int i = 0; i< nums.length-1; i++){
            currentSum = currentSum + nums[i];
            long remender = totalSum - currentSum;
            
            if(currentSum >= remender){
                System.out.println(currentSum + " " + remender);
                count++;
            }
            
        }
        return count;
    }
}