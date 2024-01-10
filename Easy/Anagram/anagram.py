#User function Template for python3


class Solution:
    
    #Function is to check whether two strings are anagram of each other or not.
    def isAnagram(self,a,b):
        countA = [0] * 26
        countB = [0] * 26
        for c in a:
            countA[ord(c) - ord('a')] += 1
        for c in b:
            countB[ord(c) - ord('a')] += 1
        for i in range(len(countA)):
            if countA[i] != countB[i]:
                return False
        return True


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__=='__main__':
    t = int(input())
    for i in range(t):
        a,b=map(str,input().strip().split())
        if(Solution().isAnagram(a,b)):
            print("YES")
        else:
            print("NO") 
# } Driver Code Ends