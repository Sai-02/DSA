/*
Given an array arr of n elements which is first increasing and then may be decreasing, 
find the maximum element in the array.
Note: If the array is increasing then just print then last element
 will be the maximum value.

Example 1:

Input: 
n = 9
arr[] = {1,15,25,45,42,21,17,12,11}
Output: 45
Explanation: Maximum element is 45.
Example 2:

Input: 
n = 5
arr[] = {1, 45, 47, 50, 5}
Output: 50
Explanation: Maximum element is 50.
Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function findMaximum()
  which takes the array arr[], and n as parameters
   and returns an integer denoting the answer.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ n ≤ 106
1 ≤ arri ≤ 106
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Bitonic_Point {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    int findMaximum(int[] arr, int n) {
        int l = 0, r = n - 1;
        int max = -1;
        max = Math.max(max, arr[0]);
        max = Math.max(max, arr[n - 1]);
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                l = mid + 1;
                continue;
            }
            if (mid == n - 1) {
                r = mid - 1;
                continue;
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            }
        }
        return max;
    }
}

// =====================================================
// 
//  GFG Editorial
// 
// =====================================================


// We can modify the standard Binary Search algorithm for the given type of arrays.
// i) If the mid element is greater than both of its adjacent elements, 
//    then mid is the maximum.
// ii) If mid element is greater than its next element and smaller than the previous
//     element then maximum lies on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
// iii) If mid element is smaller than its next element and greater than
//      the previous element then maximum lies on right side of mid.
//        Example array: {2, 4, 6, 8, 10, 3, 1}