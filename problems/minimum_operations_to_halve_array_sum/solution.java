class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int val : nums){
            pq.add((double)val);
            sum = sum + 1D*val;
        }
        double csum = sum;
        int ans = 0;
        while(csum > sum/2.0){
            double cur = pq.remove();
            csum -= cur/2.0;
            pq.add(cur/2.0);
            ans++;
        }
        return ans;
    }
}