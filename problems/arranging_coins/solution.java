class Solution {
    public int arrangeCoins(int n) {
       int current=1;

        int noOfRowsTillNow=0;

        for(current=1; n-current>=0 ; current++)

        {

            n=n-current;

            noOfRowsTillNow++;

        }

       /* same logic with while loop

       while(n-current>=0)

        {

            n=n-current;

            noOfRowsTillNow++;

            current++;

        }

       */

        return noOfRowsTillNow; 
    }
}