/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called root.
 * 
 * Besides the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that all houses in this place form a binary tree. It
 * will automatically contact the police if two directly-linked houses were
 * broken into on the same night.
 * 
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * 
 * 
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    class Pair {
        int inc, exc;

        Pair(int inc, int exc) {
            this.inc = inc;
            this.exc = exc;
        }
    }

    public int rob(TreeNode root) {
        Pair pair = solver(root);
        return Math.max(pair.inc, pair.exc);
    }

    public Pair solver(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);
        Pair lp = solver(root.left);
        Pair rp = solver(root.right);
        int exc = Math.max(lp.inc, lp.exc) + Math.max(rp.inc, rp.exc);
        int inc = root.val + lp.exc + rp.exc;
        return new Pair(inc, exc);
    }
}