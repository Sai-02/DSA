/*
Given a list of words followed by two words,
 the task to find the minimum distance between the given two words in the list of words

Example 1:

Input:
S = { "the", "quick", "brown", "fox", 
     "quick"}
word1 = "the"
word2 = "fox"
Output: 3
Explanation: Minimum distance between the 
words "the" and "fox" is 3

Example 2:

Input:
S = {"geeks", "for", "geeks", "contribute", 
     "practice"}
word1 = "geeks"
word2 = "practice"
Output: 2
Explanation: Minimum distance between the
words "geeks" and "practice" is 2


Your Task:  
You don't need to read input or print anything. 
Your task is to complete the function

shortestDistance() which list of words,
 two strings as inputs and returns the minimum distance between two words

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
Sum of lengths of words ≤ 105

Note: word1 and word2 are both in the list.
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Closest_Strings {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            ArrayList<String> arr = new ArrayList<String>();
            String input[] = read.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr.add(input[i]);
            }
            String word1 = read.readLine();
            String word2 = read.readLine();

            Solution4 ob = new Solution4();
            System.out.println(ob.shortestDistance(arr, word1, word2));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution4 {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        int n = s.size();
        int minDistance = n - 1;
        int i = 0, prev = -1;
        for (i = 0; i < n; i++) {
            if (s.get(i).equals(word1) || s.get(i).equals(word2)) {
                prev = i;
                break;
            }
        }
        while (i < n) {
            if (s.get(i).equals(word1) || s.get(i).equals(word2)) {
                if (!(s.get(i).equals(s.get(prev))) && i - prev < minDistance) {
                    minDistance = i - prev;

                }
                prev = i;

            }
            i++;

        }
        return minDistance;
    }
}