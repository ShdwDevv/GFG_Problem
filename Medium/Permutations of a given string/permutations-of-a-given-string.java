//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public String swap(String str,int l,int r){
        char[] s = str.toCharArray();
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        return String.valueOf(s);
    }
    public void permutate(String str,int l,int r,Set<String> res){
        if(l == r) res.add(str);
        else{
            for(int i = l ; i <= r;i++){
                str = swap(str,l,i);
                permutate(str,l+1,r,res);
                str = swap(str,i,l);
            }
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        Set<String> res = new HashSet<>();
        int n = S.length();
        permutate(S,0,n-1,res);
        List<String> res2 = new ArrayList<>(res);
        Collections.sort(res2);
        return res2;
    }
}