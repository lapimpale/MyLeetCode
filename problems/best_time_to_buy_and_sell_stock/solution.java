class Solution {
    public int maxProfit(int[] prices) {
        int maxsofar = 0;
        int mincost = prices[0];
        
        for(int i = 0; i< prices.length;i++){
            if(mincost<prices[i]){
                maxsofar= Math.max(maxsofar, prices[i]-mincost);
            } else{
                mincost = prices[i];
            }
        }
        return maxsofar;
    }
}