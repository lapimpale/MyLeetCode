class Solution {
    public String reverseWords(String str){
        String ans = "";
        String[] s = str.split(" +");
        for (int i = s.length - 1; i >= 0; i--)
        {
            ans += s[i] + " ";
        }
        return ans.trim();
    }
}