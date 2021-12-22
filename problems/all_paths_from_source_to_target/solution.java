class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        List<Integer> path = new ArrayList<Integer>();
        
        dfs(graph,  res, path,  0);
        
        return res;
        
    }
    
    public void dfs(int[][] graph,  List<List<Integer>> res, List<Integer> path, int source){
        path.add(source);
        
        if(source == graph.length-1) res.add(new ArrayList(path));
        else
            for(int node : graph[source]) 
                dfs(graph,  res, path,  node);
        
        path.remove(path.size()-1);
    }
}