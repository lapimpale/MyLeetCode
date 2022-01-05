class Solution {
    public String addBinary(String num1, String num2) {
        //int get the max size of the result
        int maxLen=num1.length()>=num2.length()?num1.length()+1:num2.length()+1;
        //define the size of 2 pointers of sum and result pointer
        int i=num1.length()-1,j=num2.length()-1,k=maxLen-1;
        //define result
        int[] res=new int[maxLen];
        //iterate over the arrays
       while(i>=0 || j>=0){
            //add the number to result
            if(i>=0)  res[k]+=num1.charAt(i--)-'0';       
            if(j>=0) res[k]+=num2.charAt(j--)-'0';                            
           //store the carry over to the i-1 cell
           res[k-1]=res[k]/2;
           //store the rem to the curr cell
           res[k]=res[k--]%2;        
        }
        StringBuilder sb=new StringBuilder();
        i=0;
        //remove leading zeros
        while( i<res.length-1 && res[i]==0)
            ++i;
        //store result to String
        for ( ;i < res.length;++i)
            sb.append(res[i]) ;
        return sb.toString();
    }
}