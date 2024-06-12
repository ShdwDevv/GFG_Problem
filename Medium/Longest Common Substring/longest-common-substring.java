//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int res = 0;
        int[][] dp = new int[n+1][m+1];
        for(int c = 0 ; c <= m;c++) dp[0][c] = 0;
        for(int r = 0; r <= n;r++) dp[r][0] = 0;
        for(int r = 1; r <= n;r++){
            for(int c = 1;c <= m;c++){
                if(S1.charAt(r-1) == S2.charAt(c-1)) {
                    dp[r][c] = 1 + dp[r-1][c-1];
                    res = Math.max(dp[r][c],res);
                }
                else dp[r][c] = 0 ;
            }
        }
        return res;
    }
}