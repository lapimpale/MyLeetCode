class Solution {
    public int distanceBetweenBusStops(int[] distance, int s, int d) {
        int n = distance.length;
        int i = (s+1)%n;
        int min = Integer.MAX_VALUE;
        int sum = distance[s];
        while(i != s) {
            if (i == d) {
                min = Math.min(min, sum);
                sum = 0;
            } 
            sum += distance[i];
            i = (i+1)%n;
        }
        min = Math.min(min, sum);
        return min;
    }
}