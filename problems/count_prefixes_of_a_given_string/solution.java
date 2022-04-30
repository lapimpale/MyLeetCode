class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0 ;
        for(String word : words){
            if(s.indexOf(word)==0){
                count++;
            }
            
            System.out.println(s.indexOf(word));
        }
        return count;
    }
}