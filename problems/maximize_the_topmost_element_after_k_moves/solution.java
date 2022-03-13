class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(n == 1){
            return k % 2 == 1 ? -1 : nums[0];
        }
        int max = 0;
        for(int i = 0;i < n;i++){
            if(k == i || k >= i+2){
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }
}