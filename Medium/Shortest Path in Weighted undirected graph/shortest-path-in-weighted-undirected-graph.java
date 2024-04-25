//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for(int i = 0; i < m; i++){
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);
            
            ot.println(list.get(0));
            if(list.get(0) != -1 && !check(list, edges))
                ot.println(-1);
        }
        ot.close();
    }
    static boolean check(List<Integer> list, int edges[][]){
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for(int i = 1; i < list.size(); i++)
            hs.add(list.get(i));
        for(int x[] : edges){
            if(hs.contains(x[0]) || hs.contains(x[1])){
                if(!hm.containsKey(x[0]))
                    hm.put(x[0], new HashMap<>());
                if(!hm.containsKey(x[1]))
                    hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for(int i = 1; i < list.size() - 1; i++){
            if(!hm.containsKey(list.get(i)) || !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
} 

// } Driver Code Ends

class Pair{
    int dis;
    int node;
    public Pair(int a,int b){
        this.dis = a;
        this.node = b;
    }
}

class Solution{
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        //  Code Here.
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n;i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        int[] distance = new int[n+1];
        int[] parent = new int[n+1];
        for(int i =1;i<= n;i++){
            distance[i] = (int)1e9;
            parent[i] = i;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        pq.add(new Pair(0,1));
        distance[1] = 0;
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int disV = pq.peek().dis;
            pq.remove();
            for(Pair u : adj.get(node)){
                int disU = u.dis;
                int nodeU = u.node;
                if(disU + disV < distance[nodeU]){
                    distance[nodeU] = disU + disV;
                    pq.add(new Pair(disU+disV,nodeU));
                    parent[nodeU] = node;
                }
            }
            
        }
        // System.out.println(Arrays.toString(parent));
        if(distance[n] == 1e9) return Arrays.asList(-1);
        List<Integer> res = new ArrayList<>();
        int k = n;
        // int f = 0;
        res.add(k);
        while(parent[k] != k){
            res.add(parent[k]);
            k = parent[k];
        }
        res.add(distance[n]);
        // res.add(distance[n]);
        // System.out.println(res.toString());
        Collections.reverse(res);
        // System.out.println(res.toString());
        return res;
    }
}