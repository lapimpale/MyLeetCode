class Solution {
    public int divisorSubstrings(int num, int k) {
        
        String s=Integer.toString(num);
        
        int count = 0;
        
        for(int i = 0; i <= s.length()-k; i++){
            
            String str = s.substring(i , i + k);
            
            System.out.println(str);
            
            int currentNumber = Integer.parseInt(str); 
            
            if(currentNumber!=0 && num%currentNumber == 0 ){
                count++;
            }
        }
        return count;
    }
}