/*
Given an array Arr of size N such that each element is from the range 0 to 9.
 Find the minimum possible sum of two numbers formed using the elements of the array.
  All digits in the given array must be used to form the two numbers.


Example 1:

Input:
N = 6
Arr[] = {6, 8, 4, 5, 2, 3}
Output: 604
Explanation: The minimum sum is formed 
by numbers 358 and 246.

Example 2:

Input:
N = 5
Arr[] = {5, 3, 0, 7, 4}
Output: 82
Explanation: The minimum sum is 
formed by numbers 35 and 047.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function solve() which takes 
arr[] and n as input parameters and returns the minimum possible sum.
 As the number can be large, return string presentation of the number
  without leading zeroes.
 

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 107
0 ≤ Arri ≤ 9
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Minimum_sum {

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

            String ans = new Solution4().solve(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution4 {
    String solve(int[] arr, int n) {
        if (n == 0)
            return "";
        if (n == 1)
            return "" + arr[0];
        Arrays.sort(arr);
        String ans1 = "";
        String ans2 = "";

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                ans1 += arr[i];
            } else {
                ans2 += arr[i];
            }

        }
        String ans = "";
        int l1 = ans1.length();
        int l2 = ans2.length();
        while (l1 > l2) {
            ans2 = "0" + ans2;
            l2++;
        }
        while (l1 < l2) {
            ans1 = "0" + ans1;
            l1++;
        }
        int carry = 0;
        for (int i = l1 - 1; i >= 0; i--) {
            int num1 = Integer.parseInt("" + ans1.charAt(i));
            int num2 = Integer.parseInt("" + ans2.charAt(i));
            int val = (num1 + num2 + carry);
            if (val > 0 || carry > 0) {

                carry = val / 10;
                ans = (val % 10) + ans;
            }
        }
        if (carry > 0) {
            ans = carry + ans;
        }

        return ans;
    }
}
