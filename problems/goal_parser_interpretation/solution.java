class Solution {
    public String interpret(String command) {
        String str = command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
        
        return str;
    }
}