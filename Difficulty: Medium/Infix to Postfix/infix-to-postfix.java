//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int precedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':return 3;
        }
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : exp.toCharArray()){
            if(Character.isLetterOrDigit(c)) sb.append(c);
            else if(c == '(') st.push(c);
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '(') sb.append(st.pop());
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek())){
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            if(st.peek() == '(') return "Invalid Expression";
            sb.append(st.pop());
        }
        return sb.toString();
    }
}