class Solution {
    public int countValidWords(String sentence) {
        String arr[] = sentence.split(" ");
        int counter =0;
        for ( String ss : arr) {
            if(((ss.matches("([a-z]+)"))||(ss.matches("([!.,])"))||(ss.matches("([a-z]+)([!.,])"))||(ss.matches("([a-z]+)([-])([a-z]+)([.,!])"))||(ss.matches("([a-z]+)([-])([a-z]+)"))) && (!ss.matches("\\d*[1-9]\\d*"))){
            counter++;
            System.out.println(ss);
            }
            
        }
        return counter;
    }
}