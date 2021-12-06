class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] firstArray = s.toCharArray();
        char[] secondArray = t.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        return Arrays.equals(firstArray, secondArray);
    }
}