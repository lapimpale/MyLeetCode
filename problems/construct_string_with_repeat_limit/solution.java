
class Solution {
    public String repeatLimitedString(String S, int repeatLimit) {
        char[] s = S.toCharArray();
        int[] f = new int[26];
        for(char c : s){
            f[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int pre = -1;
        outer:
        while(true){
            boolean nz = false;
            for(int i = 25;i >= 0;i--){
                if(i != pre && f[i] > 0){
                    int use = nz ? 1 : Math.min(repeatLimit, f[i]);
                    for(int j = 0;j < use;j++){
                        sb.append((char)('a'+i));
                    }
                    f[i] -= use;
                    pre = i;
                    continue outer;
                }
                if(f[i] > 0){
                    nz = true;
                }
            }
            break;
        }
        return sb.toString();
    }
}