
/**
 * You are given an integer array nums with no duplicates. A maximum binary tree
 * can be built recursively from nums using the following algorithm:
 * 
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the
 * maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of
 * the maximum value.
 * Return the maximum binary tree built from nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,2,1,6,0,5]
 * Output: [6,3,5,null,2,0,null,null,1]
 * Explanation: The recursive calls are as follow:
 * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right
 * suffix is [0,5].
 * - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is
 * [2,1].
 * - Empty array, so no child.
 * - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
 * - Empty array, so no child.
 * - Only one element, so child is a node with value 1.
 * - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
 * - Only one element, so child is a node with value 0.
 * - Empty array, so no child.
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1]
 * Output: [3,null,2,null,1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * All integers in nums are unique.
 * Accepted
 * 192,836
 * Submissions
 * 232,716
 */
import java.util.Stack;
// ===============================================
//
// Recursive Solution O(nlogn)
//
// ================================================

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getTree(0, nums.length - 1, nums);
    }

    public TreeNode getTree(int l, int r, int[] nums) {
        if (l > r)
            return null;
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = l; i <= r; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                maxIndex = i;
            }

        }
        TreeNode root = new TreeNode(maxVal);
        root.left = getTree(l, maxIndex - 1, nums);
        root.right = getTree(maxIndex + 1, r, nums);
        return root;
    }
}
// ===================================
//
// Solution using Stack O(n)
//
// ====================================

class Solution1 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> st = new Stack<>();
        for (int val : nums) {
            TreeNode root = new TreeNode(val);
            while (!st.empty() && st.peek().val < root.val) {
                root.left = st.pop();
            }
            if (!st.empty()) {
                st.peek().right = root;
            }
            st.push(root);
        }
        TreeNode prev = null;
        while (!st.empty()) {
            prev = st.pop();
        }
        return prev;
    }
}