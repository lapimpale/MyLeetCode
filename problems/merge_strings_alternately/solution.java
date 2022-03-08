class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        String mergedString = "";
        for(int i = 0; i< 100; i++){
            if(i<len1) mergedString += word1.charAt(i);
            
            if(i<len2) mergedString += word2.charAt(i);
        }
        
        return mergedString;
    }
}