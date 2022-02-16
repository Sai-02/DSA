
/**
 * Given an integer n, return a list of all possible full binary trees with n
 * nodes. Each node of each tree in the answer must have Node.val == 0.
 * 
 * Each element of the answer is the root node of one possible tree. You may
 * return the final list of trees in any order.
 * 
 * A full binary tree is a binary tree where each node has exactly 0 or 2
 * children.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 7
 * Output:
 * [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Example 2:
 * 
 * Input: n = 3
 * Output: [[0,0,0]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
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
    HashMap<Integer, List<TreeNode>> hm = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n <= 0 || n % 2 == 0)
            return ans;
        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        if (hm.containsKey(n))
            return hm.get(n);
        for (int i = 2; i < n; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBT(i - 1);
            List<TreeNode> rightNodes = allPossibleFBT(n - i);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.right = right;
                    root.left = left;
                    ans.add(root);
                }
            }
        }
        hm.put(n, ans);
        return ans;
    }
}