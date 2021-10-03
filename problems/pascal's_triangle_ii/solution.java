class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
    prev.add(1);
    
    List<Integer> curr;
    
    for(int i=1; i<rowIndex+1;i++)
    {
        curr = new ArrayList<>();
        curr.add(1);
        for(int j=1;j<i;j++)
        {
            curr.add(prev.get(j-1)+prev.get(j));
        }
        
        curr.add(1);
        prev=curr;
    }
   return prev; 
    }
}