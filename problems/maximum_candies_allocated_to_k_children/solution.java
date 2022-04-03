class Solution {
public int maximumCandies(int[] candies, long k) {
long total = 0;
for(int can : candies)
total+=can;
//check if total of candies can be spilt for each child.
if(total<k)
return 0;

    int ret = 0;
    long left = 1; // left set to 1, minimal posible candy in each pile, 
    long right = total+1; // right equals total + 1 since bianry search is excluding the right boundaries
    while(left<right)
    {
        long mid = left + (right - left)/2;
        long numberOfPiles = getNumberOfPiles(candies, mid);
        
        ///piles less than k, meaning the number of piles with given number candies is not engouth for k children
        ///in order to try to using less candies to construct piles
        ///move right to mid, since excluding right boundaries and mid have already been checked.
        if(numberOfPiles<k)
            right = mid;
        else if(numberOfPiles>=k)
        {
            ///piles lager or equals than k, meaning the number of piles with given number candies is engouth for k children
            ///in order to try to get maximal candies
            ///move left to mid + 1, since mid have already been checked
            left = mid+1;
            ret = (int)mid;
        }
    }
    return ret;
}


///split into piles by given number of candies
/// return the number of piles which contains given number of candies.
public long getNumberOfPiles(int[] candies, long num)
{
    long ret = 0;
    for(int c : candies)
        ret += c/num;
    return ret;
}
}