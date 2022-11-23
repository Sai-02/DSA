
/**
 * You are given the root of a binary search tree and an array queries of size n
 * consisting of positive integers.
 * 
 * Find a 2D array answer of size n where answer[i] = [mini, maxi]:
 * 
 * mini is the largest value in the tree that is smaller than or equal to
 * queries[i]. If a such value does not exist, add -1 instead.
 * maxi is the smallest value in the tree that is greater than or equal to
 * queries[i]. If a such value does not exist, add -1 instead.
 * Return the array answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries =
 * [2,5,16]
 * Output: [[2,2],[4,6],[15,-1]]
 * Explanation: We answer the queries in the following way:
 * - The largest number that is smaller or equal than 2 in the tree is 2, and
 * the smallest number that is greater or equal than 2 is still 2. So the answer
 * for the first query is [2,2].
 * - The largest number that is smaller or equal than 5 in the tree is 4, and
 * the smallest number that is greater or equal than 5 is 6. So the answer for
 * the second query is [4,6].
 * - The largest number that is smaller or equal than 16 in the tree is 15, and
 * the smallest number that is greater or equal than 16 does not exist. So the
 * answer for the third query is [15,-1].
 * Example 2:
 * 
 * 
 * Input: root = [4,null,9], queries = [3]
 * Output: [[-1,4]]
 * Explanation: The largest number that is smaller or equal to 3 in the tree
 * does not exist, and the smallest number that is greater or equal to 3 is 4.
 * So the answer for the query is [-1,4].
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 105].
 * 1 <= Node.val <= 106
 * n == queries.length
 * 1 <= n <= 105
 * 1 <= queries[i] <= 106
 * Accepted
 * 11,136
 * Submissions
 * 27,681
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
    ArrayList<Integer> a = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        inOrder(root);
        for (int val : queries) {
            int max = getMax(val);
            int min = getMin(val);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(max);
            list.add(min);
            ans.add(list);
        }
        return ans;
    }

    public int getMax(int val) {
        int l = 0, r = a.size() - 1;
        int max = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a.get(mid) == val)
                return val;
            if (a.get(mid) > val) {
                r = mid - 1;
            } else {
                max = Math.max(max, a.get(mid));
                l = mid + 1;
            }
        }
        return max;
    }

    public int getMin(int val) {
        int l = 0, r = a.size() - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a.get(mid) == val)
                return val;
            if (a.get(mid) > val) {
                r = mid - 1;
                min = Math.min(min, a.get(mid));
            } else {
                l = mid + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        a.add(root.val);
        inOrder(root.right);
    }
}

// ================================================================
//
// Note: In this question we have not directly search the BST as BST can be
// unbalanced also so searching might take O(n2) per query so we are storing all
// elements in the form sorted array
//
// ===============================================================