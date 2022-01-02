class Solution {
    public boolean checkString(String s) {
        
        char[] charArray = s.toCharArray();
        
        for(int i = 1; i<charArray.length;i++){
            if(charArray[i-1] == 'b' && charArray[i] == 'a'){
                return false;
            }
        }
        return true;
    }
}