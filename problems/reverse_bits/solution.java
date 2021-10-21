public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for(int i=0; i<32; i++) {
            // left shift result and set right-most bit
            result = result<<1 | n&1;
            // right shift n for further right-most bit inspection
            n >>= 1;
        }
        return result;
    }
}