class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int m = numArrows;
        int max = 0;
        int arg = 0;
        for(int i = 0;i < 1<<12;i++){
            int sc = 0;
            int ne = 0;
            for(int j = 0;j < 12;j++){
                if(i<<~j<0){
                    ne += aliceArrows[j] + 1;
                    sc += j;
                }
            }
            if(ne <= numArrows && max < sc){
                max = sc;
                arg = i;
            }
        }
        int[] b = new int[12];
        int rem = numArrows;
        for(int i = 0;i < 12;i++){
            if(arg<<~i<0){
                b[i] = aliceArrows[i] + 1;
                rem -= b[i];
            }
        }
        b[11] += rem;
        return b;
    }
}