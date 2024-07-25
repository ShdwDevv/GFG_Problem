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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isOperator(char c){
        switch(c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
                return true;
        }
        return false;
    }
    static String preToInfix(String pre_exp) {
        int n = pre_exp.length();
        Stack<String> st = new Stack<>();
        for(int i = n- 1; i>= 0; i--){
            char c = pre_exp.charAt(i);
            if(isOperator(c)){
                String s1 = st.pop();
                String s2 = st.pop();
                String s3 = "("+s1+c+s2+")";
                st.push(s3);
            }
            else st.push(c+"");
        }
        return st.pop();
    }
}
