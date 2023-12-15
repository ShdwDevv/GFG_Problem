#User function Template for python3

class Solution:
	def is_palindrome(self, n):
		res = 0
		temp = n
		while n > 0:
		    dig = n % 10
		    res = res * 10 + dig
		    n //= 10
		if res == temp : return "Yes"
		else : return "No"


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		ob = Solution();
		ans = ob.is_palindrome(n)
		print(ans)
# } Driver Code Ends