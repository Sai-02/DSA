
/*
Given a string, say S, print it in reverse manner 
eliminating the repeated characters and spaces.

Example 1:

Input: S = "GEEKS FOR GEEKS"
Output: "SKEGROF"

Example 2:

Input: S = "I AM AWESOME"
Output: "EMOSWAI"


Your Task:
You don't need to read input or print anything.
 Your task is to complete the function reverseString() 
 which takes a string S as input parameter and returns a modified string. 


Expected Time Complexity: O(|S|), where |S| denotes length of string.
Expected Auxiliary Space: O(1).

 
 */

// { Driver Code Starts
import java.io.*;
import java.util.*;

public class String_Reversal {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution2 ob = new Solution2();
            System.out.println(ob.reverseString(s));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution2 {
    public String reverseString(String s) {
        String ans = "";
        HashSet<Character> h = new HashSet<>();
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (!h.contains(c)) {
                    ans = ans + c;
                    h.add(c);
                }
            }

        }
        return ans;
    }
}
