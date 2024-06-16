//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n = image.length;
        int m = image[0].length;
        if(sr >= 0 && sr < n && sc >= 0 && sc <m){
            int find = image[sr][sc];
            if(find != newColor) solve(sr,sc,image,find,newColor,n,m);
        }
        return image;
    }
    static void solve(int r,int c,int[][] image,int find,int color,int n,int m){
        if(r < 0 || r >= n || c < 0 || c >= m || image[r][c] != find) return;
        image[r][c] = color;
        solve(r+1,c,image,find,color,n,m);
        solve(r,c+1,image,find,color,n,m);
        solve(r-1,c,image,find,color,n,m);
        solve(r,c-1,image,find,color,n,m);
    }
}