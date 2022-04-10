from sortedcontainers import SortedList

class Solution:
    def maximumProduct(self, nums: List[int], k: int) -> int:
        if len(nums)==1:
            nums[0]+=k
            return nums[0]
        
        MOD=10**9+7
        nums=SortedList(nums)
        while k>0:
            # print(nums,k)
            val=nums.pop(0)
            newf=nums[0]
            diff=newf-val
            if diff+1<=k:
                k-=(diff+1)
                nums.add(newf+1)
            else:
                nums.add(val+k)
                k=0
        # print(nums,k)
        nums=list(nums)
        res=1
        for val in nums:
            res*=val
            res%=MOD
        return res