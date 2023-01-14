/**
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * 
 * We say s1[i] and s2[i] are equivalent characters.
 * 
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' ==
 * 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * 
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 =
 * "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab"
 * is the lexicographically smallest equivalent string of baseStr.
 * 
 * Return the lexicographically smallest equivalent string of baseStr by using
 * the equivalency information from s1 and s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "parker", s2 = "morris", baseStr = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in s1 and s2, we can group
 * their characters as [m,p], [a,o], [k,r,s], [e,i].
 * The characters in each group are equivalent and sorted in lexicographical
 * order.
 * So the answer is "makkek".
 * Example 2:
 * 
 * Input: s1 = "hello", s2 = "world", baseStr = "hold"
 * Output: "hdld"
 * Explanation: Based on the equivalency information in s1 and s2, we can group
 * their characters as [h,w], [d,e,o], [l,r].
 * So only the second letter 'o' in baseStr is changed to 'd', the answer is
 * "hdld".
 * Example 3:
 * 
 * Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation: We group the equivalent characters in s1 and s2 as
 * [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u'
 * and 'd' are transformed to 'a', the answer is "aauaaaaada".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length, baseStr <= 1000
 * s1.length == s2.length
 * s1, s2, and baseStr consist of lowercase English letters.
 * Accepted
 * 25,735
 * Submissions
 * 34,380
 */
class Solution {
    private char parent[] = new char[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            parent[i] = (char) (i + 97);
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            union(c1, c2);
        }
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            sb.append(find(c));
        }
        return sb.toString();
    }

    private void union(char c1, char c2) {
        char p1 = find(c1);
        char p2 = find(c2);
        if (p1 > p2) {
            char temp = p1;
            p1 = p2;
            p2 = temp;
        }
        parent[p2 - 97] = p1;

    }

    private char find(char c1) {
        if (parent[c1 - 97] == c1)
            return c1;
        return parent[c1 - 97] = find(parent[c1 - 97]);
    }
}