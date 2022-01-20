
/**
 * Given the root of a binary tree and an integer targetSum, return all
 * root-to-leaf paths where the sum of the node values in the path equals
 * targetSum. Each path should be returned as a list of the node values, not
 * node references.
 * 
 * A root-to-leaf path is a path starting from the root and ending at any leaf
 * node. A leaf is a node with no children.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 * 
 * Input: root = [1,2], targetSum = 0
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * Accepted
 * 532,299
 * Submissions
 * 1,003,348
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        solver(root, targetSum, list, ans);
        return ans;
    }

    public void solver(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                list.add(root.val);
                List<Integer> a = new ArrayList<>();
                for (int val : list) {
                    a.add(val);
                }
                ans.add(a);
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        solver(root.left, sum - root.val, list, ans);
        solver(root.right, sum - root.val, list, ans);
        list.remove(list.size() - 1);
    }
}