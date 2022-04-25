
/**
 * Given an integer n, return all the structurally unique BST's (binary search
 * trees), which has exactly n nodes of unique values from 1 to n. Return the
 * answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output:
 * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 * 
 * Input: n = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * Accepted
 * 303,207
 * Submissions
 * 613,861
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *          this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return getTree(1, n);
    }

    public List<TreeNode> getTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = getTree(start, i - 1);
            List<TreeNode> right = getTree(i + 1, end);
            for (TreeNode lc : left) {
                for (TreeNode rc : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lc;
                    root.right = rc;
                    list.add(root);
                }
            }
        }
        return list;
    }
}