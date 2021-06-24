
/*
Given two strings a and b consisting of lowercase characters. 
The task is to check whether two given strings are an anagram of each other or not.
 An anagram of a string is another string that contains the same characters,
  only the order of characters can be different. For example, “act” and “tac” 
  are an anagram of each other.

Example 1:

Input:
a = geeksforgeeks, b = forgeeksgeeks
Output: YES
Explanation: Both the string have same
characters with same frequency. So, 
both are anagrams.
Example 2:

Input:
a = allergy, b = allergic
Output: NO
Explanation:Characters in both the strings
are not same, so they are not anagrams.
Your Task:
You don't need to read input or print anything.
Your task is to complete the function isAnagram()
 which takes the string a and string b as input parameter and
  check if the two strings are an anagram of each other. 
  The function returns true if the strings are anagram else it returns false.

Expected Time Complexity: O(|a|+|b|).
Expected Auxiliary Space: O(Number of distinct characters).

Note: |s| represents the length of string s.

Constraints:
1 ≤ |a|,|b| ≤ 105

Company Tags
Topic Tags
Related Courses
*/
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Anagram {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution2 obj = new Solution2();

            if (obj.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}// } Driver Code Ends

class Solution2 {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {
        int aFreq[] = new int[26];
        int bFreq[] = new int[26];
        Arrays.fill(aFreq, 0);
        Arrays.fill(bFreq, 0);
        int aLength = a.length();
        int bLength = b.length();
        for (int i = 0; i < aLength; i++) {
            int c = (int) a.charAt(i);
            c -= 97;
            aFreq[c]++;

        }
        for (int i = 0; i < bLength; i++) {
            int c = (int) b.charAt(i);
            c -= 97;
            bFreq[c]++;

        }
        for (int i = 0; i < 26; i++) {
            if (aFreq[i] != bFreq[i]) {
                return false;
            }
        }

        return true;

    }
}