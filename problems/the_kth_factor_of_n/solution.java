class Solution {
    public int kthFactor(int n, int k) {
        int c=0;
        for(int x=1; x<=n/2; x++){
            if(n%x==0){
                c++;
                if(c==k){
                    return x;
                }                    
            }            
        }
        if((c+1)==(k))
            return n;
        else
            return -1; 
    }
}