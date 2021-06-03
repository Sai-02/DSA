/*
Given a sorted and rotated array A of N distinct elements which is rotated at some point,
 and given an element K. The task is to find the index of the given element K
  in the array A.

Example 1:

Input:
N = 9
A[] = {5 6,7,8,9,10,1,2,3}
K = 10
Output: 5
Explanation: 10 is found at index 5.
Example 1:

Input:
N = 3
A[] = {3,1,2}
K = 1
Output: 1
User Task:
Complete Search() function and return the index of the element K if found in the array.
 If the element is not present, then return -1.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
0 ≤ Ai ≤ 108
1 ≤ K ≤ 108

Company Tags
Topic Tags
 Divide and Conquer Searching
Related Interview Experiences
 Hike interview experience set 5
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Search_an_element_in_sorted_and_rotated_array {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            Solution7 ob = new Solution7();
            System.out.println(ob.Search(array, target));
            t--;
        }
    }
} // } Driver Code Ends

// User function Template for Java

class Solution7 {
    static int Search(int arr[], int target) {
        int l = 0, r = arr.length - 1;
        if (l == r)
            return arr[0] == target ? 0 : -1;
        if (arr[l] < arr[r])
            return binarySearch(arr, l, r, target);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (min > arr[mid]) {
                min = arr[mid];
                minIndex = mid;
            }
            if (arr[mid] < arr[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return Math.max(binarySearch(arr, 0, minIndex, target), binarySearch(arr, minIndex, arr.length - 1, target));

    }

    static int binarySearch(int a[], int l, int r, int key) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                return binarySearch(a, l, mid - 1, key);
            } else {
                return binarySearch(a, mid + 1, r, key);
            }
        }
        return -1;
    }
}

// ==================================================================
// 
// GFG Editorial
// 
// ==================================================================

// 1. The idea is to find the pivot point, divide the array in two sub-arrays and call binary search.
// The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array,
//  pivot element is the only element for which next element to it is smaller than it.



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
//     static int Search(int array[], int target)
// 	{    
// 	    int n = array.length;
// 	    int low = 0, high = n-1, ans = -1;
// 	    while(low <= high){
// 	        int mid = (low+high)/2;
// 	        if(target == array[mid]){
// 	            ans = mid;
// 	            break;
// 	        }

// 	        if(array[low] <= array[mid]){
// 	            if(array[low] <= target && target <= array[mid]){
// 	                high = mid-1;
// 	            }
// 	            else{
// 	                low = mid+1;
// 	            }
// 	        }
// 	        else{
// 	            if(array[mid] < array[high]){
// 	                if(array[mid] <= target && target <= array[high]){
// 	                    low = mid+1;
// 	                }
// 	                else{
// 	                    high = mid-1;
// 	                }
// 	            }
// 	        }
// 	    }
// 	    return ans;
// 	}
// } 

