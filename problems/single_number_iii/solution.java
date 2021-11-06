class Solution {
    public int[] singleNumber(int[] nums) {
        int uXORv = 0 , n = nums.length , i;
        for(i = 0; i < n; i++){
            uXORv ^= nums[i];
        }
        for(i = 0; i < 31; i++){
            if((uXORv & 1) == 1){
                break;
            }
            uXORv = uXORv >> 1;
        }
        int u = 0, v = 0;
        for(int j = 0; j < n; j++){
            int cpy = nums[j] >> i;
            if((cpy & 1) == 1){
                u ^= nums[j];
            }
            else{
                v ^= nums[j];
            }
        }
        int[] res = new int [2];
        res[0] = u;
        res[1] = v;
        return res;
    }
}