class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int count=0;
        for(int i=0;i<k;i++)
        {
            List<Integer> lst = new ArrayList<>();
            for(int j=i;j<arr.length;j+=k)
            {
                lst.add(arr[j]);
            }
            count +=(lst.size()-countLis(lst));
        }
        return count;
    }
    private int countLis(List<Integer> list)
     {
         List<Integer> newList = new ArrayList<>();
         for(int i=0;i<list.size();i++)
         {
             int x = list.get(i);
             if(newList.size()==0 || newList.get(newList.size()-1)<=x)
             {
                 newList.add(x);
             }
             else
             {
                 int index = binarySearch(newList, x);
                 newList.remove(index);
                 newList.add(index, x);
             }
         }
         return newList.size();
     }
                         
    private int binarySearch(List<Integer> list,int x)
     {
         int l=0,r=list.size()-1;
         while(l<r)
         {
             int mid = l+(r-l)/2;
             if(list.get(mid)<=x)
             {
                 l =mid+1;
             }
             else
             {
                 r= mid;
             }
         }
         return l;
     }
}