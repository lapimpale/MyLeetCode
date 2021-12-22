class Solution {
    public int numSquares(int n) {
        for(int i=1;i<n;i++){
            if(combo(n,i))
                return i;
        }
        return n;
    }
    
    private boolean combo(int n, int num){
        int sqr = (int) Math.floor(Math.sqrt(n));
        if(num==1)
            return sqr*sqr ==n;
        
        for(int i=sqr;i>0;i--){
            if(combo(n-(i*i),num-1)){
                return true;
            }
        }
        return false;
    }
}