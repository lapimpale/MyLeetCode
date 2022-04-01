class Solution {
    public void reverseString(char[] s) {
       //  two pinter to point first and last element of array
       int i = 0;
       int j = s.length-1 ; 
       
//         Swapping logic 
       while (i <= j){
          char temp = s[i];
           s[i] = s[j];
           s[j] = temp; 
           
           i++;
           j--;
       }
    }
}