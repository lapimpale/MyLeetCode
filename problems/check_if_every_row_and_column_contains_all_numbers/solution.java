class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        HashSet<Integer> sum = new HashSet<>();
        for(int i = 0; i< n; i ++){
            HashSet<Integer> rhs = new HashSet<>();
            HashSet<Integer> chs = new HashSet<>();
            int total = 0;
            for(int j =0;j< n; j++){
                rhs.add(matrix[i][j]);
            }
            for(int j =0;j< n; j++){
                chs.add(matrix[j][i]);
            }
            for(int k : rhs) total+= k;
            for(int k : chs) total+= k;
            sum.add(total);
            System.out.println(total);
            }
        
        for(int k : sum)
        if(k!=(n*(n+1))) return false;
        return true;
    }
}