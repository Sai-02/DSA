/*
Given a string consisting of lowercase english alphabets. 
Find the repeated character present first in the string.

Example 1:

Input:
S = "geeksforgeeks"
Output: g
Explanation: g, e, k and s are the repeating
characters. Out of these, g occurs first. 
â€‹Example 2:

Input: 
S = "abcde"
Output: -1
Explanation: No repeating character present.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function firstRep()
 which takes the string S as input and returns 
 the the first repeating character in the string.
  In case there's no repeating character present, return '#'.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105

 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Repeated_Character {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s;
            s = sc.next();

            Solution5 ob = new Solution5();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);

        }
    }
}// } Driver Code Ends

// User function Template for Java
class Solution5 {
    char firstRep(String S) {
        int freq[] = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
        int length = S.length();
        for (int i = 0; i < length; i++) {
            int index = S.charAt(i);
            index = index - 97;
            freq[index]++;
        }
        for (int i = 0; i < length; i++) {
            int index = S.charAt(i);
            index = index - 97;
            if (freq[index] >= 2) {
                return (char) (index + 97);
            }
        }
        return '#';
    }
}

// ====================================
// 
// GFG Editorial
// 
// ===================================

// Store the frequencies of all the characters in the string
// Then, traverse the string again from the beginning. 
// The first character with freq > 1 will be your result.


 