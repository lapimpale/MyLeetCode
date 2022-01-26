class Solution {
    public int rob(int[] nums) {
        int curMax = 0;
        int preMax = 0;
        for(int num: nums) {
            int temp = curMax;
            curMax = Math.max(num+preMax, curMax);
            preMax = temp;
        }

        return curMax;
    }
}