//{ Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int row = matrix.length;
        int col = matrix[0].length;
        for(int r = 0 ; r < row;r++){
            for(int c = 0 ; c < col;c++){
                if(matrix[r][c] == -1) matrix[r][c] = (int)1e9;
                if(r == c) matrix[r][c] = 0;
            }
        }
        for(int via = 0;via < row;via++){
            for(int r = 0;r < row;r++){
                for(int c = 0 ; c < col;c++){
                    matrix[r][c] = Math.min(matrix[r][c] , matrix[r][via]+matrix[via][c]);
                }
            }
        }
        for(int r = 0;r < row;r++){
            for(int c = 0 ; c < col;c++){
                if(matrix[r][c] == (int)1e9) matrix[r][c] = -1;
            }
        }
    }
}