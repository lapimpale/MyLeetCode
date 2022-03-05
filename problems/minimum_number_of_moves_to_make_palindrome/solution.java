class Solution {
    public void swap(StringBuilder s,int i,int j){
        char ch = s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,ch);
    }
    public int minMovesToMakePalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int ans = 0,si = 0,ei = sb.length() - 1;
        
        while(si < ei){
            if(sb.charAt(si) != sb.charAt(ei)){
                int l = si + 1,r = ei - 1;
                
                while(sb.charAt(l) != sb.charAt(ei)) l++;
                while(sb.charAt(r) != sb.charAt(si)) r--;
                
                if(l - si < ei - r){
                    for(int i = l;i > si;i--) {
                        swap(sb,i,i - 1);
                        ans++;
                    }
                }else{
                    for(int i = r;i < ei;i++) {
                        swap(sb,i,i + 1);
                        ans++;
                    }
                }
            }
            si++;
            ei--;
        }
        return ans;
    }
}