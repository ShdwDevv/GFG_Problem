//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public int findFirst(int[] arr,int n,int x){
        int lo = 0;
        int hi = n - 1;
        int res = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == x){
                res = mid;
                hi = mid -1;
            }
            else if(arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return res;
    }
    public int findLast(int[] arr,int n,int x){
        int res = -1;
        int lo = 0; 
        int hi = n - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] == x){
                res = mid;
                lo = mid + 1;
            }
            else if(arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return res;
    }
    int count(int[] arr, int n, int x) {
        int st = findFirst(arr,n,x);
        int sp = findLast(arr,n,x);
        if(st == -1) return 0;
        return sp - st + 1 ;
    }
}