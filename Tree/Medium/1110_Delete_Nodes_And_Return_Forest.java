
/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a forest
 * (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest. You may return the
 * result in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * Example 2:
 * 
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 * Accepted
 * 150,068
 * Submissions
 * 216,987
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();
        for (int val : to_delete)
            h.add(val);
        root = solver(root, to_delete, ans, h);
        if (root != null) {
            ans.add(root);
        }
        return ans;
    }

    public TreeNode solver(TreeNode root, int[] to_delete, List<TreeNode> ans, HashSet<Integer> h) {
        if (root == null)
            return null;
        root.left = solver(root.left, to_delete, ans, h);
        root.right = solver(root.right, to_delete, ans, h);
        if (h.contains(root.val)) {
            if (root.left != null)
                ans.add(root.left);
            if (root.right != null)
                ans.add(root.right);
            return null;
        }
        return root;

    }
}