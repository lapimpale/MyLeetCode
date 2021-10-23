class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String pattern = s.substring(0, i);
            boolean foundMatch = true;
            for (int j = i; j < s.length(); j = j + pattern.length()) {
                int endIndex = j + pattern.length() < s.length() ? j + pattern.length() : s.length();
                String match = s.substring(j,endIndex);
                if (!pattern.equals(match)) {
                    foundMatch  = false;
                    break;
                }
            }
            if (foundMatch) {
                return true;
            }
        }
        return false;
    }
}