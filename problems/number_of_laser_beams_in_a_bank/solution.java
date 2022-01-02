class Solution {
    public int numberOfBeams(String[] bank) {
        int sol = 0;
        int prevOne = 0;

        for(String s : bank){
            int countOne = 0;
            for(int i =0;i<s.length();i++){
                if(s.charAt(i)== '1'){
                    countOne++;
                }                    
            }
            if(countOne > 0){
                sol += (countOne * prevOne);
                prevOne = countOne;
            }
        }
        return sol;
    }
}