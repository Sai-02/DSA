/*
Given an array arr[] of size N,
 find the first repeating element. 
 The element should occurs more than once and the index of its first occurrence should be
  the smallest.

 

Example 1:

Input:
N = 7
arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation: 
5 is appearing twice and 
its first appearence is at index 2 
which is less than 3 whose first 
occuring index is 3.

Example 2:

Input:
N = 4
arr[] = {1, 2, 3, 4}
Output: -1
Explanation: 
All elements appear only once so 
answer is -1.

Your Task:
You don't need to read input or print anything.
 Complete the function firstRepeated() which takes arr and
  N as input parameters and return the position of the first repeating element. 
  If there is no such element, return -1.
The position you return should be according to 1-based indexing. 

 

Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)

 

Constraints:
1 <= N <= 106
0 <= Ai<= 106
 */

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class First_Repeating_Element {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total count of elements
            int n = sc.nextInt();

            // creating a new array of size n
            int arr[] = new int[n];

            // inserting elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // calling firstRepeated method
            // and printing the result
            System.out.println(firstRepeated(arr, n));
        }

    }

    // } Driver Code Ends
    // User function Template for Java

    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]);
                count++;
                hm.replace(arr[i], count);

            } else {
                hm.put(arr[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = hm.get(arr[i]);
            if (count > 1) {
                return i + 1;
            }
        }
        return -1;
    }

    // { Driver Code Starts.

} // } Driver Code Ends

// ======================================================
// 
// GFG Editorial
// 
// =====================================================

// Use hashing to find the first repeating element.


// Take a Map to store the count of elements in the array.
// Traverse the input array and each time you encounter an element,
//  increment it’s count in the map.
// Now traverse the map and check for the elements with count greater than 1.
// Store the index and break the loop.
// Return the index. 



	//Function to return the position of the first repeating element.
	// public static int firstRepeated(int []arr, int n) {
        
    //     boolean flag = false;
    //     int ans = -1;
        
    //     //using map to store frequency of each element.
    //     Map<Integer, Integer> m = new HashMap<>(); 
        
    //     //storing the frequency of each element in map.
    //     for (int i = 0; i < n; i++) { 
    //         if (m.containsKey(arr[i])) { 
    //             m.put(arr[i], m.get(arr[i]) + 1); 
    //         } 
    //         else { 
    //             m.put(arr[i], 1); 
    //         } 
    //     } 
        
    //     //iterating over the array elements.
    //     for (int i = 0; i < n; i++)
    //     {
    //         //if frequency of current element in map is greater than 1,
    //         //then we store the index and break the loop.
    //         if (m.get(arr[i])>1)
    //         {
    //             ans = i+1;
    //             break;
    //         }
    //     }
        
    //     //returning the position of the first repeating element.        
    //     return ans; 
      
    // }
    
