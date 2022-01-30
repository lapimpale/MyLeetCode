class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int u : nums)set.add(u);
        while(set.contains(original)){
            original *= 2;
        }
        return original;
    }
}