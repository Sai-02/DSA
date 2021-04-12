/*

Given a string you need to print the size of the longest possible
 substring that has exactly K unique characters. If there is no 
 possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest 
substring with K distinct characters.
â€‹Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: There's no substring with K
distinct characters.

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function longestKSubstr() 
 which takes the string S and an integer K as input and
  returns the length of the longest substring with exactly
   K distinct characters. If there is no substring with exactly
    K distinct characters then return -1.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105
1<=K<=105
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Longest_K_unique_characters_substring {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution18 obj = new Solution18();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution18 {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = -1, j = -1;
        int ans = -1;
        int n = s.length();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < n - 1) {
                f1 = true;
                i++;
                char c = s.charAt(i);
                if (hm.containsKey(c)) {
                    hm.replace(c, hm.get(c) + 1);
                } else {
                    hm.put(c, 1);
                }
                if (hm.size() == k) {
                    int length = i - j;
                    ans = Math.max(ans, length);

                } else if (hm.size() > k) {
                    break;
                }

            }
            while (j < i) {
                f2 = true;
                j++;
                char c = s.charAt(j);
                if (hm.get(c) == 1) {
                    hm.remove(c);
                } else {
                    hm.replace(c, hm.get(c) - 1);
                }
                if (hm.size() == k) {
                    int length = i - j;
                    ans = Math.max(ans, length);

                    break;
                }
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        return ans;

    }
}

// ==========================================
// 
// GFG Editorial
// 
// ==========================================


// Try using a two-pointer approach.
//  The right pointer moves till the number 
//  of unique characters are less than or equal to K. 
//  As the unique characters exceed K, the right pointer stops. 
//  Then, the left-pointer moves to exclude the minimum elements
//   from the current window such that the unique element again become equal to K.

// class Solution {
//     public int longestkSubstr(String s, int k) {
//         int[] m = new int[128];
//         int uniq = 0, i = 0, j = 0, res = 0, n = s.length();

//         while (j < n) {
//             // sliding the j-pointer till we have a valid substring
//             while (j < n) {
//                 if (m[s.charAt(j)] == 0) uniq++;
//                 m[s.charAt(j)]++;
//                 // if the number of uniq characters increases k, we stop.
//                 if (uniq > k) break;
//                 j++;
//             }

//             // checking if the unique characters are equal to k or k + 1
//             if (uniq >= k) res = Math.max(res, j - i);

//             if (j == n) break;

//             // sliding the i-pointer till we again get k unique characters in
//             // the substring
//             while (i < n) {
//                 if (m[s.charAt(i)] == 1) uniq--;
//                 m[s.charAt(i)]--;

//                 if (uniq == k) break;
//                 i++;
//             }
//             i++;
//             j++;
//         }
//         if (res == 0) return -1;
//         return res;
//     }
// }


