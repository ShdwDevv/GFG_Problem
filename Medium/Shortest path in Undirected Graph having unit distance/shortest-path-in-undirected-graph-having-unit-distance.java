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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        
        int[] distance = new int[n];
        for(int i = 0 ; i < n ; i++){
            distance[i] = (int) (1e9);
        }
        // boolean[] visit = new boolean[n];
        distance[src] = 0;
        // visit[src] = true;
        while(!q.isEmpty()){
            // d++;
            int node = q.peek();
            q.remove();
            for(int nd : adj.get(node)){
                if(distance[node] + 1 < distance[nd]){
                    q.add(nd);
                    distance[nd] = distance[node] + 1;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(distance[i] == 1e9) distance[i] = -1;
        }
        return distance;
    }
}