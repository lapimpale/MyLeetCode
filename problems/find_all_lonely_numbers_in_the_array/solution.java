class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> list = new ArrayList();
        for (int num : nums) {
            if (map.get(num) == 1 && !map.containsKey(num - 1) && !map.containsKey(num + 1)) list.add(num);
        }
        return list;
    }
}