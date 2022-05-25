
/**
 * There is a binary tree rooted at 0 consisting of n nodes. The nodes are
 * labeled from 0 to n - 1. You are given a 0-indexed integer array parents
 * representing the tree, where parents[i] is the parent of node i. Since node 0
 * is the root, parents[0] == -1.
 * 
 * Each node has a score. To find the score of a node, consider if the node and
 * the edges connected to it were removed. The tree would become one or more
 * non-empty subtrees. The size of a subtree is the number of the nodes in it.
 * The score of the node is the product of the sizes of all those subtrees.
 * 
 * Return the number of nodes that have the highest score.
 * 
 * 
 * 
 * Example 1:
 * 
 * example-1
 * Input: parents = [-1,2,0,2,0]
 * Output: 3
 * Explanation:
 * - The score of node 0 is: 3 * 1 = 3
 * - The score of node 1 is: 4 = 4
 * - The score of node 2 is: 1 * 1 * 2 = 2
 * - The score of node 3 is: 4 = 4
 * - The score of node 4 is: 4 = 4
 * The highest score is 4, and three nodes (node 1, node 3, and node 4) have the
 * highest score.
 * Example 2:
 * 
 * example-2
 * Input: parents = [-1,2,0]
 * Output: 2
 * Explanation:
 * - The score of node 0 is: 2 = 2
 * - The score of node 1 is: 2 = 2
 * - The score of node 2 is: 1 * 1 = 1
 * The highest score is 2, and two nodes (node 0 and node 1) have the highest
 * score.
 * 
 * 
 * Constraints:
 * 
 * n == parents.length
 * 2 <= n <= 105
 * parents[0] == -1
 * 0 <= parents[i] <= n - 1 for i != 0
 * parents represents a valid binary tree.
 * Accepted
 * 10,516
 * Submissions
 * 22,443
 */

import java.util.*;

class Solution {
    long max = 0;
    int count = 0;

    public int countHighestScoreNodes(int[] parents) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < parents.length; i++)
            tree.add(new ArrayList<Integer>());
        for (int i = 1; i < parents.length; i++) {
            tree.get(parents[i]).add(i);
        }
        dfs(tree, 0);
        return count;
    }

    public int dfs(ArrayList<ArrayList<Integer>> tree, int src) {
        if (tree.get(src).size() == 0) {
            if (max == tree.size() - 1)
                count++;
            else if (max < tree.size() - 1) {
                max = tree.size() - 1;
                count = 1;
            }
            return 1;
        }
        int childCount = 0;
        long product = 1;
        for (int child : tree.get(src)) {
            int val = dfs(tree, child);
            childCount += val;
            product *= val;
        }
        int parentSubTree = tree.size() - childCount - 1;
        if (parentSubTree > 0)
            product *= parentSubTree;
        if (product == max)
            count++;
        else if (product > max) {
            max = product;
            count = 1;
        }
        return childCount + 1;
    }
}