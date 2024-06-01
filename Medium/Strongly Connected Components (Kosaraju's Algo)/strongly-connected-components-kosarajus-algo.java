//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> st){
        visited[node] = true;
        for(int adjNode : adj.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode,adj,visited,st);
            }
        }
        st.push(node);
    }
    public void dfs2(int node,ArrayList<ArrayList<Integer>> adj2,boolean[] visited){
        visited[node] = true;
        for(int it : adj2.get(node)){
            if(!visited[it]) dfs2(it,adj2,visited);
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < V ;i++){
            if(!visited[i]){
                dfs(i,adj,visited,st);
            }
        }
        // REverse
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int i = 0 ; i < V;i++) adj2.add(new ArrayList<>());
        for(int i = 0; i < V;i++){
            visited[i] = false;
            for(int it : adj.get(i)){
                adj2.get(it).add(i);
            }
        }
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(!visited[node]){
                scc++;
                dfs2(node,adj2,visited);
            }
        }
        return scc;
    }
}
