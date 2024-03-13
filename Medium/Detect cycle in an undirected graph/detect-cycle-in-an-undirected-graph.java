//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int curr,prev;
    public Pair(int node,int prev){
        this.curr = node;
        this.prev = prev;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visit = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!visit[i]){
                if(checkForCycle(i,V,adj,visit)) return true;
            }
        }
        return false;
        
    }
    public boolean checkForCycle(int idx,int V,ArrayList<ArrayList<Integer>> adj,boolean[] visit){
        visit[idx] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(idx,-1));
        while(!q.isEmpty()){
            int node = q.peek().curr;
            int prev = q.peek().prev;
            q.remove();
            for(int v : adj.get(node)){
                if(!visit[v]){
                  visit[v] = true;
                  q.add(new Pair(v,node));
                } 
                else if(prev != v) return true;
            }
        }
        return false;
    }
}