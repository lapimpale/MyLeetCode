class Solution {
    public boolean validMountainArray(int[] arr) {  
       int start = 0, end = arr.length-1;
        while(start != end) {           
            if(arr[start] < arr[start+1]) {
                start++;
            } else if(arr[end] < arr[end-1]) {
                end--;
            } else {
                return false;
            }
        }       
        if(start == 0 || end == arr.length-1) {
            return false;
        }
        return true;
    }
}