class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }
        
        List<Integer> list = grayCode(n-1);
        for (int i = list.size() -1; i>=0 ; i--) {
            list.add(1<<(n-1) | list.get(i));
        }        
        return list;
    }
}