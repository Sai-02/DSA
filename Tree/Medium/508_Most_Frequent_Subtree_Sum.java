
/**
 * Given the root of a binary tree, return the most frequent subtree sum. If
 * there is a tie, return all the values with the highest frequency in any
 * order.
 * 
 * The subtree sum of a node is defined as the sum of all the node values formed
 * by the subtree rooted at that node (including the node itself).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,2,-3]
 * Output: [2,-3,4]
 * Example 2:
 * 
 * 
 * Input: root = [5,2,-5]
 * Output: [2]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
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
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = getSum(root, hm);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int key : hm.keySet()) {
            if (hm.get(key) == maxFreq)
                ans.add(key);
        }
        int a[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            a[i] = ans.get(i);
        return a;
    }

    public int getSum(TreeNode root, HashMap<Integer, Integer> hm) {
        if (root == null)
            return 0;
        int sum = root.val + getSum(root.left, hm) + getSum(root.right, hm);
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, hm.get(sum));
        return sum;
    }
}