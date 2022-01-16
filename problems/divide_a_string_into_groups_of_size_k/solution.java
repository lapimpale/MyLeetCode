class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len=0;
        int rem = s.length()%k;
        if(rem==0){
            len = s.length()/k;
        }else{
            len = (s.length()/k)+1;
        }
        int startIndex=0,endIndex=s.length();
        String[] res = new String[len];
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(startIndex<endIndex){  
                if(startIndex+k<=endIndex){
                    res[i]=s.substring(startIndex,startIndex+k);
                }else{
                    if(rem==0) break;
                    for(int j=startIndex;j<startIndex+k;j++){
                        if(j<endIndex){
                            sb.append(s.charAt(j));
                        }else{
                            sb.append(fill);
                        }                        
                    }
                    res[i]= sb.toString();
                    break;
                }
                startIndex=startIndex+k;            
                i++;
        }
        return res;
    }
        
}