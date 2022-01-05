class Solution {
    public int mySqrt(int x) {
         if(x<2) return x;
        int start =0,end = x;
        while(start<end){
            int mid = start + (end - start)/2;
            int mul = x/mid; // This will avoid overflow
            if(mul==mid) return mid; // if perfect square is found return
            if(mul<mid){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start-1;  //Non perfect square means one less than the last mismatch.
    }
}