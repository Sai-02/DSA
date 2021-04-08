/*
Given two strings S and P. Find the smallest window in the S consisting of
 all the characters of P.

Example 1:

Input:
S = "timetopractice"
P = "toc"
Output: 
toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Example 2:

Input:
S = "zoomlazapzo"
P = "oza"
Output: 
apzo
Explanation: "apzo" is the smallest 
substring in which "oza" can be found.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function smallestWindow()
  which takes two string S and P as input paramters and 
  returns the smallest window in string S having all the
   characters of the string P. In case there are multiple
    such windows of same length, return the one with the l
    east starting index. Return "-1" in case there is no such window present. 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints: 
1 ≤ |S|, |P| ≤ 105

Company Tags
Topic Tags
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Smallest_window_in_a_string_containing_all_the_characters_of_another_string {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        while (test > 0) {
            String s = scan.next();
            String t = scan.next();

            System.out.println(new Solution6().smallestWindow(s, t));
            test--;
        }
    }
}// } Driver Code Ends

class Solution6 {
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1"
    public static String smallestWindow(String s, String p) {
        int pLength = p.length();
        int sLength = s.length();
        if (pLength > sLength) {
            return "-1";
        }
        String ans = "";
        HashMap<Character, Integer> hmp = new HashMap<>();
        for (int i = 0; i < pLength; i++) {
            char c = p.charAt(i);
            if (hmp.containsKey(c)) {
                hmp.replace(c, hmp.get(c) + 1);

            } else {
                hmp.put(c, 1);
            }
        }
        HashMap<Character, Integer> hms = new HashMap<>();
        int i = -1, j = -1;
        int matchCount = 0;
        while (true) {
            boolean f1 = false, f2 = false;
            while (i < sLength - 1 && matchCount < pLength) {
                i++;
                char c = s.charAt(i);
                if (hms.containsKey(c)) {
                    hms.replace(c, hms.get(c) + 1);

                } else {
                    hms.put(c, 1);
                }
                if (hms.getOrDefault(c, 0) <= hmp.getOrDefault(c, 0)) {
                    matchCount++;
                }
                f1 = true;
            }

            while (j < i && matchCount == pLength) {
                String pAns = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || pAns.length() < ans.length()) {
                    ans = pAns;
                }
                j++;
                char c = s.charAt(j);
                if (hms.get(c) == 1) {
                    hms.remove(c);
                } else {
                    hms.replace(c, hms.get(c) - 1);
                }
                if (hms.getOrDefault(c, 0) < hmp.getOrDefault(c, 0)) {
                    matchCount--;
                }
                f2 = true;
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        if (ans.length() == 0) {
            ans += "-1";
        }
        return ans;
    }
}

// =========================================
//
// Explanation
//
// ===========================================

// For explanation refer -
// https://www.youtube.com/watch?v=e1HlptlipB0&t=1361s&ab_channel=Pepcoding