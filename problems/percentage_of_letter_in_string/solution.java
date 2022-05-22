class Solution {
    public int percentageLetter(String s, char letter) {
        int count=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==letter)
            {
                count++;
            }
        }
        
        int result= (int)Math.floor((double)(count*100.00)/s.length());
        return result;
    }
}
//Time Complexity: O(n)
//Spcae complexity: O(1)