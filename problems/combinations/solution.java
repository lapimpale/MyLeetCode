class Solution {
     List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean []visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        backtrack(cur, k, n, 1, visited);
        return list;
    }
    
    public void backtrack(List<Integer> cur, int k, int n, int next, boolean[] visited){
        if(cur.size() == k){
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = next; i < n + 1 && (n + 1 - i ) >= (k - cur.size()); i++){
            if(!visited[i]){
                cur.add(i);
                visited[i] = true;
                backtrack(cur, k, n, i + 1, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}