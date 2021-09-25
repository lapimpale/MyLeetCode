class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        
        //calculate the initial ladder
        int i=1, maxLadder= 0 + nums[0];
        
        int minJumps=0;
        while(i<nums.length){
            
            int step= maxLadder-i+1;
            while(step!=0 && i<nums.length){
                maxLadder= Math.max(maxLadder, i+nums[i]);
                step--;
                i++;
            }
            minJumps++;
        }
        return minJumps;
    }
}