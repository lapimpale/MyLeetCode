class Solution {
Map<String,Boolean> map = new HashMap<>();
public boolean isScramble(String s1, String s2) {

    if(s1.length() == 1){
        return s1.equals(s2);
    }
    
    int n = s1.length();
    
    if(map.containsKey(s1+s2)){
        return map.get(s1+s2);
    }
    
    for(int i = 1;i < s1.length();i++){
        boolean flag = false;
        if(isScramble(s1.substring(0,i),s2.substring(n - i)) && isScramble(s1.substring(i),s2.substring(0,n - i))){
            
            flag = flag | true;
        }
        
        
        if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))){
            flag = flag | true;
        }
        
        if(flag){
            map.put(s1+s2,true);
            return true;
        }
        
    }
    map.put(s1+s2,false);
    return false;
}
}