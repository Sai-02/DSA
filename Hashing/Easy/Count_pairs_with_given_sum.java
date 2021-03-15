/*
Given an array of N integers, and an integer K, 
find the number of pairs of elements in the array whose sum is equal to K.


Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.

Example 2:

Input:
N = 4, X = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function getPairsCount()
  which takes arr[], n and k as input parameters and 
  returns the number of pairs that have sum K.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
1 <= K <= 108
1 <= Arr[i] <= 106
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Count_pairs_with_given_sum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution8().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution8 {
    int getPairsCount(int[] arr, int n, int k) {
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
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(k - arr[i])) {
                if (k - arr[i] == arr[i]) {
                    ans--;
                }
                ans = ans + hm.get(k - arr[i]);

            }
        }

        return ans / 2;
    }
}


// =============================
// 
// GFG Editorial
// 
// =============================

// Use a hash map to solve the question in O(n) time. 

// Create a map to store frequency of each number in the array.
//  (Single traversal is required)
// For every element check if it can be combined with any other element
//  (other than itself!) to give the desired sum. Increment the counter accordingly. 
//  After completion of second traversal, we’d have twice the required value
//   stored in counter because every pair is counted two times. 
// Also take care of pairs with duplicate elements like (2,2) when K =4.


