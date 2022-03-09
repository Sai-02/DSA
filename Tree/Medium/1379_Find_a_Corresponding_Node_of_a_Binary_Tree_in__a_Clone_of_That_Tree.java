/**
 * Given two binary trees original and cloned and given a reference to a node
 * target in the original tree.
 * 
 * The cloned tree is a copy of the original tree.
 * 
 * Return a reference to the same node in the cloned tree.
 * 
 * Note that you are not allowed to change any of the two trees or the target
 * node and the answer must be a reference to a node in the cloned tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tree = [7,4,3,null,null,6,19], target = 3
 * Output: 3
 * Explanation: In all examples the original and cloned trees are shown. The
 * target node is a green node from the original tree. The answer is the yellow
 * node from the cloned tree.
 * Example 2:
 * 
 * 
 * Input: tree = [7], target = 7
 * Output: 7
 * Example 3:
 * 
 * 
 * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * The values of the nodes of the tree are unique.
 * target node is a node from the original tree and is not null.
 * 
 * 
 * Follow up: Could you solve the problem if repeated values on the tree are
 * allowed?
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode ans[] = new TreeNode[1];
        solver(original, cloned, target, ans);
        return ans[0];
    }

    public void solver(TreeNode original, TreeNode cloned, TreeNode target, TreeNode ans[]) {
        if (original == null)
            return;
        if (original == target) {
            ans[0] = cloned;
            return;
        }
        solver(original.left, cloned.left, target, ans);
        solver(original.right, cloned.right, target, ans);
    }
}