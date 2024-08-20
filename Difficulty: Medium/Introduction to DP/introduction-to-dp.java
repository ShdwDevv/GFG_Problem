//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long MOD = (long)(1e9 + 7);
    static long topDown(int n) {
        // if(n == 0) return 0;
        // if(n == 1) return 1;
        // long res = (topDown(n-1) + topDown(n-2)) % MOD;
        // // System.out.println(res);
        // return res % MOD;
        return bottomUp(n);
    }
    static long bottomUp(int n) {
        long prev2 = 0;
        long prev = 1;
        if(n == 0) return prev2;
        if(n == 1) return prev;
        for(int i = 2;i <= n;i++){
            long curr = (prev2 + prev)%MOD;
            prev2 = prev;
            prev = curr;
        }
        // System.out.println(prev);
        return prev % MOD;
        // return topDown(n);
    }
}
