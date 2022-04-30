class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>>graph=new HashMap<>();
        
        for(int i=0;i<equations.size();i++){
            graph.putIfAbsent(equations.get(i).get(0),new HashMap<String,Double>());
            graph.get(equations.get(i).get(0)).put(equations.get(i).get(1),values[i]);
            graph.putIfAbsent(equations.get(i).get(1),new HashMap<String,Double>());
            graph.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/values[i]);
        }
		
		// now graph is created. for eg. ["a","b"] has result as x, then going from a -> b costs x and b -> a costs 1/x ;
        
        double[] temp = new double[1];
        double[] result = new double[1];
        HashSet<String>vis = new HashSet<>();
      
        double[] res = new double[queries.size()];
        Arrays.fill(res,-1.0);
		
		// now for each query we simply run dfs and try to reach from src to dest in ["src","dest"]; 
		
        int i=0;
        for(List<String>q : queries){
            if(!graph.containsKey(q.get(0)) || !graph.containsKey(q.get(1))){ // if not in graph, res[i] = -1 already.
                i++;
                continue;
            }
            vis.clear(); // reseting values
            temp[0]=1;
            result[0]=-1;
            dfs(graph,q.get(0),q.get(1),vis,temp,result); // dfs started
            res[i++]=result[0]; // storing the result in our double[] res array
        }
        
        return res;
        
    }
    
	
	// this is simple dfs. from `s to d` and using temp to store the computed result on the way from `s to d`
    private void dfs(Map<String,Map<String,Double>> graph,String s, String d,HashSet<String> vis, double[] temp,double[] result){
        
        if(s.equals(d)){  // reached destination
            result[0]=temp[0]; // storing computed result in our final result
            return;
        }
        
        if(graph.get(s)!=null){
            vis.add(s);
            for(Map.Entry<String,Double>i : graph.get(s).entrySet()){
                if(!vis.contains(i.getKey())){ // visiting all unvisited neighbours
                    temp[0]*=i.getValue();
                    dfs(graph,i.getKey(),d,vis,temp,result);
                    temp[0]/=i.getValue();
                    if(result[0]!=-1)break; // if result already found, no need to continue looping
                }
            }
        }
    }
}