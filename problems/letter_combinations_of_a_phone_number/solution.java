class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
        if (digits == null || digits.equals(""))
            return res;
        String[] map = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(0, new StringBuilder(), digits, map, res);
        return res;
    }

    private void backtrack(int curr, StringBuilder str, String digits, String[] map, List<String> res) {
        if (str.length() == digits.length()) {
            res.add(str.toString());
            return;
        }
        for (char c : map[digits.charAt(curr) - '0'].toCharArray()) {
            backtrack(curr + 1, str.append(c), digits, map, res);
            str.deleteCharAt(str.length() - 1); //Always delete the char added above since str is shared between recursion runs
        } 
    }
}