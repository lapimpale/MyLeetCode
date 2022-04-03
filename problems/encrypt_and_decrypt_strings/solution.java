class Encrypter {
    Map<Character, Integer> keyIndexMap = new HashMap<>();
    Map<String, Integer> dictCountMap = new HashMap<>();
    String[] values;
    String[] dictionary;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i = 0; i < keys.length; i++) {
            this.keyIndexMap.put(keys[i], i);
        }
        this.values = values;
		// precompute the encrypted value of all words in dict
        for(int i = 0; i < dictionary.length; i++) {
            dictionary[i] = encrypt(dictionary[i]);
            dictCountMap.put(dictionary[i], dictCountMap.getOrDefault(dictionary[i], 0) + 1);
        }
        this.dictionary = dictionary;
    }
    
    public String encrypt(String word1) {
        char[] charArray = word1.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c: charArray) {
            int index = keyIndexMap.get(c);
            builder.append(values[index]);
        }
        return builder.toString();
    }
    
    public int decrypt(String word2) {
        return dictCountMap.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */