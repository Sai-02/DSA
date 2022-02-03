
/**
 * Given the root of a binary tree, construct a 0-indexed m x n string matrix
 * res that represents a formatted layout of the tree. The formatted layout
 * matrix should be constructed using the following rules:
 * 
 * The height of the tree is height and the number of rows m should be equal to
 * height + 1.
 * The number of columns n should be equal to 2height+1 - 1.
 * Place the root node in the middle of the top row (more formally, at location
 * res[0][(n-1)/2]).
 * For each node that has been placed in the matrix at position res[r][c], place
 * its left child at res[r+1][c-2height-r-1] and its right child at
 * res[r+1][c+2height-r-1].
 * Continue this process until all the nodes in the tree have been placed.
 * Any empty cells should contain the empty string "".
 * Return the constructed matrix res.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2]
 * Output:
 * [["","1",""],
 * ["2","",""]]
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,null,4]
 * Output:
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 210].
 * -99 <= Node.val <= 99
 * The depth of the tree will be in the range [1, 10].
 * Accepted
 * 47,458
 * Submissions
 * 80,682
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int ht = getHeight(root);
        int col = (int) Math.pow(2, ht) - 1;
        for (int i = 0; i < ht; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add("");
            }
            ans.add(temp);
        }
        solver(root, 0, 0, col - 1, ans);
        return ans;
    }

    public void solver(TreeNode root, int level, int i, int j, List<List<String>> ans) {
        if (root == null)
            return;
        int mid = (i + j) / 2;
        ans.get(level).set(mid, root.val + "");
        solver(root.left, level + 1, i, mid, ans);
        solver(root.right, level + 1, mid + 1, j, ans);
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}