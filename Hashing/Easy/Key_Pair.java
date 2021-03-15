/*
Given an array Arr of N positive integers and another number X.
 Determine whether or not there exist two elements in Arr whose sum is exactly X.

Example 1:

Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
Example 2:

Input:
N = 5, X = 10
Arr[] = {1, 2, 4, 3, 6}
Output: Yes
Explanation: Arr[2] + Arr[4] = 4 + 6 = 10
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function hasArrayTwoCandidates()
  which takes the array of integers arr, n and x as parameters
   and returns boolean denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 105
 */

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

public class Key_Pair {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution9().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution9 {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]);
                count++;
                hm.replace(arr[i], count);

            } else {
                hm.put(arr[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(x - arr[i])) {
                if (arr[i] == x - arr[i]) {
                    if (hm.get(arr[i]) > 1) {
                        return true;
                    }
                } else {

                    return true;
                }
            }
        }

        return false;
    }
}


// =========================================
// 
// GFG Editorial
// 
// ========================================


// A brute force approach would be solve it using 2 nested for-loops which calculates
//  the sum of all the possible pairs of elements. 
// If any such pair sum comes out to be equal to the required sum,
//  we print Yes, else No.

// Here's the algorithm for the same:
// for i in (1,n):
//    for j in (i+1,n):
//       if (arr[i] + arr[j] == sum) return "Yes"

// return "No"

// But, since this approach uses 2 nested loops, the time complexity for this is O(n^2).
//  That's not very efficient.
// Can you make it better? How about Sorting?


// Algorithm:

// hasArrayTwoCandidates (A[], ar_size, sum)
// Sort the array in non-decreasing order.
// Initialize two index variables to find the candidate
// elements in the sorted array.
// Initialize first to the leftmost index: l = 0
// Initialize second the rightmost index: r = ar_size-1
// Loop while l < r.
// If (A[l] + A[r] == sum) then return 1
// Else if( A[l] + A[r] < sum ) then l++
// Else r–
// No candidates in whole array – return 0

// class Solution{
// 	// Function to check if array has 2 elements
// 	// whose sum is equal to the given value
// 	boolean hasArrayTwoCandidates(int arr[], int n, int x) {
//         HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
//     	for (int i = 0; i < n; i++) {
//     		int numberToFind = x - arr[i];
//                 //if numberToFind is found in map, return them
//     		if (hash.containsKey(numberToFind)) {
//     		    return true;
//     		}
//                 //number was not found. Put it in the map.
//     		hash.put(arr[i],i);
//     	}
//     	return false;
// 	}
// };



