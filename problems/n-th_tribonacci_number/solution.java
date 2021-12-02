class Solution {
    public int tribonacci(int n) {
        
         int a = 0;
    int b = 1;
    int c = 1;
    
    if(n ==0)
    {
        return a;
    }
    else if(n==1)
    {
        return b;
    }
    else if(n==2)
    {
        return c;
    }
    else
    {
        int val=0;
        for(int i = 3;i<=n;i++) // i =3 // i=4
        {
            
           val = a + b + c; // 0 + 1 + 1 // 1+1+2
           a = b; // a=1 // a=1
           b = c; // b = 1 // b = 2
           c = val;// c = 2 // c = 4
            
           
        }
        return  c; //c = 4
    }
  }
}