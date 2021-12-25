class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        for(int i = 0; i < candidates.length; i++) {
            List<Integer> components = new ArrayList<>();
            components.add(candidates[i]);
            this.combine(candidates[i], components, i, candidates, results, target);    
        }
        
        return results;
    }
    
    private void combine(int currentSum, List<Integer> components, int index, int[] candidates, List<List<Integer>> results, int target) {
        if(currentSum == target) {
            results.add(components);
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(currentSum + candidates[i] <= target) {
                List<Integer> copy = new ArrayList<>(components);
                copy.add(candidates[i]);
                this.combine(currentSum + candidates[i], copy, i, candidates, results, target);
            }
        }
    }
}