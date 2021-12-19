class Solution {
    public static boolean isPalindrome(String input){
        int i = 0;
        int j = input.length() - 1;
        
        while(i < j){
            if(input.charAt(i)!=input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        String res = "";
        
        for (String word : words){
            if(isPalindrome(word)) return word;
        }
        return res;
    }
}