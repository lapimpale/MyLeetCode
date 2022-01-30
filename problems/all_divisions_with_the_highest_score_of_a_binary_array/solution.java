class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int s = 0;
        for(int u : nums){
            s += u;
        }
        List<Integer> can = new ArrayList<>();
        int max = s;
        can.add(0);
        int n = nums.length;
        for(int i = 1;i <= n;i++){
            if(nums[i-1] == 1)s--;
            if(nums[i-1] == 0)s++;
            if(s > max){
                max = s;
                can.clear();
                can.add(i);
            }else if(s == max){
                can.add(i);
            }
        }
        return can;
    }
}