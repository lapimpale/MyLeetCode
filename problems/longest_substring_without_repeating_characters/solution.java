class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
            
            Set<Character> set = new HashSet<Character>();
            
            int start = 0;
            int end   = 0;
            
            while(end < s.length()) {
                Character c = s.charAt(end);

                if(set.contains(c)) {
                    while(set.contains(c)){
                        set.remove(s.charAt(start++));
                    }
                }
                
                set.add(new Character(c));
                int len = end - start + 1; // Or equivalently, len = set.size();
                if(max < len) {
                    max = len;
                }
                end++;
            }
            
            return max;
    }
}