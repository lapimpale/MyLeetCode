class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int i;

        // loop finding minimum value
        for(i=1; i < nums.length; i++){
            if(Math.abs(nums[i]) < Math.abs(min)){
                min = nums[i];
            }
        }
        
        for(int j = 0; j< nums.length;j++){
            if(nums[j] == Math.abs(min))
                min = nums[j];
        }
        return min;
    }
}