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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int distance;
    int row;
    int col;
    public Pair(int a,int b,int c){
        this.distance = a;
        this.row = b;
        this.col = c;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        Pair src = new Pair(0,source[0],source[1]);
        Queue<Pair> q = new LinkedList<>();
        q.add(src);
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        visit[source[0]][source[1]] = true;
        while(!q.isEmpty()){
            // System.out.println("YEs");
            int dis = q.peek().distance;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            // System.out.println("Row : "+row+" Col : "+col);
            if(row == destination[0] && col == destination[1]) return dis;
            for(int i = 0 ;i < 4;i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >=0 && nCol >= 0 && nRow < n && nCol < m && grid[nRow][nCol] == 1 && !visit[nRow][nCol] ){
                    visit[nRow][nCol] = true;
                    q.add(new Pair(dis+1,nRow,nCol));
                }
            }
        }
        return -1;
        // Your code here
    }
}

        