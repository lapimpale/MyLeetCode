class Solution {
    public boolean isNumber(String s) {
        int size = s.length();
        if (size == 0) return false;
        char[] chs = s.toCharArray();
        
        int i = 0;
        if (chs[0] == '+' || chs[0] == '-') {
            i++;
        }
        
        boolean meetDot = false;
        boolean meetDecimal = false;
        boolean meetE = false;
        
        for (; i < size; i++) {
            if (chs[i] == 'e' || chs[i] == 'E') {
                if (meetDecimal == false)
                    return false;
                else {
                    i++;
                    meetE = true;
                    break;
                }
            }
            else if (chs[i] == '.') {
                if (meetDot == true)
                    return false;
                else
                    meetDot = true;
            }
            else if (Character.isDigit(chs[i])) {
                meetDecimal = true;
            }
            else {
                return false;
            }
        }
        
        if (meetDecimal == false)
            return false;
        
        if (meetE == true) {
            if (i == size) return false;
            if (chs[i] == '+' || chs[i] == '-')
                i ++;
            
            if (i == size)
                return false;
            for (; i < size; i++) 
                if (!Character.isDigit(chs[i]))
                    return false;
        }
        
        return true;
    }
}