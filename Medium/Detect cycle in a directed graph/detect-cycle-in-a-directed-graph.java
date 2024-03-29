//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    boolean dfs(int idx, int[] visitAndPath, ArrayList<ArrayList<Integer>> adj) {
    visitAndPath[idx] = 2; // for visit and path
    for (int n : adj.get(idx)) {
        if (visitAndPath[n] == 0) {
            if (dfs(n, visitAndPath, adj)) return true;
        } else if (visitAndPath[n] == 2) return true;
    }
    visitAndPath[idx] = 1; // backtrack to 1 for only visit
    return false;
}
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       int[] visitAndPath = new int[V];
    for (int i = 0; i < V; i++) {
        if (visitAndPath[i] == 0) {
            if (dfs(i, visitAndPath, adj)) return true;
        }
    }
    return false;
    }
}
