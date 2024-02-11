#User function Template for python3

class Solution:
	def AllPossibleStrings(self, s):
		sub = []
		for row in range(2**len(s)):
		    ss = ""
		    for i in range(len(s)):
		        if row & (1 << i):
		            ss += s[i]
		    if len(ss) != 0 : 
		        sub.append(ss)
		sub.sort()
		return sub


#{ 
 # Driver Code Starts

#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		s = input()
		ob = Solution();
		ans = ob.AllPossibleStrings(s)
		for i in ans:
			print(i, end = " ");
		print()
# } Driver Code Ends