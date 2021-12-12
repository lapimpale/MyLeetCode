class Solution {
    public List<String> letterCasePermutation(String s) {
         List<String> result = new ArrayList<>();
        helper(0, s, result);
        return result;
    }
    private void helper(int start, String s, List<String> result){
        result.add(s);
        for (int i = start; i< s.length(); i++){
            if (Character.isLetter(s.charAt(i))){
                char[] chArr = s.toCharArray();
                if (Character.isUpperCase(s.charAt(i))){
                    chArr[i] = Character.toLowerCase(s.charAt(i));
                    helper(i + 1, new String(chArr), result);
                }else{
                    chArr[i] = Character.toUpperCase(s.charAt(i));
                    helper(i + 1, new String(chArr), result);
                }
            }
        }
    }
}