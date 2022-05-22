class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = capacity[i] - rocks[i];
        Arrays.sort(a);
        int ad = additionalRocks;
        int ans = 0;
        for(int i = 0;i < n;i++){
            int u = Math.min(ad, a[i]);
            if(u == a[i]){
                ans++;
            }
            ad -= u;
        }
        return ans;
    }
}