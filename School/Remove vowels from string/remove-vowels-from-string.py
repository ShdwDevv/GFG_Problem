#User function Template for python3
class Solution:
	def removeVowels(self, S):
	    vow = ["a","e","i","o","u"]
		t = list(s)
		res = ""
		for c in t:
		    if c in vow:
		        continue
		    res+=c
		return res
		    


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		s = input()
		
		ob = Solution()	
		answer = ob.removeVowels(s)
		
		print(answer)


# } Driver Code Ends