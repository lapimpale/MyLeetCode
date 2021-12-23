class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list.clear();
        Arrays.sort(nums);
        // generateSubset(nums,0,new ArrayList<>());
        list.add(new ArrayList<>());
        generateSubset(nums,0,new ArrayList<>());
        return list;
    }

    static void generateSubset(int[] nums, int index, List<List<Integer>> localList){
        if(index == nums.length){
            return;
        }
        
        if(index>0 && nums[index] == nums[index-1]){
            // perform actions on the received localList
        }else{
            // clear localList and copy all from list
            localList.clear();
            for(List<Integer> i : list){
                localList.add(new ArrayList(i));
            }
        }
        
        
        // insert number into localList and then in list
        for(List<Integer> i : localList){
            i.add(nums[index]);
            list.add(new ArrayList(i));
        }
        
        generateSubset(nums,index+1,localList);
    }
    
}