/*
Given an array of distinct integers.
 The task is to count all the triplets such that sum of two elements equals
  the third element.
 
Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets: 
1 + 2 = 3 and 3 +2 = 5 
â€‹Example 2:

Input: 
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits
Your Task:  
You don't need to read input or print anything. 
Your task is to complete the function countTriplet() 
which takes the array arr[] and N as inputs and returns the triplet count

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105

Company Tags
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Count_the_triplets {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution3 ob = new Solution3();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution3 {
    int countTriplet(int arr[], int n) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                int sum = arr[j] + arr[k];
                if (sum == arr[i]) {
                    count++;
                    j++;
                    k--;
                } else if (sum < arr[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}

// ==========================================================
// 
//  GFG Editorial
// 
// ==========================================================

// 1. Sort the given array, 
// then the problem reduces to find the triplet where two numbers giving sum X.


// 2. Try two pointer algorithm
//     Step1: Maintain two pointer one starting from 0 and other one from n-2.
//     Step2: Check if sum of two such elements equal to the (n-1)th element of array if so then increase count and increment one pointer ahead by 1 and decerement other pointer by 1.
//     Step3: If sum is less, then move starting pointer ahead only
//     Step4: if sum is more, then decrement end pointer by 1 only.



