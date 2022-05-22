class Solution {
		public int minimumLines(int[][] a){
			int n = a.length;
			int ans = n-1;
			Arrays.sort(a, (x, y) -> {
				if (x[0] != y[0]) return x[0] - y[0];
				return (x[1] - y[1]);
			});

			for(int i = 1;i < n-1;i++){
				if(ccw(a[i-1], a[i], a[i+1]) == 0)ans--;
			}
			return ans;
		}
		public int ccw(int[] a, int[] b, int[] t){ 
            return Long.signum((long)(t[0]-a[0])*(b[1]-a[1])-(long)(b[0]-a[0])*(t[1]-a[1])); 
        }
	}