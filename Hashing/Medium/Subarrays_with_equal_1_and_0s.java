/*
Given an array containing 0s and 1s. 
Find the number of subarrays having equal number of 0s and 1s.

Example 1:

Input:
n = 7
A[] = {1,0,0,1,0,1,1}
Output: 8
Explanation: The index range for the 8 
sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), 
(4, 5) ,(2, 5), (0, 5), (1, 6)
Example 2:

Input:
n = 5
A[] = {1,1,1,1,0}
Output: 1
Explanation: The index range for the 
subarray is (3,4).
Your Task:
You don't need to read input or print anything
. Your task is to complete the function countSubarrWithEqualZeroAndOne() 
which takes the array arr[] and the size of the array as inputs and returns
 the number of subarrays with equal number of 0s and 1s.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 106
0 <= A[i] <= 1
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

public class Subarrays_with_equal_1_and_0s {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(new Solution1().countSubarrWithEqualZeroAndOne(arr, n));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution1 {
    // Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                count += hm.get(sum);
            }
            if (hm.containsKey(sum)) {
                hm.replace(sum, hm.get(sum) + 1);

            } else {
                hm.put(sum, 1);
            }
        }
        return count;

    }
}
