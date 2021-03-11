/*
Given a dictionary of words and a pattern.
 Every character in the pattern is uniquely mapped to a character in the dictionary.
  Find all such words in the dictionary that match the given pattern. 

Example 1:

Input:
N = 4
dict[] = {abb,abc,xyz,xyy}
pattern  = foo
Output: abb xyy
Explanation: xyy and abb have the same
character at index 1 and 2 like the
pattern.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function findMatchedWords()
  which takes an array of strings dict[] consisting of the words in 
  the dictionary and a string, Pattern and returns an array of strings 
  consisting of all the words in the dict[] that match the given Pattern 
  in lexicographical order.

Expected Time Complexity: O(N*K) (where K is the length of the pattern).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10
 */

// { Driver Code Starts
import java.util.*;

public class Match_specific_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            ArrayList<String> s = new ArrayList<String>(n);
            for (int i = 0; i < n; i++)
                s.add(sc.next());
            String tt;
            tt = sc.next();
            GfG g = new GfG();
            ArrayList<String> res = g.findMatchedWords(s, tt);
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();

        }
    }
}// } Driver Code Ends

/* Complete the provided function */

class GfG {
    /*
     * The function returns an array of strings present in the dictionary which
     * matches the string pattern. You are required to complete this method
     */
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern) {
        ArrayList<String> a = new ArrayList<>();
        String Pattern = toPattern(pattern);
        int size = dict.size();
        for (int i = 0; i < size; i++) {
            String s = toPattern(dict.get(i));
            if (Pattern.equals(s)) {
                a.add(dict.get(i));
            }

        }

        return a;

    }

    public static String toPattern(String str) {
        String ans = "";
        int length = str.length();
        int count = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (hm.containsKey(c)) {
                ans = ans + hm.get(c);
            } else {
                hm.put(c, count);
                count++;
                ans = ans + hm.get(c);
            }

        }
        return ans;
    }
}