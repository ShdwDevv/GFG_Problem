//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        int[] alpha = new int[26];
        for(int i = 0 ; i < s.length();i++){
            char letter = s.charAt(i);
            if(letter >= 'A' && letter <= 'Z'){
                alpha[letter - 'A']++;
            }
            else if(letter >= 'a' && letter <= 'z'){
                alpha[letter - 'a']++;
            }
        }
        for(int i = 0 ; i < 26;i++){
            if(alpha[i] == 0) return false;
        }
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends