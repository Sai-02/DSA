
/**
 * Given the root of a binary search tree, return a balanced binary search tree
 * with the same node values. If there is more than one answer, return any of
 * them.
 * 
 * A binary search tree is balanced if the depth of the two subtrees of every
 * node never differs by more than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also
 * correct.
 * Example 2:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 105
 * Accepted
 * 84,494
 * Submissions
 * 105,486
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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);
        return getTree(inOrder, 0, inOrder.size() - 1);
    }

    public TreeNode getTree(ArrayList<TreeNode> inOrder, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = inOrder.get(mid);
        root.left = getTree(inOrder, l, mid - 1);
        root.right = getTree(inOrder, mid + 1, r);
        return root;
    }

    public void getInOrder(TreeNode root, ArrayList<TreeNode> inOrder) {
        if (root == null)
            return;
        getInOrder(root.left, inOrder);
        inOrder.add(root);
        getInOrder(root.right, inOrder);
    }
}