class Solution {
    public String capitalizeTitle(String input) {
      String[] arr = input.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr){
            if(s.length()>=3){
                sb.append(String.valueOf(s.charAt(0)).toUpperCase());
                sb.append(s.substring(1));              
            } else {
            sb.append(s);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}