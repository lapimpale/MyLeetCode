class Solution {

	public int largestCombination(int[] candidates) {
		int max = 0;
		for (int i = 0; i < 24; i++) {
			int count = 0;
			for (int candidate : candidates) {
				max = Math.max(max, count += (candidate & 1 << i) > 0 ? 1 : 0);
			}
		}
		return max;
	}
}