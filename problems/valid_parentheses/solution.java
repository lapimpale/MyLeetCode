class Solution {
    public boolean isValid(String s) {
        StringBuilder b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(')
                b.append(')');
            else if (c == '{')
                b.append('}');
            else if (c == '[')
                b.append(']');
            else if (b.length() == 0 || b.charAt(b.length() - 1) != c) {
                return false;
            } else b.replace(b.length() - 1, b.length(), "");

        }
        return b.length() == 0;
    }
}