
/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * 
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and rightmost non-null nodes), where the null nodes between the
 * end-nodes are also counted into the length calculation.
 * 
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4
 * (5,3,null,9).
 * Example 2:
 * 
 * 
 * Input: root = [1,3,null,5,3]
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2
 * (5,3).
 * Example 3:
 * 
 * 
 * Input: root = [1,3,2,5]
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2
 * (3,2).
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 3000].
 * -100 <= Node.val <= 100
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return solver(root, 0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int solver(TreeNode root, int level, int order, ArrayList<Integer> start, ArrayList<Integer> end) {
        if (root == null)
            return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        }
        end.set(level, order);
        int curr = Math.abs(start.get(level) - end.get(level)) + 1;
        int left = solver(root.left, level + 1, 2 * order, start, end);
        int right = solver(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(curr, Math.max(left, right));
    }
}