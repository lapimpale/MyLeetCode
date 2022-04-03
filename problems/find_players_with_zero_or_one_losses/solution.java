class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        HashSet<Integer> winnerSet = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> winnerList = new ArrayList<>();
        List<Integer> loserList = new ArrayList<>();
        for(int[] match : matches){
            winnerSet.add(match[0]);
            if(hm.containsKey(match[1])){
                hm.put(match[1],hm.get(match[1])+1);
            }else{
                hm.put(match[1],1);
            }
        }
        
        for(int winner: winnerSet){
            if(!hm.containsKey(winner)) winnerList.add(winner);
        }
        Collections.sort(winnerList);
        results.add(winnerList);
        
        for(Integer i : hm.keySet()){
            if(hm.get(i)==1){
                loserList.add(i);
            }
        }
        Collections.sort(loserList);
        results.add(loserList);
        
        return results;
    }
}