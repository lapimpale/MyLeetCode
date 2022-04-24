class Solution {
    public List<Integer> intersection(int[][] nums) {
       List<Integer> intersection = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int[] num : nums){
            for(int eachNum : num){
                hm.put(eachNum,1+hm.getOrDefault(eachNum,0));
            }
        }
        
        
        for(int i : hm.keySet()){
            if(hm.get(i)==nums.length){
                intersection.add(i);
            }
        }
        Collections.sort(intersection);
        return intersection;
    }
}