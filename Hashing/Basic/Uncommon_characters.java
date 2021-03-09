/*
Given two strings A and B. Find the characters that are not common in the two strings. 

Example 1:

Input:
A = geeksforgeeks
B = geeksquiz
Output: fioqruz
Explanation: 
The characters 'f', 'i', 'o', 'q', 'r', 'u','z' 
are either present in A or B, but not in both.
Example 2:

Input:
A = characters
B = alphabets
Output: bclpr
Explanation: The characters 'b','c','l','p','r' 
are either present in A or B, but not in both.

Your Task:  
You dont need to read input or print anything.
 Complete the function UncommonChars() which takes strings A and B as 
 input parameters and returns a string that contains all the uncommon 
 characters in sorted order. If no such character exists return "-1".


Expected Time Complexity: O(M+N) where M and N are the sizes of A and B respectively.
Expected Auxiliary Space: O(M+N)  


Constraints:
1<= M,N <= 104
String may contain duplicate characters.

 
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Uncommon_characters {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String A = sc.next();
            String B = sc.next();
            Solution4 ob = new Solution4();
            System.out.println(ob.UncommonChars(A, B));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution4 {
    String UncommonChars(String A, String B) {
        String ans = "";
        boolean aBool[] = new boolean[26];
        boolean bBool[] = new boolean[26];
        for (int i = 0; i < 26; i++) {
            aBool[i] = false;
            bBool[i] = false;
        }
        int lengthA = A.length();
        int lengthB = B.length();
        for (int i = 0; i < lengthA; i++) {
            int c = A.charAt(i);
            c = c - 97;
            aBool[c] = true;

        }
        for (int i = 0; i < lengthB; i++) {
            int c = B.charAt(i);
            c = c - 97;
            bBool[c] = true;

        }
        for (int i = 0; i < 26; i++) {
            if (aBool[i] != bBool[i]) {
                ans = ans + (char) (i + 97);
            }
        }
        if (ans.equals("")) {
            ans += "-1";
        }
        return ans;

    }
}

// ==================================================
//
// GFG Editorial
//
// =================================================

// Maintain a hash map of all the characters.
