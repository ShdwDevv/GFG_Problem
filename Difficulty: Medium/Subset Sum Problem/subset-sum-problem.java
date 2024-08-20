//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean recursion(int idx,int[] arr,int target,int[][] dp){
        if(target == 0) return true;
        if(idx == 0) return target == arr[0];
        if(dp[idx][target] != -1) {
            if(dp[idx][target] == 1) return true;
            else return false;
        }
        boolean notPick = recursion(idx-1,arr,target,dp);
        boolean pick = false;
        if(target >= arr[idx]) pick = recursion(idx-1,arr,target - arr[idx],dp);
        dp[idx][target] = pick || notPick ? 1 : 0;
        return pick || notPick;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N][sum+1];
        for(int[] a : dp)Arrays.fill(a,-1);
        return recursion(N-1,arr,sum,dp);
    }
}