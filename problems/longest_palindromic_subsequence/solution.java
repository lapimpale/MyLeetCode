class Solution {
    
    public int longestPalindromeSubseq(String s) {
         StringBuilder s1=new StringBuilder();
        s1.append(s);

        String s2= String.valueOf(s1.reverse());
        int m=s.length();
        int n=m;
         int[][]matrix=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0)
                    matrix[i][j]=0;
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    matrix[i][j]=  1+matrix[i-1][j-1];
                }
                else{
                    matrix[i][j]= Math.max(matrix[i-1][j],matrix[i][j-1]);

                }
            }
        }
        return matrix[m][n];
    }
}