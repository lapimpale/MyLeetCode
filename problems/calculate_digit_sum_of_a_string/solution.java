class Solution {
    public String digitSum(String s, int k) {
        String val="";
        int total=0;
        
        if(s.length()<=k)
            return s;
        
        for(int i=0; i<s.length(); i=i+k)
        {
            for(int j=i;j<i+k && j<s.length(); j++)
            {
                total+=Integer.parseInt(""+s.charAt(j));
            }
            
            val+=""+total;
            //System.out.println("*"+total+ " , "+val);
            total=0;
        }
        Integer keyByIndex=0;
        String res=val;
        //System.out.println("###"+res);
        
        
        if(res.length()<=k)
            return res;
        else
            return digitSum(res,k);    }
}