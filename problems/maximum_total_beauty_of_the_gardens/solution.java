class Solution {

	public long maximumBeauty(int[] flowers, long newFlowers, int target, long full, int partial) {
		Arrays.sort(flowers);
		TreeMap<Long, Integer> map = new TreeMap<>(Map.of(Long.MAX_VALUE, flowers.length));
		long max = 0, sum[] = new long[flowers.length + 1];
		for (int i = 0; i < flowers.length; i++) {
			sum[i + 1] = flowers[i] + sum[i];
			map.putIfAbsent((long) flowers[i], i);
		}
		for (int i = flowers.length - 1; i >= 0 && newFlowers > 0; i--) {
			if (flowers[i] < target) {
				long left = 0, right = target - 1;
				while (left < right) {
					long mid = (left + right + 1) / 2, index = Math.min(i + 1, map.higherEntry(mid).getValue());
					if (mid * index - sum[(int) index] > newFlowers) {
						right = mid - 1;
					} else {
						left = mid;
					}
				}
				max = Math.max(max, full * (flowers.length - 1 - i) + partial * left);
			}
			newFlowers -= Math.max(0, target - flowers[i]);
		}
		return Math.max(max, newFlowers < 0 ? 0 : full * flowers.length);
	}
}