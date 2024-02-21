//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        int[][] visit = new int[n][n];
        
        if(m[0][0] == 1){
            visit[0][0] = 1;
            solve(0,0,m,n,res,"",visit);
        }
        return res;
    }
    static void solve(int i,int j,int[][] m,int n,ArrayList<String> res,String s,int[][] visit){
        // System.out.println("I "+i+" J "+j+" s "+s);
        if(i == n -1 && j == n-1){
            
            res.add(s);
            return;
        }
        
        // D -> L -> R -> U 
        // Down
        if((i + 1 < n) && (visit[i+1][j] == 0) && (m[i+1][j] == 1)){
            visit[i+1][j] = 1;
            solve(i + 1,j,m,n,res,s+"D",visit);
            visit[i+1][j] = 0;
        }
        // Left
        if((j - 1 >= 0) && (visit[i][j-1] == 0) && (m[i][j-1] == 1)){
            visit[i][j-1] = 1;
            solve(i,j-1,m,n,res,s+"L",visit);
            visit[i][j-1] = 0;
        }
        // RIGHT
        if((j + 1  < n) && (visit[i][j+1] == 0) && m[i][j+1] == 1){
            visit[i][j+1] = 1;
            solve(i,j+1,m,n,res,s+"R",visit);
            visit[i][j+1] = 0;
        }
        // UP
        if((i - 1 >= 0) && (visit[i-1][j] == 0) && m[i-1][j] == 1){
            visit[i-1][j] = 1;
            solve(i - 1,j,m,n,res,s+"U",visit);
            visit[i-1][j] = 0;
        }
    }
}