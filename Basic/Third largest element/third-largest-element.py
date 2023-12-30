class Solution:
    def thirdLargest(se1lf,a, n):
        if len(a) < 3:
            return -1
        first = None
        second = float("-inf")
        third = float("-inf")
        for val in a:
            if first == None or  val > first:
                third = second
                second = first
                first = val
            elif second == None or val > second:
                third = second
                second = val
            elif third == None or val > third:
                third = val
        return third


#{ 
 # Driver Code Starts
# Your code goes here
if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        print(Solution().thirdLargest(arr, n))
# } Driver Code Ends