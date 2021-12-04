class StreamChecker {
        
    StringBuilder sb;
    TrieNode root;
    
    class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isWordEnd;
    }
    
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word : words){
            addWord(root,word);
        }
    }
    
    public void addWord(TrieNode root, String word){
        TrieNode ws = root;
        for(int i=word.length()-1;i>=0;i--){    //add reversed words in trie for ease searching suffix
            if(ws.child[word.charAt(i)-'a'] == null)
                ws.child[word.charAt(i)-'a'] = new TrieNode();
            ws = ws.child[word.charAt(i)-'a'];
        }
        ws.isWordEnd = true;
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode ws = root;
        return find(ws,sb.length()-1);
    }
    
    private boolean find(TrieNode ws,int i){
        if(ws.isWordEnd) return true; 
        if(i<0) return false;
        if(ws.child[sb.charAt(i)-'a'] != null) 
            return find(ws.child[sb.charAt(i)-'a'],i-1);
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */