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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String word;
    int steps;
    public Pair(String a ,int b){
        this.word = a;
        this.steps = b;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        if(startWord.equals(targetWord)) return 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        // Adding value in Set
        Set<String> st = new HashSet<>();
        for(String s:wordList){
            st.add(s);
        }
        st.remove(startWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().steps;
            q.remove();
            if(word.equals(targetWord)) return step;
            for(int i = 0 ; i < word.length() ; i++){
                for(char c = 'a' ; c <= 'z';c++){
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = c;
                    String replacedWord = new String(replacedArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,step+1));
                    }
                }
            }
        }
        // If nothing available
        return 0;
    }
}