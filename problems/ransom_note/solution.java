class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hashy = new HashMap();
        
        // Put magazine chars into hashmap with a count of their occurrences
        for(int i = 0; i < magazine.length(); i++){
            hashy.put(magazine.charAt(i), hashy.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        // Check that letters in the ransome note can be constructed from the hashmap
        for(int i = 0; i < ransomNote.length(); i++){
            if (hashy.getOrDefault(ransomNote.charAt(i), 0) >= 1){
                hashy.put(ransomNote.charAt(i), hashy.get(ransomNote.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}