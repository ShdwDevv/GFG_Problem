#User function Template for python3

class Solution:
	def find_fact(self, n):
		if n == 1:
		    return 1
		return n * self.find_fact(n-1)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		ob = Solution();
		ans = ob.find_fact(n)
		print(ans)

# } Driver Code Ends