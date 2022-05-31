/**
 * You are given the root of a binary tree. We install cameras on the tree nodes
 * where each camera at a node can monitor its parent, itself, and its immediate
 * children.
 * 
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * Example 2:
 * 
 * 
 * Input: root = [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the
 * tree. The above image shows one of the valid configurations of camera
 * placement.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val == 0
 */
class TreeNode {
    TreeNode left, right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    class Pair {
        boolean isCamera, isCovered;

        Pair(boolean isCamera, boolean isCovered) {
            this.isCamera = isCamera;
            this.isCovered = isCovered;
        }
    }

    public int minCameraCover(TreeNode root) {
        int count[] = new int[1];
        Pair p = solver(root, count);
        if (!p.isCovered)
            count[0]++;
        return count[0];
    }

    public Pair solver(TreeNode root, int count[]) {
        if (root == null)
            return new Pair(false, true);
        if (root.left == null && root.right == null)
            return new Pair(false, false);
        Pair lp = solver(root.left, count);
        Pair rp = solver(root.right, count);
        if (lp.isCamera && rp.isCamera)
            return new Pair(false, true);
        if ((lp.isCamera && rp.isCovered) || (rp.isCamera && lp.isCovered))
            return new Pair(false, true);
        if (lp.isCovered && rp.isCovered)
            return new Pair(false, false);
        if (!lp.isCovered || !rp.isCovered) {
            count[0]++;
            return new Pair(true, true);
        }
        return new Pair(false, false);
    }

}