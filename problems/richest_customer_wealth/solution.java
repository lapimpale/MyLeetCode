class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max = Integer.MIN_VALUE;
        
        for(int[] account : accounts){
            int balance = 0;
            
            for(int wealth : account){
                balance += wealth;
                
                if(max <= balance){
                    max = balance;
                }
            }
            
        }
       return max; 
    }
}