/*
Given a sorted array A[] of N positive integers having all the numbers occurring 
exactly twice, except for one number which will occur only once
. Find the number occurring only once.

Example 1:

Input:
N = 5
A = {1, 1, 2, 5, 5}
Output: 2
Explanation: 
Since 2 occurs once, while
other numbers occur twice, 
2 is the answer.
Example 2:

Input:
N = 7
A = {2, 2, 5, 5, 20, 30, 30}
Output: 20
Explanation:
Since 20 occurs once, while
other numbers occur twice, 
20 is the answer.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function search() 
 which takes two arguments(array A and integer N) and 
 returns the number occurring only once.

Expected Time Complexity: O(Log(N)).
Expected Auxiliary Space: O(1).

Constraints
0 <   N  <= 10^6
0 <= A[i] <= 10^9

Company Tags
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Find_the_element_that_appears_once {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            System.out.println(new Sol3().search(arr, n));
        }

    }
}// } Driver Code Ends

// User function Template for Java

class Sol3 {
    public static int search(int a[], int n) {
        int l = 0, r = n - 2;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
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

// ==========================================================
// 
//  GFG Editorial
// 
// ==========================================================

//Back-end complete function Template for Java

// class Sol
// {
//     public static int bs(int arr[], int low, int high)
//     {
//         if (low==high)
//         {
//             return arr[low];
//         }
    
//         // Find the middle point
//         int mid = (low + high) / 2;
    
//         // If mid is even and element next to mid is
//         // same as mid, then output element lies on
//         // right side, else on left side
//         if (mid%2 == 0)
//         {
//             if (arr[mid] == arr[mid+1])
//                 return bs(arr, mid+2, high);
//             else
//                 return bs(arr, low, mid);
//         }
//         else  // If mid is odd
//         {
//             if (arr[mid] == arr[mid-1])
//                 return bs(arr, mid+1, high);
//             else
//                 return bs(arr, low, mid-1);
//         }
//     }
//     public static int search(int arr[], int n){
//         return bs(arr,0,n-1);
//     }
// }

