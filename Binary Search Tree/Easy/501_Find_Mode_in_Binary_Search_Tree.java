
/**
 * Given the root of a binary search tree (BST) with duplicates, return all the
 * mode(s) (i.e., the most frequently occurred element) in it.
 * 
 * If the tree has more than one mode, return them in any order.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 * 
 * Input: root = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 * 
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
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
    TreeNode prev = null;
    int count = 0, maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[1];
        getMostFreqCount(root);
        if (maxCount < count) {
            maxCount = count;
        }
        prev = null;
        count = 0;
        ArrayList<Integer> a = new ArrayList<>();
        getMostFreqNodes(root, a);
        if (maxCount == count) {
            a.add(prev.val);
        }
        int ans[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++)
            ans[i] = a.get(i);
        return ans;
    }

    public void getMostFreqCount(TreeNode root) {
        if (root == null)
            return;
        getMostFreqCount(root.left);
        if (prev != null && root.val == prev.val) {
            count++;
        } else {
            if (maxCount < count) {
                maxCount = count;
            }
            count = 1;
            prev = root;
        }
        getMostFreqCount(root.right);
    }

    public void getMostFreqNodes(TreeNode root, ArrayList<Integer> a) {
        if (root == null)
            return;
        getMostFreqNodes(root.left, a);
        if (prev != null && root.val == prev.val) {
            count++;
        } else {
            if (maxCount == count) {
                a.add(prev.val);
            }
            count = 1;
            prev = root;
        }
        getMostFreqNodes(root.right, a);
    }
}