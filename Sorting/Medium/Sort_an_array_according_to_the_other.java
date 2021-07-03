/*
Given two integer arrays A1[ ] and A2[ ] of size N and M respectively.
 Sort the first array A1[ ] such that all the relative positions of the 
 elements in the first array are the same as the elements in the second array A2[ ].
See example for better understanding.
Note: If elements are repeated in the second array, consider their first occurance only.

Example 1:

Input:
N = 11 
M = 4
A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
A2[] = {2, 1, 8, 3}
Output: 
2 2 1 1 8 8 3 5 6 7 9
Explanation: Array elements of A1[] are
sorted according to A2[]. So 2 comes first
then 1 comes, then comes 8, then finally 3
comes, now we append remaining elements in
sorted order.
Example 2:

Input:
N = 11 
M = 4
A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
A2[] = {99, 22, 444, 56}
Output: 
1 1 2 2 3 5 6 7 8 8 9
Explanation: No A1[] elements are in A2[]
so we cannot sort A1[] according to A2[].
Hence we sort the elements in non-decreasing 
order.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function sortA1ByA2()
  which takes the array A1[ ], array A2[ ] and their
   respective size N and M as input parameters and 
   returns the sorted array A1[ ] such that the relative
    positions of the elements in A1[ ] are same as the elements in A2[ ]. 
    For the elements not present in A2[ ] but in A1[ ], 
    it appends them at the last in increasing order. 

Expected Time Complexity: O(N * Log(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N, M ≤ 106
1 ≤ A1[i], A2[i] ≤ 106

Company Tags
Topic Tags

*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// } Driver Code Ends
//User function Template for Java

class Solution11 {
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]

    // Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int a1[], int n, int a2[], int m) {
        int ans[] = new int[n];
        int index = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(a1[i])) {
                hm.replace(a1[i], hm.get(a1[i]) + 1);

            } else {
                hm.put(a1[i], 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (hm.containsKey(a2[i])) {
                int count = hm.get(a2[i]);
                while (count-- > 0) {
                    ans[index++] = a2[i];
                }
                hm.remove(a2[i]);
            }
        }
        Arrays.sort(a1);
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(a1[i])) {
                ans[index++] = a1[i];
            }
        }
        return ans;

    }
}

// { Driver Code Starts.
public class Sort_an_array_according_to_the_other {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a1[] = new int[n];
            int a2[] = new int[m];

            for (int i = 0; i < n; i++)
                a1[i] = sc.nextInt();

            for (int i = 0; i < m; i++)
                a2[i] = sc.nextInt();
            Solution11 ob = new Solution11();
            a1 = ob.sortA1ByA2(a1, n, a2, m);
            for (int x : a1)
                System.out.print(x + " ");

            System.out.println();
        }
    }

}

// } Driver Code Ends