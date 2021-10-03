class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        
        for(int i=0;i<numRows;i++){
            int value=1;
            List<Integer> list=new ArrayList();
            for(int j=0;j<=i;j++){
                list.add(value);
                value=value*(i-j)/(j+1);
            }
            ans.add(list);
        }
        return ans;
    }
}