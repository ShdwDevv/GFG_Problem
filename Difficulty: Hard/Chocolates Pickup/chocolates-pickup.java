//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int recursion(int r,int c1,int c2,int n,int m,int[][] mat,int[][][] dp){
        if(c1 < 0 || c2 >= m || c2 < 0 || c1 >= m) return (int)1e-8;
        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
        if(r == n-1){
            if(c1 == c2) return mat[r][c1];
            else return mat[r][c1] + mat[r][c2];
        }
        int maxVal = 0;
        for(int i = -1;i <= 1;i++){
            for(int j = -1;j <= 1;j++){
                if(c1 == c2) maxVal = Math.max(maxVal,mat[r][c1] + recursion(r+1,c1+i,c2+j,n,m,mat,dp));
                else maxVal = Math.max(maxVal,mat[r][c1] + mat[r][c2] + recursion(r+1,c1+i,c2+j,n,m,mat,dp));
            }
        }
        return dp[r][c1][c2] = maxVal;
    }
    public int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        for(int[][] mat : dp){
            for(int[] arr : mat){
                Arrays.fill(arr,-1);
            }
        }
        return recursion(0,0,m-1,n,m,grid,dp);
    }
}