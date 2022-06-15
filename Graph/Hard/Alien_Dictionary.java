
/**
 * Given a sorted dictionary of an alien language having N words and k starting
 * alphabets of standard dictionary. Find the order of characters in the alien
 * language.
 * Note: Many orders may be possible for a particular test case, thus you may
 * return any valid order and output will be 1 if the order of string returned
 * by the function is correct else 0 denoting incorrect string returned.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * N = 5, K = 4
 * dict = {"baa","abcd","abca","cab","cad"}
 * Output:
 * 1
 * Explanation:
 * Here order of characters is
 * 'b', 'd', 'a', 'c' Note that words are sorted
 * and in the given language "baa" comes before
 * "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * Example 2:
 * 
 * Input:
 * N = 3, K = 3
 * dict = {"caa","aaa","aab"}
 * Output:
 * 1
 * Explanation:
 * Here order of characters is
 * 'c', 'a', 'b' Note that words are sorted
 * and in the given language "caa" comes before
 * "aaa", therefore 'c' is before 'a' in output.
 * Similarly we can find other orders.
 * 
 * 
 * Your Task:
 * You don't need to read or print anything. Your task is to complete the
 * function findOrder() which takes the string array dict[], its size N and the
 * integer K as input parameter and returns a string denoting the order of
 * characters in the alien language.
 * 
 * 
 * Expected Time Complexity: O(N * |S| + K) , where |S| denotes maximum length.
 * Expected Space Compelxity: O(K)
 * 
 * 
 * Constraints:
 * 1 ≤ N, M ≤ 300
 * 1 ≤ K ≤ 26
 * 1 ≤ Length of words ≤ 50
 */

import java.util.*;

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (String str : dict) {
            for (char c : str.toCharArray()) {
                graph.put(c, new ArrayList<Character>());
                indegree.put(c, 0);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            String wordA = dict[i];
            String wordB = dict[i + 1];
            for (int j = 0; j < Math.min(wordA.length(), wordB.length()); j++) {
                char charA = wordA.charAt(j);
                char charB = wordB.charAt(j);
                if (charA != charB) {
                    graph.get(charA).add(charB);
                    indegree.put(charB, indegree.get(charB) + 1);
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char key : indegree.keySet()) {
            if (indegree.get(key) == 0)
                q.add(key);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char node = q.remove();
            sb.append("'" + node + "',");
            for (char child : graph.get(node)) {
                if (indegree.get(child) == 0)
                    continue;
                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0)
                    q.add(child);
            }
        }
        return sb.toString();
    }
}