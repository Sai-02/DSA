/*
Given a Binary Heap of size N in an array arr[]. 
Write a program to calculate the height of the Heap.

Example 1:

Input: N = 6
arr = {1, 3, 6, 5, 9, 8}
Output: 2
Explaination: The tree is like the following
           (1)
       /   \
    (3)    (6)
    / \     /
  (5) (9) (8)
Example 2:

Input: N = 9
arr = {3, 6, 9, 2, 15, 10, 14, 5, 12}
Output: 3
Explaination: The tree looks like following
               (2)
        /      \
      (3)      (9)
     /  \     /   \
   (5) (15) (10) (14)
   / \
 (6) (12)
Your Task:
You do not need to read input or print anything. 
Your task is to complete the function heapHeight()
 which takes the value N and the array arr as inpu
 t parameters and returns the height of the heap.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
1 ≤ arr[i] ≤ 106
 */
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.heapHeight(N, arr));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution {
    static int heapHeight(int N, int arr[]) {
        return (int) Math.ceil(Math.log(N + 1) / Math.log(2)) - 1;
    }
}



// =====================================
// 
//  GFG Editorial
// 
// ====================================

// Consider a Binary Heap of size N. We need to find height of it.

// Examples :

// Input : N = 6
// Output : 2
//         ()
//       /    \
//      ()     ()
//     /  \    /
//   ()    () ()

// Input : N = 9
// Output :
//         ()
//       /    \
//      ()     ()
//     /  \    /  \
//   ()    () ()   ()
//  / \
// ()  ()
// Recommended: Please try your approach on {IDE} first, before moving on to the solution.
// Let the size of heap be N and height be h
// If we take few examples, we can notice that the value of h in a complete binary tree is ceil(log2(N+1)) – 1.
// Examples :

//  N    h
// ---------
//  1    0
//  2    1
//  3    1
//  4    2
//  5    2
//  .....
//  .....

