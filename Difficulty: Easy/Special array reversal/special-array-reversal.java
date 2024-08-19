//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.reverse(s));                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean isValid(char c){
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
    public String reverse(String str)
    {
        int l = 0;
        int r = str.length() - 1;
        char[] s = str.toCharArray();
        while(l < r){
            while(l < str.length() && !isValid(str.charAt(l)))l++;
            while(r >= 0 && !isValid(str.charAt(r)))r--;
            if(l >= r) break;
            Character temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
        StringBuilder res = new StringBuilder();
        for(char c : s) res.append(c);
        return res.toString();
    }
}