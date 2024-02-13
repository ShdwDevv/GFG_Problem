//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
       ArrayList<Integer> res = new ArrayList<>();
       recur(0,arr,new ArrayList<>(),res,N);
       return res;
    }
    static void recur(int idx,ArrayList<Integer> arr,List<Integer> curr,List<Integer> res,int N){
        if(idx == N){
            int s = 0;
            for(int n : curr) s+= n;
            res.add(s);
            return;
        }
        curr.add(arr.get(idx));
        recur(idx + 1,arr,curr,res,N);
        curr.remove(curr.size() - 1);
        recur(idx+1,arr,curr,res,N);
        
    }
}