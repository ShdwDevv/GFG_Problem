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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



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
    public int maxRemove(int[][] stones,int n) {
        // int n = stones.length;
        int maxRow = 0; 
        int maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(maxRow,stone[0]);
            maxCol = Math.max(maxCol,stone[1]);
        }
        // System.out.println(maxRow + " " + maxCol);
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] stone : stones){
            int nRow = stone[0];
            int nCol = stone[1] + maxRow + 1;
            ds.unionBySize(nRow,nCol);
            map.put(nRow,1);
            map.put(nCol,1);
        }
        int cnt = 0;
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            if(ds.findUltimateParent(it.getKey()) == it.getKey()) cnt++;
        }
        // System.out.println(ds.size.toString());
        return n - cnt ; 
    }
}