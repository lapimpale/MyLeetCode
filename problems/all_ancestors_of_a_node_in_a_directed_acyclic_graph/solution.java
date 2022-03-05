class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < n;i++) graph.add(new ArrayList<>());
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < n;i++) ans.add(new ArrayList<>());
        
        for(int src = 0;src < n;src++){
            
            Queue<Integer> que = new LinkedList<>();
            boolean[] vis = new boolean[n];
            
            que.add(src);
            vis[src] = true;
            
            while(que.size() > 0){
                int rem = que.remove();
                
                if(rem != src) ans.get(rem).add(src);
                
                for(int nbr : graph.get(rem)){
                    if(!vis[nbr]){
                        que.add(nbr);
                        vis[nbr] = true;
                    }
                }
            }
        }
        
        for(List<Integer> ar : ans) Collections.sort(ar);
        return ans;
    }
}