
/**
 * Given the root of a binary tree, return the leftmost value in the last row of
 * the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: 1
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 * Accepted
 * 160,395
 * Submissions
 * 248,097
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
// ================================================
//
// BFS Solution
//
// =================================================

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                if (i == 0)
                    ans = node.val;
            }
        }
        return ans;
    }
}

// ============================================
//
// DFS Solution
//
// ============================================

class Solution1 {
    public int findBottomLeftValue(TreeNode root) {
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        solver(root, 0, ans);
        return ans[0];
    }

    public void solver(TreeNode root, int depth, int ans[]) {
        if (root == null)
            return;
        if (depth > ans[1]) {
            ans[0] = root.val;
            ans[1] = depth;
        }
        solver(root.left, depth + 1, ans);
        solver(root.right, depth + 1, ans);
    }
}