class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Queue<Integer> pstack
            = new LinkedList<>();
        Queue<Integer> nstack
            = new LinkedList<>();
        
        for(int i = 0; i<nums.length;i++){
            if(nums[i]>0) pstack.add(nums[i]);
            else nstack.add(nums[i]);
        }
        
        for (int i =0;i<nums.length;i++){
            if(i==0||i%2==0) nums[i]= pstack.poll();
            else nums[i]=nstack.poll();
        }
        
        return nums;
    }
}