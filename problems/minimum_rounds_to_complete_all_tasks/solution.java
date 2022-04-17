class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int task: tasks){
            if(hm.containsKey(task)){
                hm.put(task, hm.get(task)+1);
            }else{
                hm.put(task,1);
            }
        }
        
        int days = 0;
        
        for(Integer i : hm.keySet()){
            Integer freq = hm.get(i);
            if(freq==1) return -1;
            if(freq==2) days++; 
            if(freq==3) days++;
            if(freq>=4){
                int u = freq/3;
                int rem = freq - u*3;
                if(rem == 0){
                    days+=u;
                }
                if(rem == 1|| rem==2){
                    days+= u+1;
                }
            }
        }
        
        return days;
    }
}