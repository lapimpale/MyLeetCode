class Solution {
    public int change(int amount, int[] coins) {
        
        // make the table for caching no of ways 
        int[][] dp = new int[ coins.length + 1][ amount + 1];
        
		// when there is no coins in the input  , 0 ways to fill the knapsack so fill it in table 
        for ( int i = 0 ; i < amount + 1 ; i ++ ){
            dp[0][i] = 0 ;
        }
        
		// when amount is 0 , then there is one way to fill knapsack , that is remains it as empty 
        for ( int j = 1; j  < coins.length + 1; j++){
            dp[j][0] = 1 ;
        }
    
        // now start checking the ways for each value(amount) less than amount 
        for ( int i = 1; i < coins.length + 1 ; i ++){
            for( int j = 1 ; j < amount + 1; j++ ){
                // now we have two options to selct the coin : yes or no 
				
				// yes  : coin selected 
				// if current coin value is less than current amount j , then only we can select else the if coin is bigger than amount then how it can be fitted in the knapsack ( cosider amount as weight of knapsack ) 
                if ( coins[i - 1 ] <= j){
				
				// now we selected the coin , again we have two ways to get the amount we needed 
				// dp[i - 1][ j]    : not select the coin 
				// dp[i][j -  coins[i -1]] : coin is selected , hence reduce the coins array length and also subtract current amount j from current value in coins, this is beacause we have filled the coins[ i -1 ] part of the amount( knapsack ) 
				
                    dp[i][j] = dp[i -1][j ] + dp[i][ j - coins[i -1 ]];
                    
                }else{
				// no 
				// then go for the next coin
                    dp[i][j] = dp[i -1][j] ;
                }
            }
        }
        
		// finally return when all the arrays and amount exhausted 
        return dp[coins.length][ amount ];
    }
}