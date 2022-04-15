class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> list = new ArrayList<>();
        helper(list, s, wordDict, new StringBuilder());
            
        return list;    
    }
    
    
    public void helper(List<String> list, String s, List<String> wordDict, StringBuilder str){
        
       
       if(s.length() == 0){
            str.deleteCharAt(str.length()-1);
            list.add(str.toString());

            return;
        }
        
        for(int i = 0; i <= s.length(); i++){
            String sub = s.substring(0,i);
           
            int l = str.length();
            if(wordDict.contains(sub)){
            
                str.append(sub+ " ");
                helper(list, s.substring(i), wordDict, str);
                str.delete(l, str.length());
            }
        }
        
    }
}