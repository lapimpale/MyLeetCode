class Solution {
    public int rearrangeCharacters(String s, String target) {
        char[] f = new char[26];
        for(char c : target.toCharArray()){
            f[c-'a']++;
        }
        char[] fs = new char[26];
        for(char c : s.toCharArray()){
            fs[c-'a']++;
        }
        int ans = 99999999;
        for(int i = 0;i < 26;i++){
            if(f[i] > 0){
                ans = Math.min(ans, fs[i] / f[i]);
            }
        }
        return ans;
    }
}