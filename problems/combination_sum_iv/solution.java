class Solution {
    public int combinationSum4(int[] nums, int target) {
         int[] sum = new int[target+1];
        sum[0] = 1;
        for(int i=1; i<target+1; i++)
            for(int j=0; j<nums.length; j++)
                if(i-nums[j] >= 0)
                    sum[i] += sum[i-nums[j]];
        return sum[target];
    }
}