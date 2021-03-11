
/*
Given a string str and another string patt. 
Find the character in patt that is present at the minimum index in str
. If no character of patt is present in str then print ‘No character present’.

Example 1:

Input:
str = geeksforgeeks
patt = set
Output: e
Explanation: e is the character which is
present in given patt "geeksforgeeks"
and is first found in str "set".
Example 2:

Input:
str = adcffaet
patt = onkl
Output: No character present
Explanation: There are none of the
characters which is common in patt
and str.
Your Task:
You only need to complete the function minIndexChar()
 that returns the index of answer in str or returns -1 
 in case no character of patt is present in str.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).

Constraints:
1 <= |str|,|patt| <= 105

Company Tags
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

// } Driver Code Ends

public class Minimum_indexed_character1 {

    public static int minIndexChar(String str, String pat) {
        HashSet<Character> h = new HashSet<>();
        int lengthP = pat.length();
        for (int i = 0; i < lengthP; i++) {
            h.add(pat.charAt(i));

        }
        lengthP = str.length();
        for (int i = 0; i < lengthP; i++) {
            if (h.contains(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}

// { Driver Code Starts.

class GFG1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;

            String s1 = sc.next();
            String s2 = sc.next();

            int res = new Minimum_indexed_character1().minIndexChar(s1, s2);
            if (res != -1)
                System.out.println(s1.charAt(res));
            else
                System.out.println("No character present");
        }
    }
}
// } Driver Code Ends

// ===============================================
// 
// GFG Editorial
// 
// ================================================




// class Solution{

//     public static int minIndexChar(String s1, String s2){
//         int i=0,l1=s1.length(),l2=s2.length();
// 		   HashSet<Character> hs=new HashSet<Character>();
// 		    for(i=0;i<l2;i++)
// 		        hs.add(s2.charAt(i));
// 		    for(i=0;i<l1;i++)
// 		        if(hs.contains(s1.charAt(i)))
// 		            break;
// 		    if(i<l1)
// 		        return i;
// 		    else
// 		        return -1;
//     }
// }