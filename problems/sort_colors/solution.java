class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        
        while(low<=mid && high>=mid){
            if(nums[mid]==0){ // if 0 then swap it from element at low and thn increase both pointers
                int tmp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = tmp;
                low++; mid++;
            }else if(nums[mid]==1){ // if 1 then just increase mid pointer
                mid++;
            }else if(nums[mid]==2){ // if 2 then swap it from element at high and thn decrease high pointer
                int tmp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = tmp;
                high--;
            }
        }
    }
}