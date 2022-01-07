class Solution {
    public int titleToNumber(String columnTitle) {
        
        int n=columnTitle.length(),c=0;
     for(int i=0;i<n;i++)
      c+=Math.pow(26,n-i-1)*(columnTitle.charAt(i)-'A'+1);
      return c;
    }
}