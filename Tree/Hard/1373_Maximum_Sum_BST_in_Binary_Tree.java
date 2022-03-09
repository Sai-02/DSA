/**
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree
 * which is also a Binary Search Tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * Output: 20
 * Explanation: Maximum sum in a valid Binary search tree is obtained in root
 * node with key equal to 3.
 * Example 2:
 * 
 * 
 * 
 * Input: root = [4,3,null,1,2]
 * Output: 2
 * Explanation: Maximum sum in a valid Binary search tree is obtained in a
 * single root node with key equal to 2.
 * Example 3:
 * 
 * Input: root = [-4,-2,-5]
 * Output: 0
 * Explanation: All values are negatives. Return an empty BST.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 4 * 104].
 * -4 * 104 <= Node.val <= 4 * 104
 * Accepted
 * 29.6K
 * Submissions
 * 76.9K
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Pair {
    int sum, maxSum, min, max;
    boolean isBST;

    Pair(int sum, int maxSum, boolean isBST, int min, int max) {
        this.sum = sum;
        this.maxSum = maxSum;
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}

class Solution {
    public int maxSumBST(TreeNode root) {
        Pair pair = solver(root);
        return pair.maxSum;
    }

    public Pair solver(TreeNode root) {
        if (root == null)
            return new Pair(0, 0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        boolean isBST = true;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, leftSum = 0, rightSum = 0;
        if (root.left != null) {
            Pair left = solver(root.left);
            if (root.val <= root.left.val)
                isBST = false;
            isBST = isBST && left.isBST;
            if (root.val <= left.max)
                isBST = false;
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            maxSum = Math.max(maxSum, left.maxSum);
            leftSum = left.sum;
        }
        if (root.right != null) {
            Pair right = solver(root.right);
            if (root.val >= root.right.val)
                isBST = false;
            isBST = isBST && right.isBST;
            if (root.val >= right.min)
                isBST = false;
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
            maxSum = Math.max(maxSum, right.maxSum);
            rightSum = right.sum;
        }
        int sum = 0;
        if (isBST) {
            sum = root.val + leftSum + rightSum;
        }
        maxSum = Math.max(sum, maxSum);
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        return new Pair(sum, maxSum, isBST, min, max);
    }
}