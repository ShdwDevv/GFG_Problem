#User function Template for python3


class Solution:
    def missingNumber(self,array,n):
        tot = 1
        res = 0
        for i in range(0,n-1):
            tot += i + 2
            res += array[i]
        return tot - res


#{ 
 # Driver Code Starts
#Initial Template for Python 3




t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    s=Solution().missingNumber(a,n)
    print(s)
# } Driver Code Ends