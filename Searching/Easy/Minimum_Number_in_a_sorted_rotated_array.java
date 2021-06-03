/*
Given an array of distinct elements which was initially sorted.
 This array is rotated at some unknown point. 
 The task is to find the minimum element in the given sorted and rotated array. 

Example 1:

Input:
N = 10
arr[] = {2,3,4,5,6,7,8,9,10,1}
Output: 1
Explanation: The array is rotated 
once anti-clockwise. So minium 
element is at last index (n-1) 
which is 1.
Example 2:

Input:
N = 5
arr[] = {3,4,5,1,2}
Output: 1
Explanation: The array is rotated 
and the minimum element present is
at index (n-2) which is 1.
Your Task:
The task is to complete the function minNumber() 
which takes the array arr[] and its starting and ending 
indices (low and high) as inputs and returns the minimum 
element in the given sorted and rotated array.

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(LogN).

Constraints:
1 <= N <= 107
1 <= arr[i] <= 107

Topic Tags
 */

// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class Minimum_Number_in_a_sorted_rotated_array {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(new Solution6().minNumber(arr, 0, n - 1));
        }
    }

}// } Driver Code Ends

class Solution6 {
    // Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int l, int r) {
        if (l == r)
            return arr[l];
        if (arr[l] < arr[r])
            return arr[0];
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            min = Math.min(arr[mid], min);
            if (arr[mid] < arr[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return min;

    }
}

// ==========================================================================
// 
// Pepcoding video link : https://www.youtube.com/watch?v=vF7gk4iaklA
// 
// ==========================================================================



// ======================================================
// 
//   GFG Editorial
// 
// =====================================================


// The minimum element is the only element whose previous element is greater than itself.
//  If there is no previous element greater than current element then
//   there is no rotation (first element is minimum). We check this condition 
// for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.


// Traverse over the array using two pointers and use binary search.
// If array is not rotated or both pointers are same, return the result.
// Check for minimum element at mid and mid+1 and return if found.
// If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
// If middle element is smaller than last element, then the minimum element lies in left half
// Else minimum element lies in right half.


// class Solution
// {
//     //Function to find the minimum element in sorted and rotated array.
//     static int minNumber(int arr[], int low, int high)
//     {
//         //when array is not rotated at all, we return first element.
//         if (high < low)  
//            return arr[0];
           
//         //when both pointers become same, we return element at that pointer.
//         if (high == low) 
//            return arr[(int)low];
           
//         int mid = low + (high - low)/2; 
        
//         //if element at mid+1 is less than element at mid, we return 
//         //element at mid+1 as it is minimum in the array.
//         if (mid < high && arr[mid+1] < arr[mid])
//          return arr[mid+1];
         
//         //if element at mid is less than element at mid-1, we return 
//         //element at mid as it is minimum in the array.
//         if (mid > low && arr[mid] < arr[mid - 1])
//             return arr[mid];
        
//         //if element at high is greater than element at mid, minimum element is
//         //present in left half so calling function recursively for left half.
//         if (arr[high] > arr[mid])
//             return minNumber(arr, low, mid-1);
        
//         //else the minimum element is present in right half so calling
//         //function recursively for right half.
//         return minNumber(arr, mid+1, high);
//     }
    
// }
