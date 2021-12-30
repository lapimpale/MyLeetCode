class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem = 0;
        
        for(int length_N = 1; length_N <= k; length_N++){
            rem = (rem *10 + 1)% k;
            if(rem == 0){
                return length_N;
            }
        }
        return -1;
    }
}