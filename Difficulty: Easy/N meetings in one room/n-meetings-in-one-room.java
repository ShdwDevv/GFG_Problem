//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Triplet{
    int start,end,position;
    public Triplet(int a,int b,int c){
        this.start = a;
        this.end = b;
        this.position = c;
    }
}
class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
        Triplet[] arr = new Triplet[n];
        for(int idx = 0; idx <n;idx++){
            arr[idx] = new Triplet(start[idx],end[idx],idx+1);
        }
        Arrays.sort(arr,new Comparator<Triplet>(){
           @Override
           public int compare(Triplet a,Triplet b){
               return Integer.compare(a.end,b.end);
           }
        });
        int cnt = 1;
        int free = arr[0].end;
        for(int i = 1;i < n;i++){
            if(arr[i].start > free){
                cnt++;
                free = arr[i].end;
            }
        }
        return cnt;
    }
}
