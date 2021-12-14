class Solution {
    public int singleNumber(int[] nums) {
        int count=0;
for(int i=0;i<nums.length-1;i++)
{
for(int j=i+1;j<nums.length;j++)
{
if(nums[i]==nums[j])
{
nums[i]=0;
nums[j]=0;

            }
                
            
        }
    }
    for(int j=0;j<nums.length;j++)
        count=count+nums[j];
    return count;
    }
}