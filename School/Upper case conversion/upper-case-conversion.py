#User function Template for python3

class Solution:
    def transform(self, s):
        l = s.split()
        for i in range(len(l)):
            # l[i].capitalize()
            l[i] = l[i].capitalize()
        return " ".join(l)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        s = input().strip()
        ob = Solution()
        print(ob.transform(s))
# } Driver Code Ends