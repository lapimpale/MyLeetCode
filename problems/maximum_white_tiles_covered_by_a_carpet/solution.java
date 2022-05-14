import java.lang.Math;
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (o, p) -> o[0] - p[0]);
		TreeMap<Integer, int[]> map = new TreeMap<>(Map.of(tiles[0][0], new int[2]));
		for (int i = 1; i < tiles.length; i++) {
			map.put(tiles[i][0],
					new int[] { map.lastEntry().getValue()[0] + tiles[i - 1][1] - tiles[i - 1][0] + 1, i });
		}
		int max = 0;
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			int[] value = map.lowerEntry(entry.getKey() + carpetLen).getValue();
			max = Math.max(max, value[0] - entry.getValue()[0]
					+ Math.min(tiles[value[1]][1] + 1, entry.getKey() + carpetLen) - tiles[value[1]][0]);
		}
		return max;
	}
}