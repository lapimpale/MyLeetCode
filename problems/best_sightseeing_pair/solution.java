class Solution {
    public int maxScoreSightseeingPair(int[] values) {
         PriorityQueue<Integer>P=new PriorityQueue<>(Collections.reverseOrder());
        int max=0;
      for(int i=0;i<values.length;++i){
        if(i>0){
            max=Math.max(P.peek()+values[i]-i,max);
        }
        P.add(values[i]+i);
    }
        return max;
    }
}