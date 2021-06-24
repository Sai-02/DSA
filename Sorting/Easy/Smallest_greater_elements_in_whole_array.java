/*
Given an array A of N length. We need to calculate the next greater element
 for each element in a given array. If the next greater element is
  not available in a given array then we need to fill ‘-10000000’ at that index place.

Example 1:

â€‹Input : arr[ ] = {13, 6, 7, 12}
Output : _ 7 12 13 
Explanation:
Here, at index 0, 13 is the greatest value 
in given array and no other array element 
is greater from 13. So at index 0 we fill 
'-10000000'.


â€‹Example 2:

Input : arr[ ] = {6, 3, 9, 8, 10, 2, 1, 15, 7} 
Output :  7 6 10 9 15 3 2 _ 8
 

Your Task:
This is a function problem. 
The input is already taken care of by the driver code.
 You only need to complete the function greaterElement()
  that takes an array (arr), sizeOfArray (n), and return
   an array that displays the next greater element to element at that index.
    The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105
-106 ≤ Ai ≤ 106
*/

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Smallest_greater_elements_in_whole_array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            int sizeOfArray = Integer.parseInt(br.readLine());
            int arr[] = new int[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Complete obj = new Complete();
            arr = obj.greaterElement(arr, sizeOfArray);
            for (int i = 0; i < sizeOfArray; i++) {
                if (arr[i] == -10000000)
                    System.out.print("_ ");
                else
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

// User function Template for Java

// User function Template for Java

class Complete {

    // Function for finding maximum and value pair
    public static int[] greaterElement(int arr[], int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int index = getIndex(arr, n, a[i]);
            if (index == n - 1) {
                a[i] = -10000000;
            } else {
                a[i] = arr[index + 1];
            }
        }

        return a;
    }

    public static int getIndex(int a[], int n, int target) {
        int l = 0, r = n - 1;
        int index = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == target) {
                index = mid;
                l = mid + 1;
            } else if (a[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return index;
    }

}
