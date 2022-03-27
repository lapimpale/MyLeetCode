class Solution {

	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
		for (int num : nums1) {
			set1.add(num);
		}
		for (int num : nums2) {
			set1.remove(num);
			set2.add(num);
		}
		for (int num : nums1) {
			set2.remove(num);
		}
		return List.of(List.copyOf(set1), List.copyOf(set2));
	}
}