class Solution {
    public int balancedStringSplit(String s) {
        int i =0, countL=0, countR=0, output=0;
while(i<s.length())
{
if(s.charAt(i) == 'L')
countL++;
else
countR++;

        if(countL == countR)
            output++;
        ++i;
    }
    return output;
    }
}