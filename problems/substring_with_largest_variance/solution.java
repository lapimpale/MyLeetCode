class Solution {
    public int largestVariance(String s) {
        int result = 0;
		for (char c1 = 'a'; c1 <= 'z'; c1++) {
			for (char c2 = (char) (c1 + 1); c2 <= 'z'; c2++) {
				int index = 0, index1 = -1, index2 = -1, curr = 0, prev = 0, min = 0, max = 0;
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == c1) {
						index1 = i;
						curr++;
					} else if (s.charAt(i) == c2) {
						index2 = i;
						curr--;
					}
					for (; index < index1 && index < index2; index++) {
						if (s.charAt(index) == c1) {
							prev++;
						} else if (s.charAt(index) == c2) {
							prev--;
						}
						min = Math.min(min, prev);
						max = Math.max(max, prev);
					}
					if (index1 >= 0 && index2 >= 0) {
						result = Math.max(result, Math.max(curr - min, max - curr));
					}
				}
			}
		}
		return result;
    }
}