/*
Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far
 (or close) the array is from being sorted. If array is already 
 sorted then the inversion count is 0. If an array is sorted in 
 the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function inversionCount()
  which takes the array arr[] and the size of the array
   as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ arr[i] ≤ 1018

Company Tags
Topic Tags
Related Courses

*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

public class Count_Inversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(new Solution9().inversionCount(arr, n));

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution9 {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long count = 0;

    static long inversionCount(long arr[], long n) {
        count = 0;
        getMergeSort(arr, 0, (int) n - 1);
        return count;
    }

    static long[] getMergeSort(long a[], int l, int r) {
        if (l == r) {
            long ans[] = new long[1];
            ans[0] = a[l];
            return ans;
        }
        int mid = (l + r) / 2;
        long lsa[] = getMergeSort(a, l, mid);
        long rsa[] = getMergeSort(a, mid + 1, r);
        long ans[] = merge(lsa, rsa);
        return ans;
    }

    static long[] merge(long a[], long b[]) {
        int n = a.length, m = b.length;
        int i = 0, j = 0, k = 0;
        long ans[] = new long[m + n];
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                ans[k++] = a[i++];
            } else {
                count += (long) (n - i);
                ans[k++] = b[j++];

            }
        }
        while (i < n) {
            ans[k++] = a[i++];

        }
        while (j < m) {
            ans[k++] = b[j++];
        }
        return ans;
    }
}

// ========================================================================================
//
// Pepcoding Video Link:
// https://www.youtube.com/watch?v=uojx--MK_n0&ab_channel=Pepcoding
//
// ========================================================================================

// ======================================================
//
// GFG Editorial
//
// ======================================================

// Use Merge sort algorithm, and sort the array.
// In merge function for merge sort, while comparing the elements, if element in
// right array is smaller, then it is an inversion (Why..??)
// This means that this smaller element in the original array, is behind larger
// elements. So add the number of larger elements or elements left in the
// left-array, to the value of counter.
// This process is repeated again and again for complete Merge Sort
// Finally output counter variable. This is the answer.

// class Solution
// {
//     //Function to count inversions in the array.
//     static long inversionCount(long arr[], long n)
//     {
//         long temp[] = new long[(int)n];
//         //returning the count of inversions in the array.
//         return _mergeSort(arr, temp, 0, n - 1); 
//     }
    
//     //Function to mergesort the array, which uses divide and conquer algorithm
//     //on left and right halves of array for mergesort operation.
//     static long _mergeSort(long arr[], long temp[], 
//         long left, long right)
//     {
//         long mid, inv_count = 0; 
//         if (right > left) { 
//             mid = (right + left) / 2;
            
//             //Calling recursive function to sort left half of the array.
//             inv_count = _mergeSort(arr, temp, left, mid);
            
//             //Calling recursive function to sort right half of the array.
//             inv_count += _mergeSort(arr, temp, mid + 1, right);
            
//             //Calling merge function which sorts and merges both halves
//             //of the array obtained after calling both recursive function.
//             inv_count += merge(arr, temp, left, mid + 1, right); 
//         } 
//         //returning the count of inversions in the array.
//         return inv_count; 
//     }
    
//     //Function to sort and merge two parts of array and return inversion count. 
//     static long merge(long arr[], long temp[], long left,
//     long mid, long right) 
//     { 
//         long i, j, k; 
//         long inv_count = 0; 
//         //i is pointer for left subarray.
//         i = left;
//         //j is pointer for right subarray.
//         j = mid; 
//         //k is index for resultant merged subarray.
//         k = left; 
        
//         //Using two pointers over the array which helps in storing the
//         //smaller element and thus merging the subarray.
//         while ((i <= mid - 1) && (j <= right)) {
            
//             //Comparing element of the array at pointers i and j and accordingly
//             //storing the smaller element and updating the pointers.
//             if (arr[(int)i] <= arr[(int)j]) { 
//                 temp[(int)k++] = arr[(int)i++]; 
//             } 
//             else { 
//                 temp[(int)k++] = arr[(int)j++]; 
//                 //Adding the inversions which is the number of elements which 
//                 //are smaller than arr[j] in the left half of the array.
//                 inv_count = inv_count + (mid - i); 
//             } 
//         } 
  
//         //Copying the remaining elements of left subarray(if there are any) 
//         //to temp.
//         while (i <= mid - 1)  
//             temp[(int)k++] = arr[(int)i++]; 
  
//         //Copying the remaining elements of right subarray(if there are any)
//         //to temp.
//         while (j <= right) 
//             temp[(int)k++] = arr[(int)j++]; 
  
//         //Copying back the merged elements to original array.
//         for (i = left; i <= right; i++) 
//             arr[(int)i] = temp[(int)i]; 
  
//         return inv_count; 
//     }
    
// }
