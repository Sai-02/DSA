
/**
 * Medium
 * 
 * 1298
 * 
 * 54
 * 
 * Add to List
 * 
 * Share
 * Given the root of a binary tree, the level of its root is 1, the level of its
 * children is 2, and so on.
 * 
 * Return the smallest level x such that the sum of all the values of nodes at
 * level x is maximal.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 * 
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 * Accepted
 * 98,063
 * Submissions
 * 147,093
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
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> depthSums = new ArrayList<>();
        solver(root, 0, depthSums);
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < depthSums.size(); i++) {
            if (max < depthSums.get(i)) {
                max = depthSums.get(i);
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

    public void solver(TreeNode root, int depth, ArrayList<Integer> depthSums) {
        if (root == null)
            return;
        if (depthSums.size() <= depth)
            depthSums.add(root.val);
        else {
            depthSums.set(depth, depthSums.get(depth) + root.val);
        }
        solver(root.left, depth + 1, depthSums);
        solver(root.right, depth + 1, depthSums);
    }
}