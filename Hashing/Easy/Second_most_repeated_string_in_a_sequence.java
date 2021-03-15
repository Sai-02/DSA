/*
 Given a sequence of strings, 
 the task is to find out the second most repeated (or frequent) string 
 in the given sequence.

Note: No two strings are the second most repeated, 
there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.

â€‹Example 2:

Input: 
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function secFrequent()
  which takes the string array arr[] and its size N 
  as inputs and returns the second most frequent string in the array.


Expected Time Complexity: O(N*max(|Si|).
Expected Auxiliary Space: O(N*max(|Si|).


Constraints:
1<=N<=103

 
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Second_most_repeated_string_in_a_sequence {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.next();

            Solution10 ob = new Solution10();

            System.out.println(ob.secFrequent(arr, n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution10 {
    String secFrequent(String arr[], int n) {
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        int maxIndex = -1, secondMax = 0, secondMaxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]);

                count++;
                if (count > max) {
                    max = count;
                    maxIndex = i;
                }
                hm.replace(arr[i], count);
            } else {
                hm.put(arr[i], 1);
                if (1 > max) {
                    max = 1;
                    maxIndex = i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = hm.get(arr[i]);
            if (count > secondMax && count != max) {
                secondMax = count;
                secondMaxIndex = i;
            }
        }
        return arr[secondMaxIndex];
    }
}
// ===========================================
// 
// GFG Editorial
// 
// ==========================================

// Store the frequency of all the strings in a hash map.
//  Check the second highest of all the freuqencies.
//   Then, traverse the hash map and find the string with that frequency 
// (here, we use the fact that there's only one string with second highest frequency).

