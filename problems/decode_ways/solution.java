class Solution {
    public int numDecodings(String s) {
        int prev = 1, prevPrev = 0, res = 0;
        for (int i=1; i<=s.length(); i++) {
            int ones = s.charAt(i-1) - '0';
            int tens = i >= 2 ? s.charAt(i-2) - '0' : 0;
            int twoDigit = ones + 10*tens;
            if (ones == 0) {
                // If current char is 0, and it's 1st char or prev is 0 or prev > 2, return 0
                if (i == 1 || tens == 0 || tens > 2) {
                    return 0;
                }
                // else 0 is not usable alone, so combine with tens place, so ways is same as prev of prev
                res = prevPrev;
            } else if (tens == 0 || twoDigit > 26) {
                // ways same as prev
                res = prev;
            } else {
                // ways = summation of prev an prev-prev
                res = prev + prevPrev;
            }
            // adjust prev and prev-prev
            prevPrev = prev;
            prev = res;
        }
        return res;
    }
}