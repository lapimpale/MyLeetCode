class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == key) map.put(nums[i + 1],map.getOrDefault(nums[i + 1],0) + 1);
        }
        
        int ans = 0,freq = 0;
        for(int val : map.keySet()){
            if(map.get(val) > freq){
                freq = map.get(val);
                ans = val;
            }
        }
        return ans;
    }
}