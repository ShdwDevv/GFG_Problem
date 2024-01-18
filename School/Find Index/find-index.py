#User function Template for python3

class Solution:
    def findIndex (self,a, N, key ):
        res = []
        for i in range(N):
            if a[i] == key:
                res.append(i)
        if len(res) < 1:return [-1,-1]
        res = [res[0],res[-1]]
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3


t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    key=int(input())
    ob = Solution()
    ans=ob.findIndex(a, n, key )
    print(*ans)
    
# } Driver Code Ends