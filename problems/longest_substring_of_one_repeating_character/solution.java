class Solution {
		public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
			SegmentTreeMergingMaxConsecutiveOneLength st = new SegmentTreeMergingMaxConsecutiveOneLength(s.toCharArray());
			int Q = queryIndices.length;
			int[] ret = new int[Q];
			for(int i = 0;i < Q;i++){
				st.update(queryIndices[i], queryCharacters.charAt(i));
				ret[i] = st.st[1][3];
			}
			return ret;
		}

		public class SegmentTreeMergingMaxConsecutiveOneLength {
			public int M, H, N;
			public int[][] st;
			public int I = Integer.MIN_VALUE/3 + 30000;

			public SegmentTreeMergingMaxConsecutiveOneLength(char[] a)
			{
				N = a.length;
				M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
				H = M>>>1;
				st = new int[M][6];
				for(int i = 0;i < H;i++){
					int v = i < N ? 1 : 0;
					Arrays.fill(st[H+i], v);
					if(i < N) {
						st[H + i][4] = st[H + i][5] = a[i] - 'a';
					}
				}
				for(int i = H-1;i >= 1;i--){
					propagate(i);
				}
			}

			private void propagate(int i)
			{
				int[] P = st[i], L = st[2*i], R = st[2*i+1];
				propNC(P, L, R);
			}

			private int[] propNC(int[] P, int[] L, int[] R)
			{
				P[0] = L[0] == L[1] && L[0] == L[2] && R[0] == R[1] && R[0] == R[2] && L[4] == R[4] ? L[0] + R[0] : 0;
				P[1] = L[0] == L[1] && L[0] == L[2] && L[4] == R[4] ? L[0] + R[1] : L[1];
				P[2] = R[0] == R[2] && R[0] == R[1] && L[5] == R[5] ? R[0] + L[2] : R[2];
				P[3] = Math.max(L[3], R[3]);
				if(L[5] == R[4])P[3] = Math.max(P[3], L[2]+R[1]);
				P[4] = L[4];
				P[5] = R[5];
				return P;
			}

			public void update(int pos, char v)
			{
				st[H+pos][4] = st[H+pos][5] = v-'a';
				for(int x = H+pos>>>1;x != 0;x>>>=1){
					propNC(st[x], st[2*x], st[2*x+1]);
				}
			}
		}

	}