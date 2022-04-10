class Solution(object):
    def minimizeResult(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        for cut in range(len(expression)):
            if expression[cut]=="+":
                break
        val1=expression[:cut]
        val2=expression[cut+1:]
        maxval=float("inf")
        res=""
        for i in range(len(val1)):
            for j in range(len(val2)):
                a=int(val1[:i]) if i>0 else 1
                b=int(val1[i:])+int(val2[:j+1])
                c=int(val2[j+1:]) if j<len(val2)-1 else 1
                cur=a*b*c
                if cur<maxval:
                    maxval=cur
                    res=val1[:i]+"("+val1[i:]+"+"+val2[:j+1]+")"+val2[j+1:]
        return res
        