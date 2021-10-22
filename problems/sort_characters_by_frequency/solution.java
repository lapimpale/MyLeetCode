class Solution {
    public String frequencySort(String s) {
        int[] f = new int[128];
        for(char c : s.toCharArray())
            f[c]++;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < f.length; i++)
            pq.offer(new int[] {i, f[i]});
        
        StringBuilder sb = new StringBuilder();
        while(pq.peek()[1] != 0) {
            int[] pair = pq.poll();
            int count = pair[1];
            while(count-- > 0)
                sb.append((char) pair[0]);
        }
        
        return sb.toString();
    }
}