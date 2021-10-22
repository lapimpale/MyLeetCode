class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int t = target;
        int[] arr = new int[]{first(nums, t, l, h), last(nums, t, l, h)};
        return arr;
    }
    public int first(int[] nums, int t, int l, int h){
        while(l<=h){
            int mid = (l+h)/2;

            if(nums[mid] > t)
                h = mid-1;
            else if(nums[mid] < t)
                l = mid+1;
            else{
                if(mid == 0 || nums[mid-1] != t)
                    return mid;
                else
                    h = mid-1;
            }
        }
        return -1;
    }
    
    public int last(int[] nums, int t, int l, int h){
        while(l<=h){
            int mid = (l+h)/2;

            if(nums[mid] > t)
                h = mid-1;
            else if(nums[mid] < t)
                l = mid+1;
            else{
                if(mid == nums.length - 1 || nums[mid+1] != t)
                    return mid;
                else
                    l = mid+1;
            }
        }
        return -1;
    }
}