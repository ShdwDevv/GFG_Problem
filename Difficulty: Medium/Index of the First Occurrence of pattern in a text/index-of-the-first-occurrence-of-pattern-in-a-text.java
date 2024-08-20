//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String text = sc.next();
            String pat = sc.next();
            Solution obj = new Solution();
            int res = obj.findMatching(text, pat);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMatching(String text, String pat) {
        int n = text.length();
        int m = pat.length();
        int idx = 0;
        int res = -1;
        boolean found = false;
        while(idx < n && !found){
            if(text.charAt(idx) == pat.charAt(0)){
                int x = idx;
                found= true;
                for(int j = 0; j < m;j++){
                    if(x >= n || text.charAt(x++) != pat.charAt(j)) found = false;
                }
                if(found) res = idx;
            }
            idx++;
        }
        return res;
    }
}
