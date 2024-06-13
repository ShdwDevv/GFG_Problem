//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    arr = obj.greaterElement(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        if(arr[i] == -10000000)
		            System.out.print("_ ");
		        else
		            System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}



// } Driver Code Ends


//User function Template for Java

//User function Template for Java

//User function Template for Java

            

class Complete{
    public static int bs(int[] arr,int l,int h,int tar){
        int smallest = -10000000;
        while(l <= h){
            int mid = (l+h) / 2;
            if(arr[mid] > tar){
                smallest = arr[mid];
                h = mid - 1;
            }
            else {
                l = mid + 1; 
            }
        }
        return smallest;
    }
   
    // Function for finding maximum and value pair
    public static int[] greaterElement (int arr[], int n) {
        // Complete the function

        int[] temp = arr.clone();
        Arrays.sort(temp);
        for(int i = 0 ; i < n;i++){
            arr[i] = bs(temp,0,n-1,arr[i]);
        }
        return arr;
    }
    
    
}


