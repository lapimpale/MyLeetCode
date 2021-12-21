class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int pow = n/3;
        int value = 0;
        if(n%3 == 0){
            value = (int)Math.pow(3,pow);
        }
        else{
            if(n%3 == 1){
                value = (int)Math.pow(3,pow-1) * 4; 
            }
            else{
                value = (int)Math.pow(3,pow) * 2; 
            }
        }
        return value;
    }
}