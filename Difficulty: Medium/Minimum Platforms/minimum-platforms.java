//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findPlatform(int arr[], int dept[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 0, j = 0;
        int cnt = 0;
        int res = 0;
        while(i < n){
            if(arr[i] <= dept[j]){
                cnt++;
                i++;
            }
            else{
                cnt--;
                j++;
            }
            res = Math.max(res,cnt);
        }
        return res;
    }
    
}

