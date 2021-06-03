/*
A peak element in an array is the one that is not smaller than its neighbours.
Given an array arr[] of size N, find the index of any one of its peak elements.
Note: The generated output will always be 1 if the index that you return is correct.
 Otherwise output will be 0. 


Example 1:

Input:
N = 3
arr[] = {1,2,3}
Output: 2
Explanation: index 2 is 3.
It is the peak element as it is 
greater than its neighbour 2.
Example 2:

Input:
N = 2
arr[] = {3,4}
Output: 1
Explanation: 4 (at index 1) is the 
peak element as it is greater than 
its only neighbour element 3.
 

Your Task:
You don't have to read input or print anything.
 Complete the function peakElement() which takes the array arr[] 
 and its size N as input parameters and return the index of any 
 one of its peak elements.

 

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[] ≤ 106

Company Tags
Topic Tags
 */

// { Driver Code Starts
import java.util.*;

public class Peak_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                tmp[i] = a[i];
            }

            int f = 0;
            int A = (new Solution4()).peakElement(tmp, n);

            if (A < 0 && A >= n)
                System.out.println(0);
            else {
                if (n == 1 && A == 0)
                    f = 1;
                else if (A == 0 && a[0] >= a[1])
                    f = 1;
                else if (A == n - 1 && a[n - 1] >= a[n - 2])
                    f = 1;
                else if (A >= 0 && A < n && a[A] >= a[A + 1] && a[A] >= a[A - 1])
                    f = 1;
                else
                    f = 0;
                System.out.println(f);
            }
        }
    }
}// } Driver Code Ends

/* Complete the function below */

class Solution4 {
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr, int n) {
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            boolean left = false, right = false;
            ;
            if (mid > 0) {
                if (arr[mid] >= arr[mid - 1]) {
                    left = true;
                }

            } else
                left = true;

            if (mid < n - 1) {
                if (arr[mid] >= arr[mid + 1]) {
                    right = true;
                }
            } else
                right = true;

            if (left && right) {
                return mid;
            } else if (!left) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

// ===========================================================
//
// GFG Editorial
//
// ==========================================================

// The complete solution:

// The peak element, is the element that is not smaller than its neighbours.
// Checking at an element, if it is smaller than its right neighbour, then a
// peak element exists at its right.
// If it is smaller than its left neighbour, then a peak element exists at its
// left side. (Why ?)
// Do Binary search, with above conditions. Also check at the mid element, if it
// is not smaller than its neighbours.
// Also, consider for corner cases, i.e for index position 0 and n-1, and modify
// the code accordingly.

// class Solution{

// public int peakElement(int[] arr,int n){
// return peakElementUtil(arr,0,n-1,n);
// }

// // recursive binary search to find the peak element
// public static int peakElementUtil(int[] arr,int low,int high,int n){

// // calculating mid
// int mid=(low+high)>>1;

// // if mid is last or first index with first element
// // greater than next.
// // Also, check if mid element is greater than mid - 1 and mid+1
// if ((mid == 0 || arr[mid-1] <= arr[mid]) &&(mid == n-1 || arr[mid+1] <=
// arr[mid]))
// return mid;

// // If mid is other than 0, then check if mid element is less than prev.
// // If so, then recurse for lower half
// else if(mid>0&&arr[mid-1]>arr[mid])
// return peakElementUtil(arr,low,mid-1,n);

// // else recurse for the upper half
// else
// return peakElementUtil(arr,mid+1,high,n);
// }
// }
