class Solution {
    public int countEven(int num) {
        int count =0;
        while(num!=0){
            if(countDigits(num)%2==0)count++;
            num--;
        }
        return count;
    }
    
    int countDigits(int num){
        int sum = 0;
        
        while(num>0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
}