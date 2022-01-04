class Solution {
    public int findComplement(int num) {
         //base case
        if(num == 0) return 1;
         // calculating the mask
    int x = num;     // say num = 100000
      x |= x >> 1;    // 100000 | 010000 = 110000
      x |= x >> 2;    // 110000 | 001100 = 111100
      x |= x >> 4;    // 111100 | 000011 = 111111
      x |= x >> 8;    // 111111 | 000000 = 111111
      x |= x >> 16;    // 111111 | 000000 = 111111
  
    return (num ^ x); // 100000 | 111111 = 011111
    }
}