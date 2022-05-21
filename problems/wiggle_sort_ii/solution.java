class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int [] ans = new int[n];
        int i = 1;
        int j = n - 1;
        //travel odd index and fill sorted array's right half 
        while(i < n){
            ans[i] = nums[j];
            i += 2;
            j--;
        }
        //travel even index and fill sorted array's left half 
        i = 0;
        while(i < n){
            ans[i] = nums[j];
            i += 2;
            j--;
        }
        
        for(int k = 0; k < n; k++){
            nums[k] = ans[k];
        }
    }
}