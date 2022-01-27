
/**
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 * Accepted
 * 339,761
 * Submissions
 * 680,342
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 * Problems
 * 
 * Pick
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
    int count = 0;
    Map<Integer, Integer> hm = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        hm.put(0, 1);
        solver(root, 0, targetSum);
        return count;
    }

    public void solver(TreeNode root, int temp, int targetSum) {
        if (root == null)
            return;
        temp += root.val;
        count += hm.getOrDefault(temp - targetSum, 0);
        hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        solver(root.left, temp, targetSum);
        solver(root.right, temp, targetSum);
        hm.put(temp, hm.get(temp) - 1);
    }
}