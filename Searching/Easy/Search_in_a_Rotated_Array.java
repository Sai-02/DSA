/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point,
 and given an element key. The task is to find the index of the given element key
  in the array A.

Example 1:

Input:
N = 9
A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
key = 10
Output:
5
Explanation: 10 is found at index 5.
Example 2:

Input:
N = 4
A[] = {3, 5, 1, 2}
key = 6
Output:
-1
Explanation: There is no element that has value 6.
Your Task:
Complete the function search() which takes an array arr[] and start, 
end index of the array and the K as input parameters, and returns the answer.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 108
1 ≤ key ≤ 108

 
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class Search_in_a_Rotated_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int A[] = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();

            System.out.println(new Solution8().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution8 {
    int search(int a[], int l, int r, int key) {

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            boolean sorted = false;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] > a[l]) {
                if (a[l] <= key && key <= a[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                if (a[mid] <= key && key <= a[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            }
        }

        return -1;
    }
}

// ===============================================================================
// 
// Pepcoding video link :  https://www.youtube.com/watch?v=1uu3g_uu8O0&t=703s
// 
// ===============================================================================


// ====================================================
// 
// GFG Editorial
// 
// ===================================================

// 1. The idea is to find the pivot point, divide the array in two sub-arrays and
//  call binary search.
// The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array, 
// pivot element is the only element for which next element to it is smaller than it.


// 1) Find middle point mid = (l + h)/2
// 2) If key is present at middle point, return mid.
// 3) Else If arr[l..mid] is sorted
//     a) If key to be searched lies in range from arr[l]
//        to arr[mid], recur for arr[l..mid].
//     b) Else recur for arr[mid+1..r]
// 4) Else (arr[mid+1..r] must be sorted)
//     a) If key to be searched lies in range from arr[mid+1]
//        to arr[r], recur for arr[mid+1..r].
//     b) Else recur for arr[l..mid] 



// class Solution
// {
//     int search(int A[], int l, int h, int key)
//     {
//         if (l > h) 
//         {
//             return -1;
//         }
        
//         int mid = (l+h)/2; 
//         if (A[mid] == key)
//         {
//             return mid; 
//         }
    
//         if (A[l] <= A[mid])
//         { 
//             if (key >= A[l] && key <= A[mid]) 
//                 return search(A, l, mid-1, key); 
//             return search(A, mid+1, h, key); 
//         } 
        
//         if (key >= A[mid] && key <= A[h]) 
//             return search(A, mid+1, h, key); 
//         return search(A, l, mid-1, key); 
//     }
// }
