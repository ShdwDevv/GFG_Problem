#User function Template for python3
class Solution:
	def hasArrayTwoCandidates(self,arr, n, x):
		arr.sort()
		i = 0
		j = len(arr) - 1
		while i < j:
		    if arr[i] + arr[j] > x:
		        j -= 1
		    elif arr[i] + arr[j] < x:
		        i += 1
		    else:
		        return True
		return False


#{ 
 # Driver Code Starts
#Initial Template for Python 3



if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, x = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.hasArrayTwoCandidates(arr, n, x)
        if ans:
            print("Yes")
        else:
            print("No")
        tc -= 1

# } Driver Code Ends