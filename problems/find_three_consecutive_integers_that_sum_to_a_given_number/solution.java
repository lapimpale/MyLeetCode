class Solution {
    public long[] sumOfThree(long num) {
        long[] sol = new long[3];
        long devide = num/3;
        if(num%3==0){
            sol[0]= devide-1;
            sol[1]= devide;
            sol[2]=devide+1;
            return sol;
        }
        
        return new long[0];
    }
}