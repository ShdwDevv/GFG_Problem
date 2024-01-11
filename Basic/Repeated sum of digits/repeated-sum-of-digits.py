#User function Template for python3
class Solution:
    def digSum(self,N):
        if N < 10:
            return N
        return N%10 + self.digSum(N//10)
    def repeatedSumOfDigits (self,N):
        res = N
        while res >= 10:
            res = self.digSum(res)
            
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        
        N=int(input())
      
        ob = Solution()
        print(ob.repeatedSumOfDigits(N))
# } Driver Code Ends