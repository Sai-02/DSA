/*
Given an array containing N elements. 
The task is to find the maximum number of distinct elements
 after removing K elements from the array.

Example 1:

Input : Arr[] = {5, 7, 5, 5, 1, 2, 2}, K = 3
Output : 4
Explanation:
Remove 2 occurrences of element 5 and 
1 occurrence of element 2.

Example 2:

Input : Arr[] = {1, 2, 3, 4, 5, 6, 7}, K = 5
Output : 2

Your Task:
This is a function problem. The input is already taken care of 
by the driver code. You only need to complete the function maxDistinctNum()
 that takes an array (arr), sizeOfArray (n), integer value K, 
 and return the maximum distinct elements after removing K elements.
  The driver code takes care of the printing.

Expected Time Complexity: O(K*logD) 
 where D is the number of distinct elements in the given array.
Expected Auxiliary Space: O(N).
 

Constraints:
1 ≤ K ≤ N ≤ 106
1 ≤ A[i] ≤ 105

 
 */
// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;

// } Driver Code Ends

// User function Template for Java

public class Maximum_distinct_elements_after_removing_K_elements {

    int maxDistinctNum(int a[], int n, int k) {
        HashSet<Integer> h = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (h.contains(a[i])) {
                count++;
            } else {
                h.add(a[i]);
            }

        }
        if (count > k) {
            return h.size();

        } else {
            count = count - k;
            return h.size() + count;
        }
    }

}

// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] element = line1.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");

            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Maximum_distinct_elements_after_removing_K_elements obj = new Maximum_distinct_elements_after_removing_K_elements();
            int res = obj.maxDistinctNum(arr, sizeOfArray, K);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



// =========================
// 
//  GFG EDitorial
// 
// ========================

// Approach: Following are the steps:

// Create a hash table to store the frequency of each element.
// Insert frequency of each element in a max heap.
// Now, perform the following operation k times.
//  Remove an element from the max heap.
//   Decrement its value by 1. 
//   After this, if element is not equal to 0,
//    then again push the element in the max heap.
// After the completion of step 3, the number of elements in
//  the max heap is the required answer.



