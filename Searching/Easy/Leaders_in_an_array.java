
/*
Given an array A of positive integers.
 Your task is to find the leaders in the array. 
 An element of array is leader if it is greater than or equal to all
  the elements to its right side. The rightmost element is always a leader. 

 

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included.
 

Example 2:

Input:
n = 5
A[] = {1,2,3,4,0}
Output: 4 0
 

Your Task:
You don't need to read input or print anything.
 The task is to complete the function leader()
  which takes array A and n as input parameters
   and returns an array of leaders in order of their appearance.

 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
 */
// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Leaders_in_an_array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {

            // input size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // inserting elements in the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution3 obj = new Solution3();

            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();

            // calling leaders() function
            res = obj.leaders(arr, n);

            // appending result to a String
            for (int i = 0; i < res.size(); i++) {
                str.append(res.get(i) + " ");
            }

            // printing the String
            System.out.println(str);
        }

    }
}
// } Driver Code Ends

class Solution3 {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> a = new ArrayList<>();
        int i = 0, j = arr.length - 1;
        // Reversing the arrray
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

        }
        int max = -1;
        for (i = 0; i < n; i++) {
            if (max <= arr[i]) {
                a.add(arr[i]);
                max = arr[i];

            }
        }
        Collections.reverse(a);
        return a;
    }
}


// ====================================================
// 
// GFG Editorial
// 
// ====================================================


// Traverse all the elements from right to left in array and 
// check whether the current element is greater than the maximum stored till now.

// 1.Start iterating from the last element.

// 2.Check whether the current element is greater than the maximum stored till now

// 3.If it is greater, store the current element in a list and then update the maximum.

// 4.Reverse the list and return it.


// class Solution{
//     //Function to find the leaders in the array.
//     static ArrayList<Integer> leaders(int arr[], int n){
        
//         int maxEle = arr[n-1];
        
//         ArrayList<Integer> res = new ArrayList<>();
        
//         //We start traversing the array from last element.
//         for(int i=n-1; i>=0; i--) {
            
//             //Comparing the current element with the maximum element stored. 
//             //If current element is greater than max, we add the element.
// 		    if(arr[i] >= maxEle){
// 		        //Updating the maximum element.
// 		        maxEle = arr[i];
// 		        //Storing the current element in arraylist for leaders.
// 		        res.add(maxEle);
// 		    }
// 		}
		
// 		//Reversing the arraylist.
// 		Collections.reverse(res);
// 		//returning the arraylist.
//         return res;
//     }
    
// }