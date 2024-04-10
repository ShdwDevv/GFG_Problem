//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first,int last){
        this.first = first;
        this.second = last;
    }
}
//User function Template for Java
class Solution {
    public void dfs(int node,ArrayList<ArrayList<Pair>> adj,boolean[] visit, Stack<Integer> st){
        visit[node] = true;
        for(int i = 0; i < adj.get(node).size() ; i++){
            int v = adj.get(node).get(i).first;
            if(!visit[v]) dfs(v,adj,visit,st);
        }
        st.add(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0;i < N;i++){
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		for(int i = 0 ; i < M ; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int w = edges[i][2];
		    adj.get(u).add(new Pair(v,w));
		}
// 		System.out.println(adj.toString());
		boolean[] visit = new boolean[N];
		Stack<Integer> st = new Stack<>();
		for(int i = 0;i < N;i++){
		    if(!visit[i]) dfs(i,adj,visit,st);
		}
		int[] distance = new int[N];
		for(int i = 0 ; i < N ; i++){
		    distance[i] = (int)(1e9);
		}
		distance[0] = 0;
// 		System.out.println(st.toString());
		while(!st.isEmpty()){
		    int node = st.peek();
		    st.pop();
		    for(int i = 0;i < adj.get(node).size();i++){
		        int v = adj.get(node).get(i).first;
		        int w = adj.get(node).get(i).second;
		        if((distance[node] + w) < distance[v]){
		            distance[v] = w + distance[node];
		        }
		      //  System.out.println(Arrays.toString(distance));
		    }
		}
		for(int i = 0 ; i < N;i++){
		    if(distance[i] == 1e9) distance[i] = -1;
		}
		return distance;
	}
}