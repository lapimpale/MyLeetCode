class Solution {
    public void sortColors(int[] nums) {
        int c0=0,c1=0,c2=0;
        
        for (int i : nums){
            if(i==0) c0++;
            if(i==1) c1++;
            if(i==2) c2++;
        }
         int i=0;
            while(c0!=0){
                nums[i++]=0;
                c0-=1;
            }
            while(c1!=0){
                nums[i++]=1;
        c1-=1;
            }
        
        while(c2!=0){
            nums[i++]=2;
            c2-=1;
        }
    }
}