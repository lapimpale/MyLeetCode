class Solution {
    public String largestGoodInteger(String num) {
        long max=-1;
        String res="";
        for(int i=0; i<num.length()-2; i++)
        {
            if(Integer.parseInt(num.substring(i,i+3))>max)
            {
                if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2))
                {
                    max=Integer.parseInt(num.substring(i,i+3));
                    res=num.substring(i,i+3);
                }
            }
        }
        return res;
    }
}