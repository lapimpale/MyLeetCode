class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
       if(finalSum % 2 != 0)return List.of();
        long s = finalSum;
        List<Long> list = new ArrayList<>();
        for(long h = 2;s >= h;h+=2){
            list.add(h);
            s -= h;
        }
        list.set(list.size()-1, list.get(list.size()-1) + s);
        return list;
    }
}