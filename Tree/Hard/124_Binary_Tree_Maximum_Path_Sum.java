/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes in the sequence has an edge connecting them. A node can only appear in
 * the sequence at most once. Note that the path does not need to pass through
 * the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty
 * path.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 =
 * 6.
 * Example 2:
 * 
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
 * = 42.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 * Accepted
 * 716,594
 * Submissions
 * 1,904,859
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
    class Pair {
        int maxSum, sum;

        Pair(int maxSum, int sum) {
            this.maxSum = maxSum;
            this.sum = sum;
        }
    }

    public int maxPathSum(TreeNode root) {
        return dfs(root).maxSum;
    }

    public Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(Integer.MIN_VALUE, 0);
        Pair lp = dfs(root.left);
        Pair rp = dfs(root.right);
        int maxSum = Math.max(lp.maxSum, rp.maxSum);
        maxSum = Math.max(maxSum, rp.sum + lp.sum + root.val);
        maxSum = Math.max(maxSum, root.val);
        maxSum = Math.max(maxSum, Math.max(rp.sum + root.val, lp.sum + root.val));
        return new Pair(maxSum, Math.max(root.val, root.val + Math.max(lp.sum, rp.sum)));
    }

}