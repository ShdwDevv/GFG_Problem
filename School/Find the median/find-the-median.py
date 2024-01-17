#User function Template for python3

class Solution:
	def find_median(self, v):
		v.sort()
		n = len(v)
		if n % 2 == 1:
		    return v[n//2]
		else:
		    return (v[n//2] + v[n//2-1])//2


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		v = list(map(int,input().split())) 
		ob = Solution();
		ans = ob.find_median(v)
		print(ans)
# } Driver Code Ends