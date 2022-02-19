class Solution {
		public long goodTriplets(int[] a, int[] b) {
			int n = a.length;
			int[] ib = new int[n];
			for(int i = 0;i < n;i++){
				ib[b[i]] = i;
			}
			int[] ft = new int[n+3];
			long ans = 0;
			for(int i = 0;i < n;i++){
				int v = a[i];
				int pos = ib[v];
				long L = sumFenwick(ft, pos);
				long R = (n-1-pos) - (sumFenwick(ft, n-1) - sumFenwick(ft, pos));
				ans += L*R;
				addFenwick(ft, pos, 1);
			}
			return ans;
		}

		public int sumFenwick(int[] ft, int i)
		{
			int sum = 0;
			for(i++;i > 0;i -= i&-i)sum += ft[i];
			return sum;
		}

		public void addFenwick(int[] ft, int i, int v)
		{
			if(v == 0 || i < 0)return;
			int n = ft.length;
			for(i++;i < n;i += i&-i)ft[i] += v;
		}
	}