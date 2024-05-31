//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends

class DisjointSet{
    // List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0 ; i <= n;i++){
            // rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUltimateParent(int u){
        if(parent.get(u) == u) return u;
        int ultPar = findUltimateParent(parent.get(u));
        parent.set(u,ultPar);
        return parent.get(u);
    }
    public void unionBySize(int u,int v){
        int ul_u = findUltimateParent(u);
        int ul_v = findUltimateParent(v);
        if(ul_u == ul_v) return;
        if(size.get(ul_u) < size.get(ul_v)){
            parent.set(ul_u,ul_v);
            size.set(ul_v,size.get(ul_v)+size.get(ul_u));
        }
        else{
            parent.set(ul_v,ul_u);
            size.set(ul_u,size.get(ul_u) + size.get(ul_v));
        }
    }
}
//User function Template for Java

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);
    Map<String,Integer> map = new HashMap<>();
    for(int i = 0 ; i < n;i++){ 
        for(int j = 1; j < accounts.get(i).size() ;j++){
            String mail = accounts.get(i).get(j);
            if(map.containsKey(mail) == false) map.put(mail,i);
            else ds.unionBySize(i,map.get(mail));
        }
    }
    
    List<String>[] mergeMail = new ArrayList[n];
    for(int i = 0 ; i < n;i++) mergeMail[i] = new ArrayList<String>();
    for(Map.Entry<String,Integer> it : map.entrySet()){
        String mail = it.getKey();
        int node = ds.findUltimateParent(it.getValue());
        mergeMail[node].add(mail);
    }
    List<List<String>> res = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
        if(mergeMail[i].size() == 0) continue;
        Collections.sort(mergeMail[i]);
        List<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String it : mergeMail[i]) temp.add(it);
        res.add(temp);
    }
    return res;
  }
}
     