class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] sol = new int[nums.length];
        int lp=1;
        for (int i=0; i< nums.length; i++){
            sol[i]=lp;
            lp *= nums[i];
        }
        
        int rp =1;
        for (int i=sol.length-1; i>=0;i--){
            sol[i]*=rp;
         rp*= nums[i];
            
}
        
        return sol;
    }
}