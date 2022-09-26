/**
 * You are given an array of strings equations that represent relationships
 * between variables where each string equations[i] is of length 4 and takes one
 * of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase
 * letters (not necessarily different) that represent one-letter variable names.
 * 
 * Return true if it is possible to assign integers to variable names so as to
 * satisfy all the given equations, or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: equations = ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is
 * satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * Example 2:
 * 
 * Input: equations = ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * 
 * 
 * Constraints:
 * 
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] is a lowercase letter.
 * equations[i][1] is either '=' or '!'.
 * equations[i][2] is '='.
 * equations[i][3] is a lowercase letter.
 * Accepted
 * 83,861
 * Submissions
 * 166,910
 */

class Solution {
    char[] parent = new char[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = (char) (i + 97);
        }
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0), s.charAt(3));
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                char u = find(s.charAt(0));
                char v = find(s.charAt(3));
                if (u == v)
                    return false;
            }
        }
        return true;
    }

    public char find(char node) {
        if (parent[node - 'a'] == node)
            return node;
        parent[node - 'a'] = find(parent[node - 'a']);
        return parent[node - 'a'];
    }

    public void union(char u, char v) {
        u = find(u);
        v = find(v);
        parent[v - 'a'] = u;
    }
}