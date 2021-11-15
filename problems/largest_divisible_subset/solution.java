class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
       Arrays.sort(nums);
        Set<Integer>[] cache = new HashSet[nums.length];
        int maxIdx = 0;
        cache[0] = new HashSet<>();
        cache[0].add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            cache[i] = new HashSet<>();
            cache[i].add(nums[i]);
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(cache[i].size() < cache[j].size() + 1) {
                        cache[i] = new HashSet<>(cache[j]);
                        cache[i].add(nums[i]);
                    }
                } 
            }
            if(cache[i].size() > cache[maxIdx].size()) {
                maxIdx = i;
            }
        }
        /*
        for(int i = 0; i < cache.length; i++) {
            System.out.println(cache[i]);
        }
        */
        return new ArrayList<>(cache[maxIdx]); 
    }
}