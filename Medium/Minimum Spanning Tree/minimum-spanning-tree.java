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
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int[] visit = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            Pair min = pq.peek();
            pq.remove();
            int node = min.node;
            int dist = min.dist;
            if(visit[node] == 1) continue;
            visit[node] = 1;
            sum += dist;
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                int edgW = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];
                if(visit[adjNode] == 0) pq.add(new Pair(adjNode,edgW));
            }
        }
        return sum;
    }
}