//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    long second;
    public Pair(int f,long s){
        this.first = f;
        this.second = s;
        // (adj,dist)
    }
}
class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int edge = roads.size();
        for(int i = 0 ; i < edge ;i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1) , roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0) , roads.get(i).get(2)));
        }
        int[] ways = new int[n];
        long[] distance = new long[n] ;
        for(int i = 0 ; i < n ; i++) {
            distance[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        int src = 0 ; 
        int dest = n - 1;
        ways[src] = 1;
        distance[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->(int) (a.second - b.second));
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            Pair p = pq.peek();
            pq.remove();
            int node = p.first;
            long dist = p.second;
            for(Pair an : adj.get(node)){
                int adjNode = an.first;
                long adjDist = an.second;
                long  val = dist + adjDist;
                if(val < distance[adjNode]){
                    ways[adjNode] = ways[node];
                    distance[adjNode] = val;
                    pq.add(new Pair(adjNode,val));
                }
                else if(val == distance[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}
