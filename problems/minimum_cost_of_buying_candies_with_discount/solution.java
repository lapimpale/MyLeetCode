class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum =0;
        int x = 0;
        for(int i =cost.length-1;i>=0;i--){
            sum+=cost[i];
            x++;
            if(x==3){
                x=0;
                sum-=cost[i];
            }
        }
        return sum;
    }
}