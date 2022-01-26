
/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * 
 * A leaf is a node with no children.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 * 
 * Input: root = [1]
 * Output: ["1"]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * Accepted
 * 473,633
 * Submissions
 * 823,666
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
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        List<String> ans = new ArrayList<>();
        solver(root, sb, ans);
        return ans;
    }

    public void solver(TreeNode root, StringBuilder sb, List<String> ans) {
        if (root == null)
            return;
        int length = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        } else {
            sb.append("->");
        }
        solver(root.left, sb, ans);
        solver(root.right, sb, ans);
        sb.setLength(length);
    }
}