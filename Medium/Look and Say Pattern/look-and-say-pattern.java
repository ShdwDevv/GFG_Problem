//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        int times = 0;
        List<Integer> prev = Arrays.asList(1);
        if(n == 1) return "1";
        for(int i = 1 ; i < n;i++){
            List<Integer> curr = new ArrayList<>();
            int cnt = 1;
            int size = prev.size();
            for(int c = 0;c < size;c++){
                if(c == size - 1 || prev.get(c) != prev.get(c+1)){
                curr.add(cnt);
                curr.add(prev.get(c));
                cnt = 1;
                }
                else{
                    cnt++;
                }
            }
            prev = curr;
        }
        // System.out.println(prev);
        StringBuilder res = new StringBuilder();
        for(int v : prev) res.append(""+v);
        return new String(res);
    }
}
