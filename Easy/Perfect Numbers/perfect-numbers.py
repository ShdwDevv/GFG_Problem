#User function Template for python3
import math
class Solution:
    def isPerfectNumber(self, N):
        sum = 1
        m = int(math.sqrt(N))
        for i in range(2,m+1):
            if N%i == 0:
                # print("Div",N/i)
                sum += i + int(N/i)
        # print(sum)
        if sum == N and N != 1:
            return 1
        else:
            return 0


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N=int(input())
        
        ob = Solution()
        print(ob.isPerfectNumber(N))
# } Driver Code Ends