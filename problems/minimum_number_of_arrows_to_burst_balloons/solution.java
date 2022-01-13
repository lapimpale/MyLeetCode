class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] > b[1]) return 1;
                return -1;
            }
        });
        
        int arrowPos = points[0][1];
        int count = 1;
        
        for(int i=1; i<points.length; i++){
            if(points[i][0] > arrowPos){
                count++;
                arrowPos = points[i][1];
            }
        }
        
        return count;
    }
}