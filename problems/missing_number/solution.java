class Solution {
    public int missingNumber(int[] nums) {
       // Arrays.sort(nums);
        int res = nums[0];
        
        for (int i=0; i<nums.length;i++){
            int diff;
                diff = nums[i]- res;
            if(diff!=1) res = nums[i]+1;
            }
       //     return res;
    
     int sum = (nums.length * (nums.length + 1)) / 2;
        for(int n : nums){
            sum -= n;
        }
        
        return sum;
    }
}