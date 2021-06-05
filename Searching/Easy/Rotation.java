/*
Given an ascending sorted rotated array Arr of distinct integers of size N.
 The array is right rotated K times. Find the value of K.

Example 1:

Input:
N = 5
Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4. 
The original sorted array is 1 2 3 4 5. 
We can see that the array was rotated 
1 times to the right.
Example 2:

Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 0
Explanation: The given array is not rotated.
Your Task:
Complete the function findKRotation() which takes array arr and size n,
 as input parameters and returns an integer representing the answer. 
 You don't to print answer or take inputs.

Expected Time Complexity: O(log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <=105
1 <= Arri <= 107

 

Company Tags
Topic Tags
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Rotation {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution11().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution11 {
    int findKRotation(int a[], int n) {
        int l = 0, r = n - 1;
        if (a[l] <= a[r]) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (a[mid] <= min) {
                minIndex = mid;
                min = a[mid];
            }
            if (a[mid] < a[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        if (a[mid] < min) {
            minIndex = mid;
            min = a[mid];
        }
        return minIndex;
    }
}


// ===============================================================
// 
//  GFG Editorial
// 
// =============================================================


// Here also we find the index of minimum element, but using Binary Search.
//  The idea is based on the below facts :

// The minimum element is the only element whose previous is greater than it. If there is no previous element, then there is no rotation (first element is minimum). We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.
// If the minimum element is not at the middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
// If middle element is smaller than last element, then the minimum element lies in left half
// Else minimum element lies in right half.


// class Solution {
//     int findKRotation(int arr[], int n) {
//         return countRotations(arr, 0, n - 1);
//     }

//     int countRotations(int arr[], int low, int high) {
//         // This condition is needed to handle
//         // the case when array is not rotated
//         // at all
//         if (high < low) return 0;

//         // If there is only one element left
//         if (high == low) return low;

//         // Find mid
//         // /*(low + high)/2;*/
//         int mid = low + (high - low) / 2;

//         // Check if element (mid+1) is minimum
//         // element. Consider the cases like
//         // {3, 4, 5, 1, 2}
//         if (mid < high && arr[mid + 1] < arr[mid]) return (mid + 1);

//         // Check if mid itself is minimum element
//         if (mid > low && arr[mid] < arr[mid - 1]) return mid;

//         // Decide whether we need to go to left
//         // half or right half
//         if (arr[high] > arr[mid]) return countRotations(arr, low, mid - 1);

//         return countRotations(arr, mid + 1, high);
//     }
// }
