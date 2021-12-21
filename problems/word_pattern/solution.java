class Solution{

public boolean wordPattern(String pattern, String s) {
      
        String[] tokens = s.split(" ");
        if(pattern.length() != tokens.length) return false;
        
        
        Map<Character, String> m = new HashMap<>();
        Set<Character> patternSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        
        for(int i = 0; i < tokens.length; i++) {
            char c = pattern.charAt(i);
            String str = tokens[i];
            
            patternSet.add(c);
            wordSet.add(str);
            
            if(m.containsKey(c) && !m.get(c).equals(str)) {
                return false;
            }
            else {
                m.put(c, str);
            }
        }
        
        return patternSet.size() == wordSet.size();
    }
}