/**
 * Given the root of a binary tree, return the length of the longest path, where
 * each node in the path has the same value. This path may or may not pass
 * through the root.
 * 
 * The length of the path between two nodes is represented by the number of
 * edges between them.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 * Example 2:
 * 
 * 
 * Input: root = [1,4,5,4,4,5]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
 * Accepted
 * 134,842
 * Submissions
 * 345,502
 */
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
    int maxCount = 0;

    public int longestUnivaluePath(TreeNode root) {
        return Math.max(solver(root), maxCount);
    }

    public int solver(TreeNode root) {
        if (root == null)
            return -1;
        int left = solver(root.left);
        int right = solver(root.right);
        maxCount = Math.max(maxCount, Math.max(left, right));
        if (root.left != null && root.right != null && root.left.val == root.val && root.val == root.right.val) {
            maxCount = Math.max(maxCount, left + right + 2);
            return Math.max(left, right) + 1;
        } else if (root.left != null && root.left.val == root.val) {
            return left + 1;
        } else if (root.right != null && root.right.val == root.val) {
            return right + 1;
        }
        return 0;
    }
}