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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int findLow(int[][] mat,int n){
        int minVal = Integer.MAX_VALUE;
        for(int idx = 0 ; idx <n ; idx++){
            minVal = Math.min(minVal,mat[idx][0]);
        }
        return minVal;
    }
    public static int findHigh(int[][] mat,int n,int m){
        int maxVal = Integer.MIN_VALUE;
        for(int idx = 0 ; idx < n ;idx++){
            maxVal = Math.max(maxVal , mat[idx][m-1]);
        }
        return maxVal;
    }
    public static int upperBound(int[] arr,int n,int x){
        int lo = 0;
        int hi = n - 1;
        int ans = n;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] > x){
                ans = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ans;
    }
    public static int blackBox(int[][] mat,int n,int m,int x){
        int count = 0;
        // for(int idx = 0 ; idx < n;idx++){
        //     count += upperBound(mat[idx],m,x);
        // }
        for(int[] arr : mat){
            count += upperBound(arr,m,x);
        }
        return count;
    }
    int median(int matrix[][], int R, int C) {
        // code here    
        List<Integer> lst = new ArrayList<>();
        // for(int[] mat : matrix){
        //     for(int n : mat) lst.add(n);
        // }
        // int s = lst.size();
        // Collections.sort(lst);
        // return lst.get((s/2));
        
        int lo = findLow(matrix,R);
        int hi = findHigh(matrix,R,C);
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int smallEqual = blackBox(matrix,R,C,mid);
            int require = (R * C) / 2;
            if(smallEqual <= require){
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return lo;
    }
}