class Solution {
    public int findMin(int[] nums) {
       int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++){
            if(res > nums[i]) res= nums[i];
            }
        return res;
    }
}