class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int n = spaces.length-1;
        char[] array = s.toCharArray();
        int lastLoop = spaces[n];
        int k =0;
        for(int i = 0; i<array.length; i++){
            if(i == spaces[k]){
                res=res.append(" ");
                if (k<n) k+=1;
            }
            res = res.append(array[i]);
        }
        return res.toString();
    }
}