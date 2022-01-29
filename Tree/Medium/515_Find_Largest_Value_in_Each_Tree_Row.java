
/**
 * Given the root of a binary tree, return an array of the largest value in each
 * row of the tree (0-indexed).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 * 
 * Input: root = [1,2,3]
 * Output: [1,3]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree will be in the range [0, 104].
 * -231 <= Node.val <= 231 - 1
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
// =====================================
//
// BFS Approach
//
// ======================================

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size(), max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                max = Math.max(node.val, max);
            }
            ans.add(max);
        }
        return ans;
    }
}

// ======================================
//
// DFS Approach
//
// =====================================

class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        solver(root, 1, ans);
        return ans;
    }

    public void solver(TreeNode root, int depth, List<Integer> ans) {
        if (root == null)
            return;
        if (ans.size() < depth)
            ans.add(root.val);
        else
            ans.set(depth - 1, Math.max(root.val, ans.get(depth - 1)));
        solver(root.left, depth + 1, ans);
        solver(root.right, depth + 1, ans);
    }
}