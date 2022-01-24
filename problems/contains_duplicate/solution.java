class Solution {
    public boolean containsDuplicate(int[] nums) {
        // create an empty set
    Set<Integer> set = new HashSet<Integer>();
 
    // do for every array element
    for (Integer e: nums)
    {
        // return true if a duplicate is found
        if (set.contains(e)) {
            return true;
        }
 
        // insert the current element into a set
        if (e != null) {
            set.add(e);
        }
    }
 
    // no duplicate is found
    return false;
    }
}