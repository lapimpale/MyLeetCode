class Solution {
    public int findCircleNum(int[][] isConnected) {
    boolean [] visited=new boolean[isConnected.length];
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
        for(int i =0;i<isConnected.length;i++){
            if(visited[i]==false){
                ArrayList<Integer> list=new ArrayList<>();
               comps.add(DFSlist(isConnected,i,visited,list));
                
            }
        }
       
       /*  int pairs=0;
    for(int i =0;i<comps.size();i++){
        for(int j=i+1;j<comps.size();j++){
            int count=comps.get(i).size()*comps.get(j).size();
            pairs+=count;
        }
    }
        // if(pairs==0 && comps.size()==1){
        //     pairs=1;
        // }*/
        return comps.size();
    }
    
    public ArrayList<Integer> DFSlist(int[][] isConnected,int src,boolean [] visited,ArrayList<Integer> list){
        visited[src]=true;
        list.add(src);
        
        for(int i =0;i<isConnected.length;i++){
            if(i==src){
                continue;
            }
            
            if(isConnected[src][i]==1){
                if(visited[i]){
                    continue;
                }
                 DFSlist(isConnected,i,visited, list);
            }
        }
        
        return list;
        
    }
}