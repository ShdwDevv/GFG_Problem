//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to find the number of islands.
        // Code here
        // BFS
    public void bfs(int r,int c, boolean[][] visit,char[][] grid,int n,int m){
        visit[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int delRow = -1;delRow <= 1;delRow++){
                for(int delCol = -1;delCol <= 1;delCol++){
                    int nRow = delRow + row;
                    int nCol = delCol + col;
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visit[nRow][nCol] && grid[nRow][nCol] == '1'){
                        visit[nRow][nCol] = true;
                        q.add(new Pair(nRow,nCol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        int count = 0;
        for(int row = 0;row < n;row++){
            for(int col = 0;col < m;col++){
                if(!visit[row][col] && grid[row][col] == '1'){
                    count++;
                    bfs(row,col,visit,grid,n,m);
                }
            }
        }
        return count;
    }
}
    