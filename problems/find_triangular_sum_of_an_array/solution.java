class Solution {
    public int triangularSum(int[] nums) {
        
        for(int j =nums.length-1; j>0; j--){
            for(int i = 0; i < nums.length-1;i++){
                nums[i]=(nums[i] + nums[i+1]) % 10;
            }
        }
        
        //System.out.println(Arrays.toString(nums));
        return nums[0];
    }
}