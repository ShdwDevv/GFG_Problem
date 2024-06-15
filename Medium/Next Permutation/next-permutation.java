//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static void swap(int i,int j,List<Integer> list){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    static void reverse(List<Integer> l,int lo,int h){
        // int lo = 0;
        // int h = l.size() - 1;
        while(lo < h){
            int t = l.get(lo);
            l.set(lo,l.get(h));
            l.set(h,t);
            lo++;
            h--;
        }
    }
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int idx = -1;
        List<Integer> res = new ArrayList<>();
        for(int v : arr) res.add(v);
        for(int i = N -2;i >= 0;i--){
            if(arr[i] < arr[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(res,0,N-1);
            return res;
        }
        for(int c = N - 1; c >= 0;c--){
            if(arr[c] > arr[idx]){
                swap(c,idx,res);
                break;
            }
        }
        reverse(res,idx+1,N-1);
        return res;
    }
}