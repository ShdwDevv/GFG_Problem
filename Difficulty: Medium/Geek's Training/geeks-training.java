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
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int recur(int[][] arr,int day,int last,int[][] dp){
        int maxVal = Integer.MIN_VALUE;
        if(day == 0){
            for(int i = 0; i < 3;i++){
                if(i != last) 
                    maxVal = Math.max(maxVal,arr[day][i]);
            }
            return maxVal;
        }
        if(dp[day][last] != -1) return dp[day][last];
        for(int i = 0; i < 3;i++){
            if(i != last){
                int points = arr[day][i] + recur(arr,day-1,i,dp);
                maxVal = Math.max(maxVal,points);
            }
        }
        return dp[day][last] =  maxVal;
    }
    public int maximumPoints(int arr[][], int N) {
        int[][] dp = new int[N][4];
        for(int i = 0; i < N;i++) Arrays.fill(dp[i],-1);
        return recur(arr,N-1,3,dp);
    }
}