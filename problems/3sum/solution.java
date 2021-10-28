class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>(); // In order to remove dupliates

        int len = nums.length;

        if (len < 3) return new ArrayList<>(ans); // base case

        Arrays.sort(nums); // in order to remove duplicates e.g. [1, -1, 0] and [-1, 1, 0] would be considered differently.

        for (int i = 0; i < len; i++) {

            Map<Integer, Integer> visited = new HashMap<>();

            for (int j = i+1; j < len; j++) {

                if (visited.containsKey(nums[j])) {

                    ans.add(Arrays.asList(nums[i], nums[visited.get(nums[j])], nums[j]));

                } else {

                    visited.put(-nums[i]-nums[j], j); // target is now -nums[i]-nums[j]

                }

            }

        }

        

        return new ArrayList<>(ans);
    }
}