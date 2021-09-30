class Solution {
        Set<String> tried = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        
        for(String word: wordDict) {
            if(s.startsWith(word) && !tried.contains(s.substring(word.length()))) {
                String newS = s.substring(word.length());
                boolean success = wordBreak(newS, wordDict);
                if(success) return true;
                tried.add(newS);
            }
        }
        
        return false;
    }
}