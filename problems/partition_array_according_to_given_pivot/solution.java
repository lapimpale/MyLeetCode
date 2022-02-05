class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       Queue<Integer> lq
            = new LinkedList<>();
        Queue<Integer> hq
            = new LinkedList<>();
        Queue<Integer> pq
            = new LinkedList<>();
        for(int i =0; i< nums.length; i++){
            if(nums[i]<pivot){
                lq.add(nums[i]);
            }else if(nums[i]>pivot) {
                hq.add(nums[i]);
            }
            else {
                pq.add(nums[i]);
            }
            
        }
        int k = 0;
        while(!lq.isEmpty()) nums[k++] = lq.poll();
        
        while(!pq.isEmpty()) nums[k++] = pq.poll();
        
        while(!hq.isEmpty()) nums[k++] = hq.poll();
        
        return nums;
    }
}