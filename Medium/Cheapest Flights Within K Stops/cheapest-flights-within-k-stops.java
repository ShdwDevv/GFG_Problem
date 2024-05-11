//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first ;
        this.second = second;
    }
}
class Triplet{
    int first;
    int second;
    int third;
    public Triplet(int f,int s,int t){
        this.first = f;
        this.second = s;
        this.third = t;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int edges = flights.length;
        for(int i = 0 ; i < edges ; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1] , flights[i][2]));
        }
        int[] distance = new int[n];
        for(int i = 0 ; i < n ; i++){
            distance[i] = (int)1e9;
        }
        distance[src] = 0 ;
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0,src,0));
        while(!q.isEmpty()){
            Triplet tp = q.peek();
            q.remove();
            int stop = tp.first;
            int node = tp.second;
            int cost = tp.third;
            if(stop > k) continue;
            for(Pair aj : adj.get(node)){
                int adjNode = aj.first;
                int adjDist = aj.second;
                if(cost + adjDist < distance[adjNode] && stop <= k){
                    distance[adjNode] = cost + adjDist;
                    q.add(new Triplet(stop+1,adjNode,cost+adjDist));
                }
            }
        }
        if(distance[dst] == (int)1e9) return -1;
        return distance[dst];
    }
}