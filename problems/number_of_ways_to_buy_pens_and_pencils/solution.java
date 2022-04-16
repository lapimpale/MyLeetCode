class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        
        while(total>=0){
            ways += total/cost2;
            total-=cost1;
            ways++;
        }
        return ways;
    }
}