class Solution {
    public long minimumRemoval(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        long s = 0;
        for(int v : a)s += v;
        long u = 0;
        long ans = s;
        for(int i = 0;i < n;i++){
            u += a[i];
            s -= a[i];
            ans = Math.min(ans, u + s - (long)(n-i) * a[i]);
        }
        return ans;
    }
}