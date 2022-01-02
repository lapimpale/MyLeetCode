class Solution {
    public int maximumInvitations(int[] fav) {
        int n = fav.length;
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            rev.add(new ArrayList<>());
        for (int i = 0; i < n; ++i)
            rev.get(fav[i]).add(i);
        int twos = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        long[] vis = new long[n];
        for (int i = 0; i < n; ++i) {
            if (fav[fav[i]]==i) {
                q.add(i);
                vis[i] = -1;
            }
        }
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            ArrayDeque<Integer> q2 = new ArrayDeque<>();
            q2.add(u);
            int max = 0;
            while (!q2.isEmpty()) {
                int uu = q2.removeFirst();
                max = Math.max(max,(int)(-vis[uu]));
                //System.out.println(max+" "+uu+" "+u);
                for (int vv : rev.get(uu)) {
                    if (vis[vv]==0) {
                        vis[vv] = vis[uu]-1;
                        q2.add(vv);
                    }
                }
            }
            twos += max;
        }
        int ans = twos;
        for (int i = 0; i < n; ++i) {
            if (vis[i]!=0)
                continue;
            q.add(i);
            int ct = 0;
            while (!q.isEmpty()) {
                ++ct;
                int u = q.removeFirst();
                vis[u] = i;
                vis[u]<<=32;
                vis[u] += ct;
                int v = fav[u];
                if (vis[v]!=0) {
                    if ((vis[v]>>32)==i) {
                        ans = Math.max(ans, (int)(ct+1-vis[v]));
                        continue;
                    } else {
                        continue;
                    }
                }
                q.add(v);
            }
        }
        return ans;
    }
}