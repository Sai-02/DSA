
/**
 * You are given the root of a binary tree and a positive integer k.
 * 
 * The level sum in the tree is the sum of the values of the nodes that are on
 * the same level.
 * 
 * Return the kth largest level sum in the tree (not necessarily distinct). If
 * there are fewer than k levels in the tree, return -1.
 * 
 * Note that two nodes are on the same level if they have the same distance from
 * the root.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,8,9,2,1,3,7,4,6], k = 2
 * Output: 13
 * Explanation: The level sums are the following:
 * - Level 1: 5.
 * - Level 2: 8 + 9 = 17.
 * - Level 3: 2 + 1 + 3 + 7 = 13.
 * - Level 4: 4 + 6 = 10.
 * The 2nd largest level sum is 13.
 * Example 2:
 * 
 * 
 * Input: root = [1,2,null,3], k = 1
 * Output: 3
 * Explanation: The largest level sum is 3.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is n.
 * 2 <= n <= 105
 * 1 <= Node.val <= 106
 * 1 <= k <= n
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode right, left;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    class Pair implements Comparable<Pair> {
        int level;
        long sum;

        Pair(int level, long sum) {
            this.level = level;
            this.sum = sum;
        }

        public int compareTo(Pair o) {
            if (this.sum > o.sum)
                return 1;
            return -1;

        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            long sum = 0;
            int count = q.size();
            while (count-- > 0) {
                TreeNode node = q.remove();
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            pq.add(new Pair(level, sum));
            if (pq.size() > k)
                pq.remove();
        }
        if (pq.size() < k)
            return -1;
        return pq.remove().sum;
    }
}