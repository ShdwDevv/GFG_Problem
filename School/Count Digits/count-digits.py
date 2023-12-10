#User function Template for python3


class Solution:
    def evenlyDivides (self, N):
        T = N
        count = 0
        while N > 0:
            # print(N)
            d = N % 10
            # print(d)
            if not d ==0 and  T % d == 0 : count +=1
            N = N//10
        return count


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
       

        ob = Solution()
        print(ob.evenlyDivides(N))
# } Driver Code Ends