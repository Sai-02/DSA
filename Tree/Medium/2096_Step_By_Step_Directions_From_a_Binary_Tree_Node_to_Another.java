
/**
 * You are given the root of a binary tree with n nodes. Each node is uniquely
 * assigned a value from 1 to n. You are also given an integer startValue
 * representing the value of the start node s, and a different integer destValue
 * representing the value of the destination node t.
 * 
 * Find the shortest path starting from node s and ending at node t. Generate
 * step-by-step directions of such path as a string consisting of only the
 * uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific
 * direction:
 * 
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * Return the step-by-step directions of the shortest path from node s to node
 * t.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * Output: "UURL"
 * Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
 * Example 2:
 * 
 * 
 * Input: root = [2,1], startValue = 2, destValue = 1
 * Output: "L"
 * Explanation: The shortest path is: 2 → 1.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is n.
 * 2 <= n <= 105
 * 1 <= Node.val <= n
 * All the values in the tree are unique.
 * 1 <= startValue, destValue <= n
 * startValue != destValue
 * Accepted
 * 65.3K
 * Submissions
 * 133.7K
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
    class Pair {
        StringBuilder src, dest;

        Pair(StringBuilder src, StringBuilder dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder ans = new StringBuilder("");
        solver(root, startValue, destValue, ans, false);
        return ans.toString();
    }

    public Pair solver(TreeNode root, int src, int dest, StringBuilder ans, boolean left) {
        if (root == null || ans.length() > 0)
            return new Pair(new StringBuilder(""), new StringBuilder(""));
        Pair lp = solver(root.left, src, dest, ans, true);
        Pair rp = solver(root.right, src, dest, ans, false);
        if ((lp.src.length() > 0 || lp.dest.length() > 0) && (rp.src.length() > 0 || rp.dest.length() > 0)) {
            if (lp.src.length() > 0) {
                ans.append(lp.src.toString() + rp.dest.reverse().toString());
            } else {
                ans.append(rp.src.toString() + lp.dest.reverse().toString());
            }
            return new Pair(new StringBuilder(""), new StringBuilder(""));
        }
        if (root.val == src && (lp.dest.length() > 0 || rp.dest.length() > 0)) {
            if (lp.dest.length() > 0) {
                ans.append(lp.dest.toString());
                ans.reverse();
            } else {
                ans.append(rp.dest.toString());
                ans.reverse();
            }
            return new Pair(new StringBuilder(""), new StringBuilder(""));
        }
        if (root.val == dest && (lp.src.length() > 0 || rp.src.length() > 0)) {
            if (lp.src.length() > 0) {
                ans.append(lp.src.toString());
            } else {
                ans.append(rp.src.toString());
            }
            return new Pair(new StringBuilder(""), new StringBuilder(""));
        }
        StringBuilder srcPath = null, destPath = null;
        if (lp.src.length() > 0)
            srcPath = lp.src;
        if (lp.dest.length() > 0)
            destPath = lp.dest;
        if (rp.src.length() > 0)
            srcPath = rp.src;
        if (rp.dest.length() > 0)
            destPath = rp.dest;
        if (srcPath == null)
            srcPath = new StringBuilder("");
        if (destPath == null)
            destPath = new StringBuilder("");
        if (srcPath.length() > 0 || root.val == src)
            srcPath.append("U");
        if (destPath.length() > 0 || root.val == dest) {
            if (left)
                destPath.append("L");
            else
                destPath.append("R");
        }
        return new Pair(srcPath, destPath);
    }
}