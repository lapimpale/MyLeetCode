class Solution {

	public int maximumScore(int[] scores, int[][] edges) {
		PriorityQueue<Integer>[] queue = new PriorityQueue[scores.length];
		for (int i = 0; i < scores.length; i++) {
			queue[i] = new PriorityQueue<>((o, p) -> scores[o] - scores[p]);
		}
		for (int[] edge : edges) {
			queue[edge[0]].offer(edge[1]);
			queue[edge[1]].offer(edge[0]);
			if (queue[edge[0]].size() > 3) {
				queue[edge[0]].poll();
			}
			if (queue[edge[1]].size() > 3) {
				queue[edge[1]].poll();
			}
		}
		int max = -1;
		for (int[] edge : edges) {
			for (int i : queue[edge[0]]) {
				for (int j : queue[edge[1]]) {
					if (i != edge[1] && j != edge[0] && j != i) {
						max = Math.max(max, scores[edge[0]] + scores[edge[1]] + scores[i] + scores[j]);
					}
				}
			}
		}
		return max;
	}
}