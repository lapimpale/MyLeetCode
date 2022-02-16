class Solution {
    public double myPow(double x, long n) {
       double res = 1;     // Initialize result
        long p = Math.abs(n); // converting to positive value since using binary expo
  
        while (p > 0){       
            // If p is odd, multiply x with result
            if((p & 1) != 0) res = res * x;
  
            // p must be even now
            p = p>> 1; // p = p/2
            x = x * x;  // Change x to x^2
        }
        return n<0?1/res:res;// checking if n is negative return 1/n or else n.
    }
}