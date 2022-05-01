class Solution {

	public int countDistinct(int[] nums, int k, int p) {
		HashSet<List<Integer>> set = new HashSet<>();
		for (int i = 0, count = 0; i < nums.length; i++, count = 0) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = i; j < nums.length; j++) {
				list.add(nums[j]);
				if ((count += nums[j] % p > 0 ? 0 : 1) <= k) {
					set.add(List.copyOf(list));
				}
			}
		}
		return set.size();
	}
}