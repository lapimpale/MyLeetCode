class Solution {
    public void rotate(int[] nums, int k) {
     
        	k = k % nums.length;
		int arr[] = new int[nums.length];
    
		 int N = nums.length -1, count = 0;
		  for(int i= N - k + 1; i <=N; i ++) {
			arr[count++] = nums[i];
		}
    
		for(int i=0; i< N - k + 1;i++){
			arr[count++] = nums[i];
		}
		
		for(int i =0;i<=N; i++){
			nums[i] = arr[i];
		 }
    }
}