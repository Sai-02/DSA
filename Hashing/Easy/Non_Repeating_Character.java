/*
Given a string S consisting of lowercase Latin Letters.
 Find the first non-repeating character in S.

Example 1:

Input:
S = hello
Output: h
Explanation: In the given string, the
first character which is non-repeating
is h, as it appears first and there is
no other 'h' in the string.
Example 2:

Input:
S = zxvczbtxyzvy
Output: c
Explanation: In the given string, 'c' is
the character which is non-repeating. 
Your Task:
You only need to complete the function nonrepeatingCharacter()
 that takes string S as a parameter and returns the character.
  If there is no non-repeating character then return '$' .

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).
Note: N = |S|

Constraints:
1 <= N <= 103

 

Company Tags
 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Non_Repeating_Character {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution4().nonrepeatingCharacter(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution4 {
    static char nonrepeatingCharacter(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                int count = hm.get(c);
                count++;
                hm.replace(c, count);

            } else {
                hm.put(c, 1);
            }
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (hm.get(c) == 1) {
                return c;
            }
        }

        return '$';
    }
}


// =====================================
// 
// GFG Editorial
// 
// ====================================


// First take the count of each character and store it in an array.
//  Also store the index where that particular character occurs.

// After that, check for each character from 'a' to 'z' 
// if the frequency of that character is 1 then check 
// if the position of current character is less than the position of previously
//  stored character then replace that with current character. 

// class Solution
// {
//     static char nonrepeatingCharacter(String S)
//     {
//             int h[] = new int[26];
//             Arrays.fill(h, 0);
    	    
//         // storing the count of each characters
//         // in an array (can be called hash)
//         for(int i = 0;i<S.length();i++){
//             h[S.charAt(i)-'a']++;
//         }
    
        
//         StringBuilder st = new StringBuilder("");
        
//         // iterating through the string and check if
//         // count of current character is 1, then that
//         // character is the first non-repeating(ocurrence is 1)
//         // and break from for loop
//         for(int i = 0;i<S.length();i++){
//             if(h[S.charAt(i)-'a'] == 1){
//                 return(S.charAt(i));
                
//             }
//         }
        
//         return '$';
//     }
// }


 