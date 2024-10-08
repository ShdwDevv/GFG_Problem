//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int power(int n,int x,int m){
        long ans = 1;
        for(int i=1;i <= n;i++){
            ans *= x;
            if(ans > m) return 2; // large
        }
        if(ans == m) return 1; // equal
        return 0;//small
    }
    public int NthRoot(int n, int m)
    {
        int lo = 1;
        int hi = m;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int res = power(n,mid,m);
            if(res == 1) return mid;
            else if(res == 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
// public static int func(int mid, int n, int m) {
//         long ans = 1;
//         for (int i = 1; i <= n; i++) {
//             ans = ans * mid;
//             if (ans > m) return 2;
//         }
//         if (ans == m) return 1;
//         return 0;
//     }

//     public static int NthRoot(int n, int m) {
//         // Use binary search on the answer space:
//         int low = 1, high = m;
//         while (low <= high) {
//             int mid = (low + high) / 2;
//             int midN = func(mid, n, m);
//             if (midN == 1) {
//                 return mid;
//             } else if (midN == 0) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }
//         return -1;