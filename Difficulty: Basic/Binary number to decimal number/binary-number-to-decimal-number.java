//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.binary_to_decimal(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int binary_to_decimal(String str) {
        int pow = 0; 
        int res = 0;
        int n = str.length()-1;
        while(n >= 0){
            int v = str.charAt(n) - 48;
            if(v != 0)res += Math.pow(2,pow);
            pow++;
            n--;
        }
        // 2 ** pow
        return res;
    }
}