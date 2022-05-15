class CountIntervals {
	private TreeMap<Integer, Integer> map = new TreeMap<>(Map.of(0, 0));
	private int count;

	public void add(int left, int right) {
		for (Map.Entry<Integer, Integer> entry : Set.copyOf(map.subMap(left + 1, right + 1).entrySet())) {
			if (entry.getValue() > right) {
				map.put(right + 1, entry.getValue());
			}
			count -= Math.min(right, entry.getValue()) - entry.getKey() + 1;
			map.remove(entry.getKey());
		}
		Map.Entry<Integer, Integer> entry = map.floorEntry(left).getValue() < left ? Map.entry(left, left - 1)
				: map.floorEntry(left);
		count += Math.max(0, right - entry.getValue());
		map.put(entry.getKey(), Math.max(right, entry.getValue()));
	}

	public int count() {
		return count;
	}
}
/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */