class Solution {
    public boolean isSameAfterReversals(int num) {
        return num==0||!String.valueOf(num).endsWith("0");
    }
}