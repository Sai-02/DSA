
/**
 * You are given the root of a binary tree and an integer distance. A pair of
 * two different leaf nodes of a binary tree is said to be good if the length of
 * the shortest path between them is less than or equal to distance.
 * 
 * Return the number of good leaf node pairs in the tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,4], distance = 3
 * Output: 1
 * Explanation: The leaf nodes of the tree are 3 and 4 and the length of the
 * shortest path between them is 3. This is the only good pair.
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], distance = 3
 * Output: 2
 * Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The
 * pair [4,6] is not good because the length of ther shortest path between them
 * is 4.
 * Example 3:
 * 
 * Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * Output: 1
 * Explanation: The only good pair is [2,5].
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 210].
 * 1 <= Node.val <= 100
 * 1 <= distance <= 10
 * Accepted
 * 24,456
 * Submissions
 * 41,038
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
    public int countPairs(TreeNode root, int distance) {
        int count[] = new int[1];
        solver(root, count, distance);
        return count[0];
    }

    public ArrayList<Integer> solver(TreeNode root, int count[], int distance) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        if (root.left == null && root.right == null) {
            ans.add(1);
            return ans;
        }
        ArrayList<Integer> left = solver(root.left, count, distance);
        ArrayList<Integer> right = solver(root.right, count, distance);
        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance)
                    count[0]++;
            }
            if (l + 1 < distance)
                ans.add(l + 1);
        }
        for (int r : right) {
            if (r + 1 < distance)
                ans.add(r + 1);
        }
        return ans;
    }
}