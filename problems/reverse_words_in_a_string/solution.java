class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] words = s.split(" +");
        
        for(int i = words.length-1; i>=0;i--){
           sb = sb.append(words[i]);
           sb = sb.append(" ");
        }
        return sb.toString().trim();
    }
}