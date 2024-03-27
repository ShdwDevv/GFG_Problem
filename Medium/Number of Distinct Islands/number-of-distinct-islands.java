//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int row,int col,int[][] grid,boolean[][] visit,ArrayList<String> s,int rowBase,int colBase){
        visit[row][col] = true;
        s.add(toString(row - rowBase,col - colBase));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        for(int idx = 0 ; idx < 4;idx++){
            int nRow = row + delRow[idx];
            int nCol = col + delCol[idx];
            if(nRow >=0 && nCol >=0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == 1 && !visit[nRow][nCol]){
                dfs(nRow,nCol,grid,visit,s,rowBase,colBase);
            }
        }
    }
    public String toString(int r,int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        HashSet<ArrayList<String>> res = new HashSet<>();
        for(int r = 0 ; r < n; r++){
            for(int c = 0 ; c < m ;c++){
                if(grid[r][c] == 1 && !visit[r][c]){
                    ArrayList<String> s = new ArrayList<>();
                    dfs(r,c,grid,visit,s,r,c);
                    res.add(s);
                }
            }
        }
        return res.size();
    }
}
