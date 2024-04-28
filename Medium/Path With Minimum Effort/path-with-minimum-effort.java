//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Triplet{
    int d;
    int r;
    int c;
    public Triplet(int dis,int x,int y){
        this.d = dis;
        this.r = x;
        this.c = y;
    }
}

class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int[][] distance = new int[rows][columns];
        for(int i = 0 ; i < rows;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
        distance[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> a.d - b.d);
        pq.add(new Triplet(0,0,0)); // diff,r,c
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        while(!pq.isEmpty()){
            int diff = pq.peek().d;
            int row = pq.peek().r;
            int col = pq.peek().c;
            pq.remove();
            if(row == rows -1 && col == columns - 1) return distance[rows-1][columns-1];
            for(int i = 0 ; i < 4;i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < columns){
                    int newDiff = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]),diff);
                    if(newDiff < distance[nRow][nCol]){
                        distance[nRow][nCol] = newDiff;
                        pq.add(new Triplet(newDiff,nRow,nCol));
                    }
                }
            }
        }
        return 0;
    }
}
