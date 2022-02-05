class Solution {
    public int minimumSum(int num) {
        int[] intArray = new int[4];
        
        for(int i =0; i< 4;i++){
            intArray[i] = num%10;
            num = num /10;
        }
        
        Arrays.sort(intArray);
        
        int num1 = intArray[0]*10+intArray[3]; 
        int num2 = intArray[1]*10+intArray[2];
        
        
        return num1+num2;
    }
}