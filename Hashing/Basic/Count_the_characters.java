

/*
Given a string S. Count the characters that have ‘N’ number of occurrences.
 If a character appears consecutively it is counted as 1 occurrence.

Example 1:

Input:
S = "abc", N = 1
Output: 3
Explanation: 'a', 'b' and 'c' all have 
1 occurrence.

â€‹Example 2:

Input: 
S = "geeksforgeeks", N = 2
Output: 4
Explanation: 'g', 'e', 'k' and 's' have
2 occurrences.

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function getCount()
  which takes the string S and an integer N as inputs
   and returns the count of the characters that have 
   exactly N occurrences in the string. 
   Note that the consecutive occurrences of a character have to be counted as 1.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=105
1<=N<=103

 
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Count_the_characters{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = sc.nextInt();

            System.out.println(new Sol().getCount(s, n));
        }

    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends

// User function Template for Java

class Sol {
    int getCount(String s, int N) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int length = s.length();
        int count = 0;
        char prev = ' ';
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != prev) {

                if (hm.containsKey(c)) {
                    if (hm.get(c) == N) {
                        count--;
                    }
                    hm.replace(c, hm.get(c) + 1);
                    if (hm.get(c) == N) {
                        count++;
                    }
                } else {
                    hm.put(c, 1);
                    if (hm.get(c) == N) {
                        count++;
                    }
                }
                prev = c;
            }
        }
        if (N == 0) {
            return 26 - hm.size();
        }
        return count;

    }
}


// =====================================
// 
// GFG Editorial
// 
// ====================================


// Try maintaing two pointers and store the occurrence of each character in the string.

// class Sol
// {
//     int getCount (String S, int N)
//     {
//         int freq[] = new int[26];
//         int n = S.length ();
    
//         int i = 0, j;
//         while (i < n)
//         {
//             j = i;
//             while (j < n && S.charAt (j) == S.charAt (i)) j++;
//             freq[(int)(S.charAt (i) - 'a')]++;
    
//             i = j;
//         }
    
//         int res = 0;
//         for (i = 0; i < 26; ++i)
//         {
//             if (freq[i] == N)
//                 res++;
//         }
//         return res;
//     }
// }
