//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> res = new ArrayList<>();
        int n = s.length();
        int subset = 1 << n;
        for(int count = 1 ; count < subset;count++){
            StringBuilder sub = new StringBuilder();
            for(int j = 0; j < n;j++){
                if((count & (1 << j)) > 0) sub.append(s.charAt(j));
            }
            res.add(new String(sub));
        }
        Collections.sort(res);
        return res;
    }
}