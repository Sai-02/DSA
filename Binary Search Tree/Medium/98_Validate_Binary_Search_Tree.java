/**
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
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
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * 
 * 
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 * Accepted
 * 1,250,533
 * Submissions
 * 4,159,316
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
    public boolean isValidBST(TreeNode root) {
        long flag[] = new long[2];
        long prevValue = Long.MIN_VALUE;
        flag[0] = 0;
        flag[1] = prevValue;
        checkInorder(root, flag);
        return flag[0] != -1;
    }

    public void checkInorder(TreeNode root, long flag[]) {
        if (root == null)
            return;
        if (flag[0] == -1)
            return;
        checkInorder(root.left, flag);
        long prevValue = flag[1];
        if (prevValue != Long.MIN_VALUE && root.val <= (int) prevValue) {
            flag[0] = -1;
            return;
        }
        flag[1] = root.val;
        checkInorder(root.right, flag);
    }

}