/*
Given an integer array of N elements. You need to find the maximum sum 
of two elements such that sum is closest to zero.

Example 1:

Input:
N = 3
arr[] = {-8 -66 -60}
Output: -68
Explanation: Sum of two elements closest to 
zero is -68 using numbers -60 and -8.
â€‹Example 2:

Input: 
N = 6
arr[] = {-21 -67 -37 -18 4 -65}
Output: -14
Explanation: Sum of two elements closest to
zero is -14 using numbers -18 and 4.

Your Task:
You don't need to read input or print anything.
 You just need to complete the function closestToZero()
  which takes an array arr[] and its size n as inputs and
   returns the maximum sum closest to zero that can be formed
    by summing any two elements in the array.


Expected Time Complexity: O(N*logN).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ N ≤ 5 * 105
-106 ≤ arr[i] ≤ 106

Company Tags
*/
// { Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Two_numbers_with_sum_closest_to_zero {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            System.out.println(new Sol().closestToZero(arr, n));
        }

    }
}
// } Driver Code Ends

// User function Template for Java

class Sol {
    public static int closestToZero(int arr[], int n) {
        Arrays.sort(arr);
        int minSum = Integer.MAX_VALUE;
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (Math.abs(minSum) > Math.abs(sum)) {
                minSum = sum;
            } else if (Math.abs(minSum) == Math.abs(sum)) {
                if (sum > minSum) {
                    minSum = sum;
                }
            }
            if (sum > 0) {
                j--;
            } else {
                i++;
            }

        }
        return minSum;

    }
}