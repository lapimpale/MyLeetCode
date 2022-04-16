class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000;
        
        while(left < right){
            int mid = left + (right - left)/2;
            int sum = 0;
            for(int i : nums){
                sum += (i+mid-1)/mid;
            }
            if(sum <= threshold){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}