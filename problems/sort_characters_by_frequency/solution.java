class Solution {
    public String frequencySort(String s) {
        String str=""; 
	
    HashMap<Character,Integer>m=new HashMap<>();
    
    for(int i=0;i<s.length();i++){
        m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
    }
  
    Map<Character, Integer> sort = m.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));

    for(Map.Entry<Character,Integer>e:sort.entrySet()){
        for(int i=0;i<e.getValue();i++){
            str=e.getKey()+str;
        }
    }
    return str;
    }
}