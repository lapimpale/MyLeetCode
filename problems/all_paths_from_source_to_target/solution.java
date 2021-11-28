class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        return helper(res,temp,graph,graph[0],0);
    }
    
    public List<List<Integer>> helper(List<List<Integer>> res,List<Integer> temp,int[][] graph,int[] path,int idx){
        if(idx == graph.length-1){
            res.add(new ArrayList<>(temp));
            return res;
        }
        
        for(int i = 0;i< path.length;i++){
            temp.add(path[i]);
            helper(res,temp,graph,graph[path[i]],path[i]);
            temp.remove(temp.size()-1);
        }
        
        return res;
    }
}