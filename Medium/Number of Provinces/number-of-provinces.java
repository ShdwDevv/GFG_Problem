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
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0 ; i <= n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUltimateParent(int u){
        if(parent.get(u) == u) return u;
        int ultPar = findUltimateParent(parent.get(u));
        parent.set(u,ultPar);
        return parent.get(u);
    }
    public void unionByRank(int u,int v){
        int ul_u = findUltimateParent(u);
        int ul_v = findUltimateParent(v);
        if(ul_u == ul_v) return;
        if(rank.get(ul_u) < rank.get(ul_v)){
            parent.set(ul_u,ul_v);
        }
        else if(rank.get(ul_v) < rank.get(ul_u)){
            parent.set(ul_v,ul_u);
        }
        else{
            parent.set(ul_v,ul_u);
            rank.set(ul_v,rank.get(ul_u)+1);
        }
    }
    public void unionBySize(int u,int v){
        int ul_u = findUltimateParent(u);
        int ul_v = findUltimateParent(v);
        if(ul_u == ul_v) return;
        if(size.get(ul_u) < size.get(ul_v)){
            parent.set(ul_u,ul_v);
            size.set(ul_v,size.get(ul_v)+size.get(ul_u));
        }
        else{
            parent.set(ul_v,ul_u);
            size.set(ul_u,size.get(ul_u) + size.get(ul_v));
        }
    }
}

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        for(int i = 0 ; i < V;i++){
            for(int j = 0 ; j < adj.get(i).size();j++){
                if(adj.get(i).get(j) == 1) ds.unionBySize(i,j);
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < V;i++){
            if(ds.parent.get(i) == i) cnt++;
        }
        return cnt;
    }
};