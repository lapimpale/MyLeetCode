class Solution {
    LinkedList<int[]> merged = new LinkedList<>();

    public int[][] insert(int[][] intervals, int[] newInterval) {    

        // add intervals before newInterval
        int start = 0;
        for (; start < intervals.length; start++) {
          int[] interval = intervals[start];
          if (newInterval[0] <= interval[0]) break;
          add(interval);
        }

        // add newInterval
        add(newInterval);

        // add intervals after newInterval
        for ( ; start < intervals.length; start++) {
          int[] interval = intervals[start];
          add(interval);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public void add(int[] interval) {
        if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
          merged.add(interval);
        }
        else {
          merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
    }
}