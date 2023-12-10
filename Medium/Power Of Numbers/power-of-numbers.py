#User function Template for python3

class Solution:
    #Complete this function
    def power(self,N,R):
        if N is None or R is None:
            return None
        
       
        a = pow(N, R, 1000000007)
        
        # Calculate the remainder
        b = a % 1000000007
        return b



#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math

def main():
    
    T=int(input())
    
    while(T>0):
        
        N=input()
        R=N[::-1]
        
        ob=Solution();
        ans=ob.power(int(N),int(R))
        print(ans)
        
        T-=1

if __name__=="__main__":
    main()
# } Driver Code Ends