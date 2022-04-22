class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i = 0;i< intervals.length;i++){
            int[] interval = intervals[i];
            map.put(interval[0], i);
        }
        
        int[] res = new int[intervals.length];
        Arrays.fill(res,-1);// Put default value
        
        for(int i = 0;i< intervals.length;i++){
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            if(entry != null) {
                res[i] = entry.getValue();
            }
        }
        return res;
    }
}