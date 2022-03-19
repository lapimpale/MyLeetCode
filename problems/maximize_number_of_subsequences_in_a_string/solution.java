class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char a[] = text.toCharArray();
        char p[] = pattern.toCharArray();
        long prev = 1;
        long ret = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == p[1]) prev++;
        }
        for(int i=0;i<a.length;i++){            
            if(a[i] == p[1]) prev--;
            if(a[i] == p[0]) ret = ret + prev;
        }
        // System.out.println(prev+" "+ret);
        long ans = 0;
        prev = 1;
        for(int i=0;i<a.length;i++){
            if(a[i] == p[0]) prev++;
        }
        for(int i=a.length-1;i>=0;i--){            
            if(a[i] == p[0]) prev--;
            if(a[i] == p[1]) ans = ans + prev;
        }
        // System.out.println(prev+" "+ans);
        return Math.max(ans, ret);
    }
}