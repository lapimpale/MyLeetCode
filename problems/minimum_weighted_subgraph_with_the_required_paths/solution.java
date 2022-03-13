class Solution {
		public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
			int m = edges.length;
			int[] from = new int[m];
			int[] to = new int[m];
			int[] ws = new int[m];
			for(int i = 0;i < m;i++){
				from[i] = edges[i][0];
				to[i] = edges[i][1];
				ws[i] = edges[i][2];
			}
			int[][][] g = packWD(n, from, to, ws);
			long[] ts1 = dijkl(g, src1);
			long[] ts2 = dijkl(g, src2);
			int[][][] ig = packWD(n, to, from, ws);
			long[] td = dijkl(ig, dest);
			long ans = Long.MAX_VALUE;
			for(int i = 0;i < n;i++){
				ans = Math.min(ans, ts1[i] + ts2[i] + td[i]);
			}
			if(ans > 1e11){
				return -1;
			}else{
				return ans;
			}
		}

		public long[] dijkl(int[][][] g, int from)
		{
			int n = g.length;
			long[] td = new long[n];

			Arrays.fill(td, Long.MAX_VALUE / 5);
			MinHeapL q = new MinHeapL(n);
			q.add(from, 0);
			td[from] = 0;

			while(q.size() > 0){
				int cur = q.argmin();
				q.remove(cur);

				for(int[] e : g[cur]){
					int next = e[0];
					long nd = td[cur] + e[1];
					if(nd < td[next]){
						td[next] = nd;
						q.update(next, nd);
					}
				}
			}

			return td;
		}

		public class MinHeapL {
			public long[] a;
			public int[] map;
			public int[] imap;
			public int n;
			public int pos;
			public long INF = Long.MAX_VALUE;

			public MinHeapL(int m)
			{
				n = Integer.highestOneBit((m+1)<<1);
				a = new long[n];
				map = new int[n];
				imap = new int[n];
				Arrays.fill(a, INF);
				Arrays.fill(map, -1);
				Arrays.fill(imap, -1);
				pos = 1;
			}

			public long add(int ind, long x)
			{
				int ret = imap[ind];
				if(imap[ind] < 0){
					a[pos] = x; map[pos] = ind; imap[ind] = pos;
					pos++;
					up(pos-1);
				}
				return ret != -1 ? a[ret] : x;
			}

			public long update(int ind, long x)
			{
				int ret = imap[ind];
				if(imap[ind] < 0){
					a[pos] = x; map[pos] = ind; imap[ind] = pos;
					pos++;
					up(pos-1);
				}else{
					a[ret] = x;
					up(ret);
					down(ret);
				}
				return x;
			}

			public long remove(int ind)
			{
				if(pos == 1)return INF;
				if(imap[ind] == -1)return INF;

				pos--;
				int rem = imap[ind];
				long ret = a[rem];
				map[rem] = map[pos];
				imap[map[pos]] = rem;
				imap[ind] = -1;
				a[rem] = a[pos];
				a[pos] = INF;
				map[pos] = -1;

				up(rem);
				down(rem);
				return ret;
			}

			public long min() { return a[1]; }
			public int argmin() { return map[1]; }
			public int size() {	return pos-1; }
			public long get(int ind){ return a[imap[ind]]; }

			private void up(int cur)
			{
				//		for(int c = cur, p = c>>>1;p >= 1 && (a[p] > a[c] || a[p] == a[c] && map[p] > map[c]);c>>>=1, p>>>=1){
				for(int c = cur, p = c>>>1;p >= 1 && a[p] > a[c];c>>>=1, p>>>=1){
					long d = a[p]; a[p] = a[c]; a[c] = d;
					int e = imap[map[p]]; imap[map[p]] = imap[map[c]]; imap[map[c]] = e;
					e = map[p]; map[p] = map[c]; map[c] = e;
				}
			}

			private void down(int cur)
			{
				for(int c = cur;2*c < pos;){
					//			int b = a[2*c] < a[2*c+1] || a[2*c] == a[2*c+1] && map[2*c] < map[2*c+1] ? 2*c : 2*c+1;
					//			if(a[b] < a[c] || a[b] == a[c] && map[b] < map[c]){
					int b = a[2*c] < a[2*c+1] ? 2*c : 2*c+1;
					if(a[b] < a[c]){
						long d = a[c]; a[c] = a[b]; a[b] = d;
						int e = imap[map[c]]; imap[map[c]] = imap[map[b]]; imap[map[b]] = e;
						e = map[c]; map[c] = map[b]; map[b] = e;
						c = b;
					}else{
						break;
					}
				}
			}
		}



		public int[][][] packWD(int n, int[] from, int[] to, int[] w) {
			return packWD(n, from, to, w, from.length);
		}

		public int[][][] packWD(int n, int[] from, int[] to, int[] w, int sup) {
			int[][][] g = new int[n][][];
			int[] p = new int[n];
			for (int i = 0; i < sup; i++) p[from[i]]++;
			for (int i = 0; i < n; i++) g[i] = new int[p[i]][2];
			for (int i = 0; i < sup; i++) {
				--p[from[i]];
				g[from[i]][p[from[i]]][0] = to[i];
				g[from[i]][p[from[i]]][1] = w[i];
			}
			return g;
		}

	}