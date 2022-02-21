
/**
 * Given the root of a binary tree, calculate the vertical order traversal of
 * the binary tree.
 * 
 * For each node at position (row, col), its left and right children will be at
 * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
 * the tree is at (0, 0).
 * 
 * The vertical order traversal of a binary tree is a list of top-to-bottom
 * orderings for each column index starting from the leftmost column and ending
 * on the rightmost column. There may be multiple nodes in the same row and same
 * column. In such a case, sort these nodes by their values.
 * 
 * Return the vertical order traversal of the binary tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 * 1 is at the top, so it comes first.
 * 5 and 6 are at the same position (2, 0), so we order them by their value, 5
 * before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 3:
 * 
 * 
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same
 * location and should be ordered by their values.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int maxLeft = 0, maxRight = 0, width = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<List<Integer>>> temp = new ArrayList<>();
        int height = getWidthAndHeight(root, 0);
        width = Math.abs(maxLeft) + maxRight + 1;
        for (int i = 0; i < width; i++) {
            temp.add(new ArrayList<List<Integer>>());
            for (int j = 0; j < height; j++) {
                temp.get(i).add(new ArrayList<Integer>());
            }
        }
        solver(root, 0, 0, temp);
        for (List<List<Integer>> cont : temp) {
            ans.add(new ArrayList<Integer>());
            for (List<Integer> list : cont) {
                Collections.sort(list);
                ans.get(ans.size() - 1).addAll(list);
            }
        }
        return ans;
    }

    public void solver(TreeNode root, int index, int height, List<List<List<Integer>>> temp) {
        if (root == null)
            return;
        temp.get(Math.abs(maxLeft) + index).get(height).add(root.val);
        solver(root.left, index - 1, height + 1, temp);
        solver(root.right, index + 1, height + 1, temp);
    }

    public int getWidthAndHeight(TreeNode root, int index) {
        if (root == null)
            return 0;
        int left = getWidthAndHeight(root.left, index - 1);
        int right = getWidthAndHeight(root.right, index + 1);
        maxLeft = Math.min(index, maxLeft);
        maxRight = Math.max(index, maxRight);
        return Math.max(left, right) + 1;
    }
}