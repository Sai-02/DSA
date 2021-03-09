/*
Given an array of N positive integers where all numbers occur even number 
of times except one number which occurs odd number of times. 
Find the exceptional number.

Example 1:

Input:
N = 7
Arr[] = {1, 2, 3, 2, 3, 1, 3}
Output: 3

Example 2:

Input:
N = 7
Arr[] = {5, 7, 2, 7, 5, 2, 5}
Output: 5

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function getOddOccurrence() 
 which takes arr[] and n as input parameters and returns the exceptional number.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 106
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Exceptionally_odd {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution6().getOddOccurrence(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution6 {
    int getOddOccurrence(int[] a, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(a[i])) {
                hm.replace(a[i], hm.get(a[i]) + 1);
            } else {
                hm.put(a[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            int freq = hm.get(a[i]);
            if (freq % 2 == 1) {
                return a[i];
            }
        }
        return -1;
    }
}


// =====================================
// 
// GFG Editorial
// 
// =====================================


// Hashing can be used to solve the problem in O(N).
// Can you think of a better way to optimise the space complexity ?

// Most optimal solution uses bitwise XOR.
// XOR of all elements gives us the odd occurring element.

// //Back-end complete function template for C++

// class Solution{   
//     public:
//         int getOddOccurrence(int arr[], int n) {
//             int res = 0;
//             for (int i = 0; i < n; i++) 
//                 res = res ^ arr[i];
//             return res;
//         }
//     };
          
    