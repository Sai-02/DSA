/**
 * Given the root of a binary tree, the depth of each node is the shortest
 * distance to the root.
 * 
 * Return the smallest subtree such that it contains all the deepest nodes in
 * the original tree.
 * 
 * A node is called the deepest if it has the largest depth possible among any
 * node in the entire tree.
 * 
 * The subtree of a node is a tree consisting of that node, plus the set of all
 * descendants of that node.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation: We return the node with value 2, colored in yellow in the
 * diagram.
 * The nodes coloured in blue are the deepest nodes of the tree.
 * Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2
 * is the smallest subtree among them, so we return it.
 * Example 2:
 * 
 * Input: root = [1]
 * Output: [1]
 * Explanation: The root is the deepest node in the tree.
 * Example 3:
 * 
 * Input: root = [0,1,3,null,2]
 * Output: [2]
 * Explanation: The deepest node in the tree is 2, the valid subtrees are the
 * subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree will be in the range [1, 500].
 * 0 <= Node.val <= 500
 * The values of the nodes in the tree are unique.
 * 
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
    int count = 0;
    TreeNode ans = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        countMaxDepthNodes(root, 1, maxDepth);
        solver(root, 1, maxDepth);
        return ans;
    }

    public int solver(TreeNode root, int depth, int maxDepth) {
        if (root == null)
            return 0;
        if (depth == maxDepth) {
            if (count == 1) {
                ans = root;
                return 0;
            }
            return 1;
        }
        int left = solver(root.left, depth + 1, maxDepth);
        int right = solver(root.right, depth + 1, maxDepth);
        if (left > 0 && right > 0) {
            if (count == left + right) {
                ans = root;
                return 0;
            }
        }
        return left + right;
    }

    public void countMaxDepthNodes(TreeNode root, int depth, int maxDepth) {
        if (root == null)
            return;
        if (depth == maxDepth)
            count++;
        countMaxDepthNodes(root.left, depth + 1, maxDepth);
        countMaxDepthNodes(root.right, depth + 1, maxDepth);
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }
}