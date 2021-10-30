class Solution {
    public String kthDistinct(String[] arr, int k) {
          //int dist_count = 0;
        int n = arr.length;
    Map <String, Integer> h = new HashMap<String, Integer> ();
        
    for (int i = 0; i < n; i++)
    {
        if(h.containsKey(arr[i]))
            h.put(arr[i], h.get(arr[i]) + 1);
        else
            h.put(arr[i], 1);
    }
 
    // If size of hash is
    // less than k.
    if (h.size() < k)
        return "";
 
    // Traverse array again and
    // find k-th element with
    // count as 1.
    int dist_count = 0;
    for (int i = 0; i < n; i++)
    {
        if (h.get(arr[i]) == 1)
            dist_count++;
        if (dist_count == k)
            return arr[i];
    }
    return "";
    }
}