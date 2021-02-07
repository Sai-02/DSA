/*
Given a sorted array arr[] of distinct integers.
 Sort the array into a wave-like array and return it.
  In other words, arrange the elements into a
   sequence such that a1 >= a2 <= a3 >= a4 <= a5..... 
   (considering the increasing lexicographical order).

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 2 1 4 3 5
Explanation: Array elements after 
sorting it in wave form are 
2 1 4 3 5.
 

Example 2:

Input:
N = 6
arr[] = {2,4,7,8,9,10}
Output: 4 2 8 7 10 9
Explanation: Array elements after 
sorting it in wave form are 
4 2 8 7 10 9.
Your Task:
The task is to complete the function convertToWave() 
which converts the given array to wave array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
0 ≤ A[i] ≤107

 

Company Tags
 */

// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Wave_Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());// taking size of array
            int arr[] = new int[n]; // declaring array of size n
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
            }

            Solution obj = new Solution();

            obj.convertToWave(arr, n);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");

            System.out.println(sb); // print array
        }
    }
}

// } Driver Code Ends

class Solution {

    // Function to convert the given array to wave like array
    // arr: input array
    // n: size of the array
    public static void convertToWave(int a[], int n) {

        for (int i = 1; i < n; i++) {
            int temp = a[i - 1];
            a[i - 1] = a[i];
            a[i] = temp;
            i++;
        }

    }

}

// { Driver Code Starts.
// } Driver Code Ends