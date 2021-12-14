class Solution {
    public String reversePrefix(String word, char ch) {
        int x= word.indexOf(ch);
        if(x==-1) return word;
        StringBuilder ans = new StringBuilder();
        for(int i = x;i>=0;i--){
            ans.append(word.charAt(i));
        }
        ans.append(word.substring(x+1,word.length()));
        return ans.toString();
    }
}