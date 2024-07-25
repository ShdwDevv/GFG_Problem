//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static  boolean isOperator(char c){
        switch(c){
            case '+':case '-':case '*':case '/':case '%':return true;
        }
        return false;
    }
    static String postToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for(char c : exp.toCharArray()){
            if(isOperator(c)){
                String s1 = st.pop();
                String s2 = st.pop();
                st.push("("+s2+c+s1+")");
            }
            else st.push(c+""); // add with empty string to make the character to string
        }
        return st.pop();
    }
}

