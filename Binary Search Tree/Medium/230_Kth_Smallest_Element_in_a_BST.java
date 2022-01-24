
/**
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 
 * 
 * Follow up: If the BST is modified often (i.e., we can do insert and delete
 * operations) and you need to find the kth smallest frequently, how would you
 * optimize?
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

// ==================================================
//
// Recursive Solution
//
// =================================================
class Solution {
    int kSmallest = 0, count = 0;

    public int kthSmallest(TreeNode root, int k) {
        solver(root, k);
        return kSmallest;
    }

    public void solver(TreeNode root, int k) {
        if (root == null)
            return;
        solver(root.left, k);
        count++;
        if (count == k)
            kSmallest = root.val;
        solver(root.right, k);
    }
}



