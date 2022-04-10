class Solution {

	public int maximumProduct(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.offer(num);
		}
		for (int i = 0; i < k; i++) {
			queue.offer(queue.poll() + 1);
		}
		long prod = 1;
		for (int num : queue) {
			prod = prod * num % 1000000007;
		}
		return (int) prod;
	}
}