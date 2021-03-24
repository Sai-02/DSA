/*
Given an array of integers and a number k,
 write a function that returns true if given array 
 can be divided into pairs such that sum of every pair is divisible by k.
 

Example 1 :

Input : arr = [9, 5, 7, 3], k = 6
Output: True
Explanation: {(9, 3), (5, 7)} is a 
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.

Example 2:

Input : arr = [2, 4, 1, 3], k = 4
Output: False
Explanation: There is no possible solution.
 

Your Task:
You don't need to read or print anything. 
Your task is to complete the function canPair()
 which takes array and k as input parameter and
  returns true if array can be divided into pair
  s such that sum of every pair is divisible by k otherwise returns false.
 

Expected Time Complexity: O(n)
Expected Space Complexity : O(n)
 

Constraints:
1 <= length of array <= 100000
1 <= elements of array <= 100000
 */

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Array_Pair_Sum_Divisibility_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution16 ob = new Solution16();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution16 {
    public boolean canPair(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % k;
            int x = nums[i];
            if (hm.containsKey(x)) {
                hm.replace(x, hm.get(x) + 1);

            } else {
                hm.put(x, 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == 0) {
                if (hm.get(x) % 2 != 0) {
                    return false;
                }
            } else if (hm.containsKey(k - x) && hm.get(x) == hm.get(k - x)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

// ===============================================
//
// GFG Editorial
//
// ===============================================

// class Solution {
//     public boolean canPair(int ar[], int k) {
//         // An odd length array cannot be divided into pairs
//         if (ar.length % 2 == 1)
//             return false;

//         // Create a frequency array to count occurrences
//         // of all remainders when divided by k.
//         HashMap<Integer, Integer> hm = new HashMap<>();

//         // Count occurrences of all remainders
//         for (int i = 0; i < ar.length; i++) {
//             int rem = ((ar[i] % k) + k) % k;
//             if (!hm.containsKey(rem)) {
//                 hm.put(rem, 0);
//             }
//             hm.put(rem, hm.get(rem) + 1);
//         }

//         // Traverse input array and use freq[] to decide
//         // if given array can be divided in pairs
//         for (int i = 0; i < ar.length; i++) {
//             // Remainder of current element
//             int rem = ((ar[i] % k) + k) % k;

//             // If remainder with current element divides
//             // k into two halves.
//             if (2 * rem == k) {
//                 // Then there must be even occurrences of
//                 // such remainder
//                 if (hm.get(rem) % 2 == 1)
//                     return false;
//             }

//             // If remainder is 0, then there must be two
//             // elements with 0 remainder
//             else if (rem == 0) {
//                 // Then there must be even occurrences of
//                 // such remainder
//                 if (hm.get(rem) % 2 == 1)
//                     return false;
//             }

//             // Else number of occurrences of remainder
//             // must be equal to number of occurrences of
//             // k - remainder
//             else {
//                 if (hm.get(k - rem) != hm.get(rem))
//                     return false;
//             }
//         }
//         return true;
//     }
// }