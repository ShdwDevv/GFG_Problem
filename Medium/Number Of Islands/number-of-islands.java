//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


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
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int n = rows;
        int m = cols;
        boolean[][] visited = new boolean[n][m];
        DisjointSet ds = new  DisjointSet(n *m);
        int cnt = 0 ; 
        List<Integer> res = new ArrayList<>();
        for(int[] operator : operators){
            int row = operator[0];
            int col = operator[1];
            if(visited[row][col] == true){
                res.add(cnt);
                continue;
            }
            visited[row][col] = true;
            cnt++;
            int[] dRow = new int[]{-1,0,1,0};
            int[] dCol = new int[]{0,1,0,-1};
            for(int i = 0 ; i < 4;i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol]){
                    int u = (row * m) + col ; 
                    int v = (nRow * m) + nCol;
                    if(ds.findUltimateParent(u) != ds.findUltimateParent(v)){
                        cnt--;
                        ds.unionBySize(u,v);
                    }
                }
            }
            res.add(cnt);
        }
        return res;
        
        
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends