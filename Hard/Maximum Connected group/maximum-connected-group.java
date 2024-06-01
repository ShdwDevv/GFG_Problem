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
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// class Solution {
    
//     public int MaxConnection(int grid[][]) {
//         //Your code here
//     }
    
// }

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0 ; i <= n;i++){
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
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*m);
        int sum = 0;
        // Step 1 - Make Components
        for(int r = 0 ; r < n; r++){
            for(int c = 0 ; c < m ; c++){
                if(grid[r][c] == 0 )continue;
                int[] dRow = {-1,0,1,0};
                int[] dCol = {0,1,0,-1};
                for(int i = 0 ; i < 4;i++){
                    int nRow = r + dRow[i];
                    int nCol = c + dCol[i];
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1){
                        int u = (r * m) + c;
                        int v = (nRow * m) + nCol;
                        ds.unionBySize(u,v);
                    }
                }
            }
        }
        // Step 2 find largest value
        for(int r = 0 ; r < n;r++){
            for(int c = 0 ;c < m ;c++){
                if(grid[r][c] == 1) continue;
                int[] dRow = {-1,0,1,0};
                int[] dCol = {0,1,0,-1};
                Set<Integer> component = new HashSet<>();
                for(int i = 0 ; i < 4;i++){
                    int nRow = r + dRow[i];
                    int nCol = c + dCol[i];
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1){
                       component.add(ds.findUltimateParent((nRow * m )+nCol));
                    }
                }
                int temp = 0;
                for(int parent : component){
                    temp += ds.size.get(parent);
                }
                sum = Math.max(sum,temp+1);
            }
        }
        // If all are 1
        for(int i = 0 ; i < n *m ;i++){
            sum = Math.max(sum,ds.size.get(ds.findUltimateParent(i)));
        }
        return sum;
    }
}