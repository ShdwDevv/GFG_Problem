# Your task is to complete this function
# Function should return True/False or 1/0
def PalinArray(arr ,n):
    for val in arr:
        temp = val
        res = 0
        while val > 0 : 
            res = res * 10 + val % 10
            val //= 10
        if temp != res:return False
    return True
    



#{ 
 # Driver Code Starts
# Driver Program
if __name__=='__main__':
    t=int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        if PalinArray(arr, n):
            print(1)
        else:
            print(0)
# Contributed By: Harshit Sidhwa

# } Driver Code Ends