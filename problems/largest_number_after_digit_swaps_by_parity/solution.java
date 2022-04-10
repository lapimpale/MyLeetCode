class Solution {

	public int largestInteger(int num) {
		PriorityQueue<Integer> odd = new PriorityQueue<>(), even = new PriorityQueue<>();
		for (char c : ("" + num).toCharArray()) {
			(c % 2 > 0 ? odd : even).offer('0' - c);
		}
		int result = 0;
		for (char c : ("" + num).toCharArray()) {
			result = result * 10 - (c % 2 > 0 ? odd : even).poll();
		}
		return result;
	}
}