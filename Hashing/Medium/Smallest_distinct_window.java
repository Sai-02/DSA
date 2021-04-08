/*
Given a string 's'. The task is to find the smallest window length that contains
 all the characters of the given string at least one time.
For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest window 
will be “dbca”.

 

Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"
Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
 


Your Task:  
You don't need to read input or print anything. 
Your task is to complete the function findSubString()
 which takes the string  S as inputs and returns the 
 length of the smallest such string.


Expected Time Complexity: O(256.N)
Expected Auxiliary Space: O(256)

 

Constraints:
1 ≤ |S| ≤ 105
String may contain both type of English Alphabets.

Company Tags
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Smallest_distinct_window {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution5 obj = new Solution5();
            System.out.println(obj.findSubString(str).length());

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution5 {
    public String findSubString(String str) {
        String ans = "";
        int n = str.length();
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            h.add(c);
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = -1, j = -1;
        while (true) {
            boolean f1 = false, f2 = false;
            while (i < n - 1 && hm.size() < h.size()) {
                i++;
                char c = str.charAt(i);
                if (hm.containsKey(c)) {
                    hm.replace(c, hm.get(c) + 1);
                } else {
                    hm.put(c, 1);
                }
                f1 = true;
            }

            while (j < i && hm.size() == h.size()) {
                String pAns = str.substring(j + 1, i + 1);
                if (ans.length() == 0 || pAns.length() < ans.length()) {

                    ans = pAns;
                }
                j++;
                char c = str.charAt(j);
                if (hm.get(c) == 1) {
                    hm.remove(c);
                } else {
                    hm.replace(c, hm.get(c) - 1);

                }
                f2 = true;

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
// Expalanation
// 
// =========================================

// For explanation refer it- https://www.youtube.com/watch?v=pbUNTDdxomI&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=8&ab_channel=Pepcoding