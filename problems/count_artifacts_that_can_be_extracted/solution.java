class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] dug = new boolean[n][n];
        for(int[] u: dig){
            dug[u[0]][u[1]] = true;
        }
        int ans = 0;
        outer:
        for(int[] a : artifacts){
            for(int i = a[0];i <= a[2];i++){
                for(int j = a[1];j <= a[3];j++){
                    if(!dug[i][j]){
                        continue outer;
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}