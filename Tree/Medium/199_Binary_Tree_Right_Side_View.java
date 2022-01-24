
/**
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 * 
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * Accepted
 * 598,670
 * Submissions
 * 1,016,729
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

// ===========================================================
//
// DFS Approach
//
// ============================================================

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        solver(root, 0, ans);
        return ans;
    }

    public void solver(TreeNode root, int currDepth, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (currDepth == ans.size())
            ans.add(root.val);
        solver(root.right, currDepth + 1, ans);
        solver(root.left, currDepth + 1, ans);
    }
}

// ======================================================================
//
// BFS Approach
//
// =====================================================================

class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode prev = null;
            while (size-- > 0) {
                TreeNode node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                prev = node;
            }
            ans.add(prev.val);
        }
        return ans;
    }
}