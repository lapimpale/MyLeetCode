class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int p=1;
        int pWithoutZeroes=1;
        int zeroes=0;
        for(int x: nums){
            p*=x;
            if(x==0){
              zeroes++;  
            }else{
                pWithoutZeroes*=x;
            }
        }
        if(zeroes>1) Arrays.fill(ans,0);
        else{
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    ans[i]=pWithoutZeroes;
                    continue;
                } 
                ans[i]=p/nums[i];
            }
        }
        return ans;
    }
}