//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void dfs(int i,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[i] = true;
        
        for(Integer u : adj.get(i)){
            if(!visited[u]) dfs(u,visited,adj);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // Convert matrix list to List
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();
        for(int i = 0;i < adj.size();i++){
            adjL.add(new ArrayList<>());
        }
        for(int i = 0; i< adj.size();i++){
            for(int j = 0;j < adj.get(0).size();j++){
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjL.get(i).add(j);
                    adjL.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0;i < V;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,adjL);
            }
        }
        return count;
    }
};