class Solution {
    public int reverse(int x) {
         int final_res=0;                 // To store final result
        int y= Math.abs(x);           // To handle negative number
        while(y>0){
            int remainder=y%10;
            int c= final_res*10+remainder;       // Get the reverse number. Always first multiply then add to get the proper output. 
            if((c-remainder)/10 != final_res)     // To check if the limit of  integers is crossed.                        
                 return 0;
            final_res=c;
            y/=10;
            }
        if(x<0) final_res*=-1;            //To handle for negative number.
        return final_res;
    }
}