//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int N, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < N;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer>  arr : prerequisites){
            adj.get(arr.get(1)).add(arr.get(0));
        }
        int[] inDegree = new int[N];
        for(int i = 0 ;i < N ; i++){
            for(int n : adj.get(i)){
                inDegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < N;i++){
            if(inDegree[i] == 0) q.add(i);
        }
        int[] res = new int[N];
        int count = 0;
        while(!q.isEmpty()){
            
            int node = q.peek();
            res[count++] = node;
            q.remove();
            for(int n : adj.get(node)){
                inDegree[n]--;
                if(inDegree[n] == 0 )q.add(n);
            }
        }
        if(count == N) return res;
        return new int[0];

    }
}