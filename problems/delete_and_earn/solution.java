class Solution {
    public int deleteAndEarn(int[] nums) {
       int[] arr = new int[10000];
        int max = 0;
        for(int num : nums) {
            arr[num - 1] += num;
            max = Math.max(max, num);
        }       
        int prepre = 0;
        int pre = 0;
        for(int i = 0; i < max; i++) {                
            int cur = Math.max(prepre + arr[i], pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
        
    }
}