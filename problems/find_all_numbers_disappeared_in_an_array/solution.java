class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int currIndex = Math.abs(nums[i]) - 1;
			// mark this index as existing number
			// by reversing from positive to negative value
			if (nums[currIndex] > 0) nums[currIndex] *= -1;
		}

		for (int i = 0; i < nums.length; i++) {
			// add all positive numbers, because it's index is value
			// that doesn't exist in nums
			if (nums[i] > 0) res.add(i + 1);
		}

		return res;
    }
}