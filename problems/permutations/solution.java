class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        if(nums.length == 0) out.add(new ArrayList());
        permute(nums, new ArrayList<>(), visited);
        return out;
    }
    
    public void permute(int [] nums, List<Integer> list, boolean[] visited) {
        if(list.size() == nums.length) {
            out.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            permute(nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        } 
    }
}