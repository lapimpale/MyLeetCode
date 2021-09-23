class Solution {

    int[] arr = new int[46];
    public int climbStairs(int n) {
        if(n==0){
            return 1;
        }
        else if(arr[n]>0){
            // optimize if the left value of n has been seen before
            // otherwise, n should small than 43
            return arr[n];
        }
        int count2 = n>=2?climbStairs(n-2) : 0;
        int count1 = n>=1?climbStairs(n-1) : 0;
        arr[n] = count1+count2;
        return count1+count2;
    }
}