class Solution 
{
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(res , new ArrayList<Integer>() ,1, n , k);
        
        return res;
    }
    
    public void backtrack(List<List<Integer>>res,List<Integer>ds,int id,int n,int k)
    {
        if(ds.size() == k && n == 0)
        {
            res.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(int j = id; j <= 9; j++)
        {
            if(j > n)
                break;

            ds.add(j);
            backtrack(res, ds, j + 1, n - j, k);
            ds.remove(ds.size() - 1);
        }
    }
}