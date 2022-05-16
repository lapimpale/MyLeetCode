import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, Integer> skylineMap = new TreeMap<>();
        skylineMap.put(-1, 0);
        
        for (int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];

            // Add end entry
            if (skylineMap.floorEntry(end).getValue() < height) {
                skylineMap.put(end, skylineMap.floorEntry(end).getValue());
            }
            
            // Add start entry
            if (skylineMap.floorEntry(start).getValue() < height) {
                skylineMap.put(start, height);
            }
            
            // Update entries in between
            SortedMap<Integer, Integer> subMap = skylineMap.subMap(start, end);
            for (int key : subMap.keySet()) {
                if (subMap.get(key) < height) {
                    subMap.put(key, height);
                }
            }
        }
        
		// Scan through entries in ascending key order, removing dups in the process
        List<List<Integer>> ans = new ArrayList<>();
        int previousHeight = 0;
        while (!skylineMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = skylineMap.pollFirstEntry();
            if (entry.getValue() != previousHeight) {
                previousHeight = entry.getValue();        
                ans.add(Arrays.asList(entry.getKey(), entry.getValue()));
            }
        }
        
        return ans;
    }
}