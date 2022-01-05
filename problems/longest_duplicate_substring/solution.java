class Solution {
      public String longestDupSubstring(String s) {
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            nums[i] = s.charAt(i) - 'a';
        }
        
        int l = 1, r = s.length()-1;
        while(l+1<r)
        {
            int mid = l + (r-l)/2;
            if(findDuplicate(s, mid, nums).length()>0)
            {
                l = mid;
            }
            else
            {
                r = mid;
            }
        }
        
        String target = findDuplicate(s, r, nums);
        if(target.length()>0)return target;
        return findDuplicate(s, l, nums);
    }
    
    long MOD = 1_000_000_007;
    public String findDuplicate(String s, int len, int[] nums)
    {
        HashMap<Long, List<Integer>> hashToStart = new HashMap<>();
        
        long[] pows = new long[len];
        pows[0] = 1;
        for(int i = 1; i < len; i++)
        {
            pows[i] = pows[i-1] * 26;
            pows[i] %= MOD;
        }
        
        long cursum = 0;
        for(int i = 0; i < len; i++)
        {
            cursum  = ((cursum *26) % MOD + nums[i])%MOD;
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        hashToStart.put(cursum, list);
        
        for(int i = 1; i+len-1 < s.length(); i++)
        {
            cursum = (cursum - ((nums[i-1] *  pows[len-1]))%MOD + MOD)%MOD ;
            cursum =  ((cursum *26) % MOD + nums[i + len - 1])%MOD;
            List<Integer> temp =  hashToStart.getOrDefault(cursum, new ArrayList<>());
            
            if(temp.size()>0)
            {
                String target = s.substring(i, i+len);
                for(int last: temp)
                {
                    
                    String cur = s.substring(last, last+len);
                    if(cur.equals(target))
                    {
                        return cur;
                    }
                }
                
            }
            temp.add(i);
            hashToStart.put(cursum, temp);
        }
        
        return "";
    }
}