class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int diff=1,total=0,count=1,i,check=0,prev=0;
        
    if(nums.length>=2)
        prev=(nums[0]-nums[1]);
        
        
    ArrayList<Integer>list=new ArrayList<Integer>();
    
    for(i=2;i<nums.length;i++)
    {
        if(prev==(nums[i-1]-nums[i]))
        {
            diff++;
            if(diff>=2)
            {
               list.add(count);
               count++;
            }
            
        }
        else
        {
          prev=(nums[i-1]-nums[i]);
            diff=1;
            count=1;
            check=1;
        }
        
    }
    
    for(int j=0;j<list.size();j++)
        total=total+list.get(j);
        
        
    return total;
    }
}