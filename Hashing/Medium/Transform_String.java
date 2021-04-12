/*
Given two strings A and B. Find the minimum number of s
teps required to transform string A into string B. The only allowed operation for 
the transformation is selecting a character from string A and inserting it in the 
beginning of string A.

Example 1:

Input:
A = "abd"
B = "bad"
Output: 1
Explanation: The conversion can take place in
1 operation: Pick 'b' and place it at the front.
Example 2:

Input:
A = "GeeksForGeeks"
B = "ForGeeksGeeks"
Output: 3
Explanation: The conversion can take
place in 3 operations:
Pick 'r' and place it at the front.
A = "rGeeksFoGeeks"
Pick 'o' and place it at the front.
A = "orGeeksFGeeks"
Pick 'F' and place it at the front.
A = "ForGeeksGeeks"
Your Task: 
You dont need to read input or print anything.
 Complete the function transform() which takes
  two strings A and B as input parameters and 
  returns the minimum number of steps required 
  to transform A into B. If transformation is not possible return -1.


Expected Time Complexity: O(N) where N is max(length of A, length of B) 
Expected Auxiliary Space: O(1)  


Constraints:
1<= A.length(), B.length() <= 104

 
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Transform_String {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            String A = arr[0];
            String B = arr[1];
            Solution8 obj = new Solution8();
            System.out.println(obj.transform(A, B));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution8 {
    int transform(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        int n = A.length();
        int a[] = new int[256];
        for (int i = 0; i < n; i++) {
            a[B.charAt(i)]++;
            a[A.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (a[i] == 0) {
                continue;
            } else {
                return -1;
            }
        }
        int ans = 0;
        int i = n - 1;
        int j = n - 1;
        while (i >= 0) {
            if (A.charAt(i) != B.charAt(j)) {
                ans++;
            } else {
                j--;
            }
            i--;
        }

        return ans;

    }
}