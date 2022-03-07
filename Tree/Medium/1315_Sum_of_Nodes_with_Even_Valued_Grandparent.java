/**
 * Given the root of a binary tree, return the sum of values of nodes with an
 * even-valued grandparent. If there are no nodes with an even-valued
 * grandparent, return 0.
 * 
 * A grandparent of a node is the parent of its parent if it exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while
 * the blue nodes are the even-value grandparents.
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
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
    public int sumEvenGrandparent(TreeNode root) {
        return solver(root, null, null);
    }

    public int solver(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null)
            return 0;
        int left = solver(root.left, root, parent);
        int right = solver(root.right, root, parent);
        int sum = left + right;
        if (grandparent != null && grandparent.val % 2 == 0)
            sum += root.val;
        return sum;
    }
}