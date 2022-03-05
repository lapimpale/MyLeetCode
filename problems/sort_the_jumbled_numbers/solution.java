class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] arr = new int[nums.length][2];
        
        for(int i = 0;i < nums.length;i++){
            arr[i][1] = i;
            
            StringBuilder num = new StringBuilder(String.valueOf(nums[i]));
            
            for(int j = 0;j < num.length();j++) num.setCharAt(j,(char)(mapping[num.charAt(j) - '0'] + '0'));
            arr[i][0] = Integer.parseInt(num.toString());
        }
        
        Arrays.sort(arr,(a,b) -> {
           return Integer.compare(a[0],b[0]); 
        });
        
        int[] ans = new int[nums.length];
        for(int i = 0;i < nums.length;i++) ans[i] = nums[arr[i][1]];
        return ans;
    }
}