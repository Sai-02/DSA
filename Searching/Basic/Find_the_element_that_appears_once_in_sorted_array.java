/*
Given a sorted array arr[] of size N. 
Find the element that appears only once in the array.
 All other elements appear exactly twice. 

Example 1:

Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that 
appears exactly once.
 

Your Task:  
You don't need to read input or print anything.
 Complete the function findOnce() which takes sorted array and its 
 size as its input parameter and returns the element that appears only once. 


Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

 

Constraints:
-105 <= N <= 105

Company Tags
Topic Tags
*/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class Find_the_element_that_appears_once_in_sorted_array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Solution2 sol = new Solution2();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution2 {
    int findOnce(int a[], int n) {
        if (n == 1)
            return a[0];
        int l = 0, r = n - 2;
        while (l <= r) {

            int mid = (l + r) / 2;

            if (mid % 2 == 0) {
                if (a[mid] == a[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            } else {
                if (a[mid] == a[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            }

        }
        return a[l];

    }
}

// ================================
// 
// GFG Editorial
// 
// ================================

//Back-end complete function Template for Java

// class Solution
// {
//     int findOnce(int arr[], int n)
//     {
//         int low = 0, high = n - 1;
//         while (low < high) 
//         {
//             // Find the middle point
//             int mid = (low + high) / 2;
        
//             // If mid is even and element next to mid is
//             // same as mid, then output element lies on
//             // right side, else on left side
//             if (mid%2 == 0)
//             {
//                 if (arr[mid] == arr[mid+1])
//                     low = mid + 2;
//                 else
//                     high = mid;
//             }
//             else  // If mid is odd
//             {
//                 if (arr[mid] == arr[mid-1])
//                     low = mid + 1;
//                 else
//                     high = mid - 1;
//             }
//         }
//         return arr[low];
//     }
// }
