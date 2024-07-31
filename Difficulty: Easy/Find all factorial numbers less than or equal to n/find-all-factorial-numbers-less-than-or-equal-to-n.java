//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static long fact(int n){
        if(n <= 1) return (long) 1;
        return (long) n * fact(n-1);
    }
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> res = new ArrayList<>();
        for(int i = 1; i <= n;i++){
            long val = fact(i);
            // System.out.println(val);
            if(val > n) break;
            
            res.add(val);
        }
        return res;
    }
}