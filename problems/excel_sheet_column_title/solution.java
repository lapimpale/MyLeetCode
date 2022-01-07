class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer result = new StringBuffer();
        char ch;
        while (columnNumber > 0) {
            ch = (char)((int)'A' + (columnNumber-1) % 26);
            columnNumber = (columnNumber-1)/26;
            result.append(ch);
        }
        return new String(result.reverse());
    }
}