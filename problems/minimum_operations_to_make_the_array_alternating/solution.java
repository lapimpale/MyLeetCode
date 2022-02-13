class Solution {
    public int[] go(int[] f0)
    {
        int m01 = -1, a01 = 0;
        int m02 = -1, a02 = 0;
        for(int i = 0;i < 100001;i++){
            if(f0[i] > m01){
                m02 = m01;
                a02 = a01;
                m01 = f0[i];
                a01 = i;
            }else if(f0[i] > m02){
                m02 = f0[i];
                a02 = i;
            }
        }
        return new int[]{m01, a01, m02, a02};
    }
    
    public int minimumOperations(int[] a) {
        int n = a.length;
        int[] f0 = new int[100001];
        int[] f1 = new int[100001];
        for(int i = 0;i < n;i+=2){
            f0[a[i]]++;
        }
        for(int i = 1;i < n;i+=2){
            f1[a[i]]++;
        }
        int[] g0 = go(f0);
        int[] g1 = go(f1);
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < 4;i+=2){
            for(int j = 0;j < 4;j+=2){
                if(g0[i+1] != g1[j+1]){
                    ans = Math.min(ans, n - (g0[i] + g1[j]));
                }
            }
        }
        return ans;
    }
}