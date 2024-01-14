#User function Template for python3
class Solution:

	def fascinating(self,n):
        two = n * 2
        three = n*3
        s = str(n) + str(two) + str(three)
        res = list(s)
        c = ['1','2','3','4','5','6','7','8','9']
        # print(res)
        if len(res) != 9 : return False
        for v in c:
            if v not in res:return False
        return True


#{ 
 # Driver Code Starts
#Initial Template for Python 3



if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n = int(input().strip())
        ob = Solution()
        ans = ob.fascinating(n)
        if ans:
            print("Fascinating")
        else:
            print("Not Fascinating")
        tc -= 1

# } Driver Code Ends