//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int s) {
        // code here.
        // int[] res = new int[1];
        // recursion(coins,N,0,res,sum);
        // return res[0];
        
        long[] dp = new long[s + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 0; i < N; ++i) {
            for (int j = coins[i]; j <= s; ++j) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[s];
    }
    // static void recursion(int[] arr,int N,int idx,int[] res,int sum){
    //     if(idx == N){
    //         if(sum == 0){
    //             res[0]++;
    //         }
    //         return;
    //     }
    //     if(arr[idx] <= sum){
    //         // curr.add(arr[idx]);
    //         recursion(arr,N,idx,res,sum-arr[idx]);//pick
    //         // curr.remove(curr.size() - 1);
    //     }
    //     recursion(arr,N,idx+1,res,sum);
    // }
}