class Solution {
    public int countHillValley(int[] nums) {
        int ct = 0;
        for(int i = 1;i < nums.length-1;i++){
            if(nums[i-1] < nums[i]){
                int j = i+1;
                for(;j < nums.length && nums[j] == nums[i];j++);
                if(j < nums.length && nums[i] > nums[j]){
                    ct++;
                }
                i = j-1;
            }
            if(nums[i-1] > nums[i]){
                int j = i+1;
                for(;j < nums.length && nums[j] == nums[i];j++);
                if(j < nums.length && nums[i] < nums[j]){
                    ct++;
                }
                i = j-1;
            }
        }
        return ct;
    }
}