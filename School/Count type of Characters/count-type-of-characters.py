#User function Template for python3

class Solution:
    def count (self,s):
        res = [0 for i in range(4)]
        for c in s:
            val = ord(c)
            if(val >= 48 and val <= 57) : res[2] += 1
            elif(val >= 65 and val <= 90) : res[0] += 1
            elif(val >= 97 and val <= 122) : res[1] += 1
            else:res[3] += 1
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int (input ())
for tc in range (t):
    s = input ()
    ob = Solution()
    res = ob.count (s)
    
    for i in res:
        print (i)
    
# Contributed By: Pranay Bansal

# } Driver Code Ends