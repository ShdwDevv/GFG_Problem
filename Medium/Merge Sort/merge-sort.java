//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r,int[] aux)
    {
         // Your code here
        
        for(int k = l ; k <= r ;k++){
            aux[k] = arr[k];
        }
        int i = l;
        int j = m+1;
        for(int k = l;k <= r;k++){
            if(i > m) arr[k] = aux[j++];
            else if(j > r) arr[k] = aux[i++];
            else if(aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
         
    }
    void sort(int[] arr,int l,int r,int[] aux){
        if(l >= r) return;
        int mid = (l + r) / 2;
        sort(arr,l,mid,aux);
        sort(arr,mid+1,r,aux);
        if(arr[mid] <= arr[mid+1]) return;
        merge(arr,l,mid,r,aux);
    }
    void mergeSort(int arr[], int l, int r)
    {
        int[] aux = new int[arr.length];
        //code here
        sort(arr,l,r,aux);
        
    }
}
