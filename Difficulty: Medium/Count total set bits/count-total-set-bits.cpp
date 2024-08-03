//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    
    private:
    
    int larPowOf2(int n){
        
        int x = 0;
        while((1 << x) <= n) x++;
        return x - 1;
        
    }
    
    public:
    
    int countSetBits(int n){
        
        if(n == 0) return 0;
        
        int x = larPowOf2(n);
        int y = x * (1 << (x - 1));
        int z = n - (1 << x);
        
        return y + z + 1 + countSetBits(z);
        
    }
};

//{ Driver Code Starts.

// Driver code
int main()
{
	 int t;
	 cin>>t;// input testcases
	 while(t--) //while testcases exist
	 {
	       int n;
	       cin>>n; //input n
	       Solution ob;
	       cout << ob.countSetBits(n) << endl;// print the answer
	  }
	  return 0;
}

// } Driver Code Ends