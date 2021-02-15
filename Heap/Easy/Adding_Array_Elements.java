/*

Given an array Arr[] of size N and an integer K, 
you have to add the first two minimum elements of the array
 until all the elements are greater than or equal to K and 
 find the number of such operations required.

Example 1:

Input:
N = 6, K = 6 
Arr[] = {1, 10, 12, 9, 2, 3}
Output: 2
Explanation: First we add (1 + 2), now the new list 
becomes 3 10 12 9 3, then we add (3 + 3), now the 
new list becomes 6 10 12 9, Now all the elements 
in the list are greater than 6. Hence the output 
is 2 i:e 2 operations are required to do this. 
Example 2:

Input:
N = 4, K = 4
Arr[] = {5, 4, 6, 4}
Output: 0
Explanation: Every element in the given array 
is greater than or equal to K.
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function minOperations() 
which takes array of integers arr, n and k as parameters 
and returns an integer denoting the answer.
 If it is not possible to make elements greater than or equal to K, return -1.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints :
1 ≤ N, K ≤ 105
1 ≤ Arr[i] ≤ 106
 */


// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Adding_Array_Elements {

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

            int ans = new Solve().minOperations(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solve {
    int minOperations(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        int count = 0;
        while (pq.peek() < k) {
            int k1 = pq.remove();
            int k2 = pq.remove();
            pq.add(k1 + k2);
            count++;
        }
        return count;

    }
}
// ======================================
// 
// GFG Editorial
// 
// =====================================


// We can create a simple array the sort it and then add two minimum elements
//  and keep on storing them
//  back in the array until all the elements become greater than K.


//  If we take a closer look, we can notice that this problem is similar to Huffman coding.
//   We use Min Heap as the main operations here are extract min and insert.
//   Both of these operations can be done in O(Log n) time.


