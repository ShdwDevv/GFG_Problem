//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int dist;
    Pair(int a,int b){
        this.node = a;
        this.dist = b;
    }
}
class Edge implements Comparable<Edge>{
    int src,dest,weight;
    public Edge(int a,int b,int c){
        this.src = a;
        this.dest = b;
        this.weight = c;
    }
    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }
}
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
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        // int[] visit = new int[V];
        // for(List<int[]> a:adj){
        //     for(int[] b : a){
        //         System.out.println(Arrays.toString(b));
        //     }
        //     System.out.println("Finish");
        // }
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        // pq.add(new Pair(0,0));
        // int sum = 0;
        // while(!pq.isEmpty()){
        //     Pair min = pq.peek();
        //     pq.remove();
        //     int node = min.node;
        //     int dist = min.dist;
        //     if(visit[node] == 1) continue;
        //     visit[node] = 1;
        //     sum += dist;
        //     for(int i = 0 ; i < adj.get(node).size() ; i++){
        //         int edgW = adj.get(node).get(i)[1];
        //         int adjNode = adj.get(node).get(i)[0];
        //         if(visit[adjNode] == 0) pq.add(new Pair(adjNode,edgW));
        //     }
        // }
        // return sum;
        
        
        // Krushkals
        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < V;i++){
            for(int j = 0; j < adj.get(i).size();j++){
                int adjNode = adj.get(i).get(j)[0];
                int adjWeight = adj.get(i).get(j)[1];
                Edge edge = new Edge(i, adjNode, adjWeight);
                edges.add(edge);
            }
        }
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edges);
        int weight = 0;
        for(Edge edge : edges){
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;
            if(ds.findUltimateParent(u) != ds.findUltimateParent(v)){
                weight += w;
                ds.unionBySize(u, v);
            }
        }
        return weight;
    }
}