/*
Given an array Arr of size N with all elements greater than or equal to zero. 
Return the maximum product of two numbers possible.

Example 1:

Input: 
N = 6
Arr[] = {1, 4, 3, 6, 7, 0}  
Output: 42
Example 2:

Input: 
N = 5
Arr = {1, 100, 42, 4, 23}
Output: 4200
Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function maxProduct()
  which takes the array of integers arr[] and n as parameters and
   returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 107
0 ≤ Arr[i] ≤ 104

 
 */
// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

public class Maximum_product_of_two_numbers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution3().maxProduct(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution3 {
    int maxProduct(int arr[], int n) {
        int max1 = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max1) {
                max1 = arr[i];
                maxIndex = i;
            }
        }
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i != maxIndex) {
                max2 = Math.max(max2, arr[i]);
            }
        }
        return max1 * max2;
    }
}
