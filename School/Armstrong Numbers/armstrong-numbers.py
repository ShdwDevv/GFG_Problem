#User function Template for python3

#User function Template for python3
class Solution:
    def armstrongNumber (self, n):
        temp = n
        res = 0
        while n > 0:
            dig = n % 10
            res += (dig*dig*dig)
            n //=10
        if res == temp : return "Yes"
        else: return "No"

#{ 
 # Driver Code Starts
#Initial Template for Python 3
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        n = input()
        n=int(n)
        ob = Solution()
        print(ob.armstrongNumber(n))
# } Driver Code Ends