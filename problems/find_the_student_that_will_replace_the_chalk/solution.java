class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) {
            sum += c; 
        }
        k = (int)((long)k % sum);
        int count = 0;
        while (k > 0) {
            k -= chalk[count++];
        }
        return k == 0 ? count : count - 1;
    }
}