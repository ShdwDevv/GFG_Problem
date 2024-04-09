//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<Integer> bfs(List<List<Integer>> adj,int V){
        int[] inDegree = new int[V];
        for(int i = 0 ; i < V; i++){
            for(int n : adj.get(i)){
                inDegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ;i++){
            if(inDegree[i] == 0)q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            res.add(node);
            for(int n : adj.get(node)){
                inDegree[n]--;
                if(inDegree[n] == 0) q.add(n);
            }
        }
        return res;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i  < K ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < N - 1 ; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int length = Math.min(s1.length(),s2.length());
            for(int idx = 0 ; idx < length;idx++){
                if(s1.charAt(idx) != s2.charAt(idx)){
                    adj.get(s1.charAt(idx) - 'a').add(s2.charAt(idx) - 'a');
                    break;
                }
            }
        }
        List<Integer> topoSort = bfs(adj,K);
        String res = "";
        for(int it : topoSort){
            res = res + (char) (it + (int)'a');
        }
        return res;
    }
}