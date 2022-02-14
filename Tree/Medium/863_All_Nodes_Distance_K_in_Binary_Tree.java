
/**
 * Given the root of a binary tree, the value of a target node target, and an
 * integer k, return an array of the values of all nodes that have a distance k
 * from the target node.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value
 * 5) have values 7, 4, and 1.
 * Example 2:
 * 
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
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
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        solver(root, target, k);
        return ans;
    }

    public List<Integer> getNodesAtK(TreeNode root, int dist, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || dist > k)
            return ans;
        if (dist == k) {
            ans.add(root.val);
            return ans;
        }
        ans.addAll(getNodesAtK(root.left, dist + 1, k));
        ans.addAll(getNodesAtK(root.right, dist + 1, k));
        return ans;
    }

    public int solver(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return -1;
        if (root.val == target.val) {
            ans.addAll(getNodesAtK(root, 0, k));
            return 1;
        }
        int left = solver(root.left, target, k);
        int right = solver(root.right, target, k);
        if (left == k || right == k) {
            ans.add(root.val);
        } else {
            if (right != -1) {
                ans.addAll(getNodesAtK(root.left, 1, k - right));
            }
            if (left != -1) {
                ans.addAll(getNodesAtK(root.right, 1, k - left));
            }
        }
        return ((left == -1 && right == -1) ? -1 : Math.max(left, right) + 1);
    }
}