/*
Given a string str and another string patt.
 Find the character in patt that is present at the minimum index in str.
 

Example 1:

Input: str = "zsyle", patt = "bjz"
Output: "z"
Example 2:

Input: str = "anskg", patt = "me"
Output: "$"
 

Your Task:
You don't need to read or print anything. 
Your task is to complete the function printMinIndexChar()
 which takes str and patt as input parameter and returns 
 the character in patt that is present at the minimum index in str.
  If not possible returns "$".
 

Expected Time Complexity: O(max(|str|, |patt|))
Expected Auxilary Space: O(K) where K <= 26
 

Constraints:
1 ≤ |str|, |patt| ≤ 104
 */

// { Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;

public class Minimum_indexed_character {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String str = br.readLine().trim();
            String patt = br.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.printMinIndexChar(str, patt));
        }
    }
}// } Driver Code Ends

class Solution {

    // Function to find the character in patt which is present in str at min index
    public static String printMinIndexChar(String str, String patt) {

        int lengthS = str.length();
        int lengthP = patt.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < lengthS; i++) {
            char c = str.charAt(i);
            if (!hm.containsKey(c)) {
                hm.put(c, i);

            }
        }
        int minIndex = Integer.MAX_VALUE;
        char minIndexedChar = '$';
        for (int i = 0; i < lengthP; i++) {
            char c = patt.charAt(i);
            if (hm.containsKey(c)) {
                int index = hm.get(c);
                if (index < minIndex) {
                    minIndex = index;
                    minIndexedChar = c;
                }

            }

        }

        return "" + minIndexedChar;

    }

}

// ===========================================================
// 
// GFG Editorial
// 
// ===========================================================


// 1. Try to use the concept of Hashing to solve the problem.
// 2. Create a hash table with tuple represented as (character, index) tuple.
// Store the first index of each character of str in the hash table.
// Now, for each character of patt check if it is present in the hash table or not.
// If present then get its index from the hash table and update minIndex (minimum index encountered so far).
// For no matching character print “No character present”.



// class Solution{
    
//     public static String printMinIndexChar(String str, String patt){
        
//         // string buffer to store answer
//         String sb = "";
        
//         int i=0,l1=str.length(),l2=patt.length();
	    
// 	    // hash to store the character in patt with their first indexes
// 	    HashSet<Character> hs=new HashSet<Character>();
// 	    for(i=0;i<l2;i++)
// 	        hs.add(patt.charAt(i));
	    
// 	    // check if character in str is present in hash,
// 	    // if found print the min index character, else print "$"
// 	    for(i=0;i<l1;i++)
// 	        if(hs.contains(str.charAt(i)))
// 	            break;
// 	    if(i<l1)
// 	        sb = sb + str.charAt(i);
// 	    else
// 	        sb = "$";
	        
// 	   return sb;
    
//     }
    
// }
