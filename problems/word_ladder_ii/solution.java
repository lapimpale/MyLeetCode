class Solution {

     List<List<String>> res;
    int min;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<LinkedList<String>> q = new LinkedList();
        LinkedList<String> list = new LinkedList();
        list.add(beginWord);
        q.add(list);
        boolean find = false;
        HashSet<String> set =  new HashSet();
        while(q.size() > 0 && !find) {
            int n = q.size();
            List<String> newWords = new ArrayList();
            for(int i = 0; i < n; i++) {
                LinkedList<String> curr = q.poll();
                String str = curr.getLast();
                for(String word : wordList) {
                    if(!curr.contains(word) && transformed(str, word)) {
                        if(!set.contains(word)) 
                        {
                            newWords.add(word);
                            curr.add(word);
                            q.add(new LinkedList(curr));
                            curr.removeLast();
                        }
                        if(word.equals(endWord)) find = true;
                    }
                }
            }
            for(String s: newWords) {
                set.add(s);
            }
        }
        List<List<String>> res = new ArrayList();
        if(find) {
            for(LinkedList<String> l : q) {
                if(l.getLast().equals(endWord)) res.add(l);
            }
        }
        return res;
    }
    
    
    public boolean transformed (String a, String b) {
        boolean diff = false;
        if(a.length() != b.length()) return false;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(diff) return false;
                diff = true;
            }
        }
        return diff;
    }
}