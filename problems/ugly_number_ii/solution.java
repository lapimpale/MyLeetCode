class Solution {
    public int nthUglyNumber(int n) {
        int [] dp =  new int[n + 1];
        dp[1] = 1;  //first ugly number
        
        //set the pointers to idx 1
         int p2 = 1;
         int p3 = 1;
         int p5 = 1;
        
        for(int i = 2;i<=n;i++){
            
            //get the ugly numbers by multiplying 2,3,5 with such numbers who are also 
            //ulgy numbers(they also have factors only 2,3,5)
            
            int f2 = dp[p2] * 2;
            int f3 = dp[p3] * 3;
            int f5 = dp[p5] * 5;
            
            int min = Math.min(f2,Math.min(f3,f5)); //choose the min ugly number
            
            //move the pointers p2,p3,p5 to traverse and avoid duplicates
            
            if(f2 == min) p2++;
            if(f3 == min) p3++;
            if(f5 == min) p5++;
            
            dp[i] = min;
        }
        
        return dp[n];
    }
}