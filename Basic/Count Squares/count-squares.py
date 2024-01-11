#User function Template for python3

class Solution:
    def countSquares(self, N):
        count = int(math.sqrt(N))
        if count**2 == N:
            return count - 1
        else:
            return count

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import math

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N=int(input())
        
        ob = Solution()
        print(ob.countSquares(N))
# } Driver Code Ends