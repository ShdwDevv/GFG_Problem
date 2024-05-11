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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first,second;
    public Pair(int f,int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        int n = arr.length;
        int mod = 100000;
        Queue<Pair> q = new LinkedList<>();
        int[] distance = new int[100000];
        for(int i = 0 ; i < 100000 ;i++){
            distance[i] = (int)1e9;
        }
        distance[start] = 0;
        q.add(new Pair(start,0));
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            int node = p.first;
            int step = p.second;
            for(int i = 0 ; i < n;i++){
                int num = (arr[i] * node) % mod;
                if(step + 1 < distance[num]){
                    distance[num] = step + 1;
                    if(num == end) return step+1;
                    q.add(new Pair(num,step+1));
                }
            }
        }
        return -1;
    }
}
