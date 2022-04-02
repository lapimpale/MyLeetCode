class Solution {
    public int minBitFlips(int start, int goal) {
         // To store the required count
    int count = 0;
 
    // Loop until both of them become zero
    while (start > 0 || goal > 0)
    {
 
        // Store the last bits in a
        // as well as b
        int last_bit_start = start & 1;
        int last_bit_goal = goal & 1;
 
        // If the current bit is not same
        // in both the integers
        if (last_bit_start != last_bit_goal)
            count++;
 
        // Right shift both the integers by 1
        start = start >> 1;
        goal = goal >> 1;
    }
 
    // Return the count
    return count;
    }
}