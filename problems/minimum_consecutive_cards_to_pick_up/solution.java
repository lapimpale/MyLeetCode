class Solution {

	public int minimumCardPickup(int[] cards) {
		Integer index[] = new Integer[1000001], min = Integer.MAX_VALUE;
		for (int i = 0; i < cards.length; index[cards[i]] = i++) {
			min = Math.min(min, index[cards[i]] == null ? Integer.MAX_VALUE : i - index[cards[i]] + 1);
		}
		return min < Integer.MAX_VALUE ? min : -1;
	}
}