/*
Given an array A of positive integers.
 Your task is to sort them in such a way that the first part of the array 
 contains odd numbers sorted in descending order,
  rest portion contains even numbers sorted in ascending order.

 

Example 1:

Input:
N = 7
Arr = {1, 2, 3, 5, 4, 7, 10}
Output:
7 5 3 1 2 4 10
Explanation:
Array elements 7 5 3 1 are odd
and sorted in descending order,
whereas 2 4 10 are even numbers
and sorted in ascending order.
 

Example 2:

Input:
N = 7
Arr = {0, 4, 5, 3, 7, 2, 1}
Output:
7 5 3 1 0 2 4
 

Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function leftIndex() 
 which takes the array Arr[] and its size N as inputs and modifies the array Arr[].


Expected Time Complexity: O(N. Log(N))
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 106
0 <= Ai <= 1018

Company Tags
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Sort_in_specific_order {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int) (n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution2 ob = new Solution2();
            ob.sortIt(a, n);
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++)
                output.append(a[i] + " ");
            System.out.println(output);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution2 {

    public void sortIt(long a[], long n) {
        long ans[] = getMergeSort(a, 0, (int) n - 1);
        ArrayList<Long> odd = new ArrayList<>();
        ArrayList<Long> even = new ArrayList<>();
        for (int i = 0; i < (int) n; i++) {
            if (ans[i] % 2 == 0) {
                even.add(ans[i]);
            } else {
                odd.add(ans[i]);

            }
        }
        int k = 0;
        for (int i = odd.size() - 1; i >= 0; i--) {
            a[k++] = odd.get(i);
        }
        for (int i = 0; i < even.size(); i++) {
            a[k++] = even.get(i);
        }

    }

    public static long[] getMergeSort(long a[], int l, int h) {
        if (l == h) {
            long ans[] = new long[1];
            ans[0] = a[l];
            return ans;
        }
        int mid = (l + h) / 2;
        long lsa[] = getMergeSort(a, l, mid);
        long rsa[] = getMergeSort(a, mid + 1, h);
        long ans[] = merge(lsa, rsa);
        return ans;

    }

    public static long[] merge(long a[], long b[]) {
        int n = a.length;
        int m = b.length;
        long ans[] = new long[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ans[k++] = a[i++];
            } else {
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