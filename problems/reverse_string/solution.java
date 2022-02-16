class Solution {
    char []s;
    public void reverseString(char[] s) {
        this.s=s;
        recursion(0,s.length-1);
        
    }
    void recursion(int i,int j)
    {
        if(i>=j)
            return;
        char temp=s[j];
        s[j]=s[i];
        s[i]=temp;
        recursion(i+1,j-1);
    }
}