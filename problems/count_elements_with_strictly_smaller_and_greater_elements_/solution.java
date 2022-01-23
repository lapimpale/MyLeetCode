class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int each : nums){
            min = Math.min(min, each);
            max = Math.max(max, each);
        }
        int count = 0;
        for(int each : nums){
            if(each > min && each < max) count++;
        } 
        return count;
    }
}