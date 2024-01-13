#User function Template for python3
class Solution:
    def minManipulation(self, N, s1, s2): 
        s1_list = list(s1)
        s2_list = list(s2)
     
        s1_list.sort()
        s2_list.sort()
     
        i, j, count = 0, 0, 0
     
        # Compare characters in sorted lists
        while i < len(s1_list) and j < len(s2_list):
            if s1_list[i] == s2_list[j]:
                i += 1
                j += 1
            elif s1_list[i] < s2_list[j]:
                i += 1
                count += 1
            else:
                j += 1
                count += 1
     
        # Count the remaining characters in both lists
        count += len(s1_list) - i + len(s2_list) - j
        return count // 2
     


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int(input())
    for _ in range(t):
        N = int(input().strip())
        S1,S2 = input().strip().split()
        ob = Solution()
        ans = ob.minManipulation(N, S1, S2)
        print(ans)
# } Driver Code Ends