class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] queue = new int[1001];
        for(int i = 0; i < trips.length; i++){
            // if(trips[i][0] > capacity){
            //     return false;
            // }
            queue[trips[i][1]] -= trips[i][0];
            queue[trips[i][2]] += trips[i][0];
        }
        for(int i = 0; i < queue.length; i++){
            capacity = capacity + queue[i];
            if(capacity < 0){
                return false;
            }
        }
        return true;
    }
}