//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	void selectionSort(int arr[], int n)
	{
	    for(int outer = 0;outer < n - 1;outer++){
	        int minIdx = outer;
	        for(int inner = outer + 1; inner < n;inner++){
	            if(arr[inner] < arr[minIdx]) minIdx = inner;
	        }
	        if(outer != minIdx){
	            int temp = arr[outer];
	            arr[outer] = arr[minIdx];
	            arr[minIdx] = temp;
	        }
	    }
	}
}