#User function Template for python3

class Solution:
    def scores(self, a, b, cc):
        for i in range(len(a)):
            if a[i] > b[i] : cc[0] += 1
            if a[i] < b[i] : cc[1] += 1
        
        
    	


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():

    T = int(input())

    while(T > 0):
    	a = [int(x) for x in input().strip().split()]
    	b = [int(x) for x in input().strip().split()]
    	
    	cc = [0, 0]
    	ob=Solution()
    	ob.scores(a, b, cc)
    	print(*cc)
    	
    	T -= 1

if __name__ == "__main__":
    main()







# } Driver Code Ends