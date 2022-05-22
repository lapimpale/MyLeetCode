class Solution {
		public int totalStrength(int[] a) {
			final int mod = 1000000007;
			int n = a.length;

			long[] cum = new long[n+1];
			for(int i = 0;i < n;i++){
				cum[i+1] = cum[i] + a[i];
				cum[i+1] %= mod;
			}

			long[] cum2 = new long[n+2];
			for(int i = 0;i <= n;i++){
				cum2[i+1] = cum2[i] + cum[i];
				cum2[i+1] %= mod;
			}

			long[] sum = {0L, 0L};
			ContourStack cs = new ContourStack(false, (l, r, v) -> {
				sum[0] += (cum2[r] - cum2[l] + mod) % mod * v;
				sum[0] %= mod;
				sum[1] += (r-l) * v;
				sum[1] %= mod;
			});
			long ans = 0;
			int p = 0;
			for(int v : a){
				cs.add(v);
				p++;
				ans += sum[1] * cum[p] - sum[0];
				ans %= mod;
			}
			if(ans < 0)ans += mod;
			return (int)ans;
		}

		public class ContourStack {
			public int p, sp;
			public int[] stack;
			public long[] a;
			public boolean max;
			public WRangeConsumer cons;

			@FunctionalInterface
			public interface WRangeConsumer {
				void f(int l, int r, long v);
			}

			public ContourStack(boolean max, WRangeConsumer cons) {
				this.max = max;
				this.cons = cons;
				a = new long[1];
				stack = new int[1];
				p = sp = 0;
			}

			public void add(long v) {
				while (sp > 0 && (max ? a[sp - 1] <= v : a[sp - 1] >= v)) {
					cons.f(sp - 2 >= 0 ? stack[sp - 2] + 1 : 0, stack[sp - 1] + 1, -a[sp - 1]);
					sp--;
				}

				if (sp == stack.length) {
					stack = Arrays.copyOf(stack, sp * 2);
					a = Arrays.copyOf(a, sp * 2);
				}
				stack[sp] = p;
				a[sp++] = v;
				cons.f(sp - 2 >= 0 ? stack[sp - 2] + 1 : 0, p + 1, v);
				p++;
			}

			@Override
			public String toString() {
				return "MaxStack{" +
						"p=" + p +
						", sp=" + sp +
						", a=" + Arrays.toString(Arrays.copyOf(a, sp)) +
						", stack=" + Arrays.toString(Arrays.copyOf(stack, sp)) +
						'}';
			}

		}
	}