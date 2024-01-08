#User function Template for python3

class Solution:
    def modify(self, s):
        vow = ["a","e","i","o","u"]
        temp = []
        for c in s:
            if c in vow:
                temp.append(c)
        new = []
        for i in range(len(s)):
            if s[i] in vow:
                new.append(temp.pop())
            else:
                new.append(s[i])
        return "".join(new)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        s = input().strip()
        ob = Solution()
        ans = ob.modify(s)
        print(ans)
# } Driver Code Ends