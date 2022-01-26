/**
 * Given a Binary Tree find the length of the longest path which comprises of
 * connected nodes with consecutive values in increasing order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input :
 * 1
 * / \
 * 2 3
 * 
 * Output: 2
 * 
 * Explanation : Longest sequence is 1, 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input :
 * 10
 * / \
 * 20 30
 * / \ /
 * 40 60 90
 * 
 * Output : -1
 * 
 * Explanation: For the above test case no
 * sequence is possible. So output is -1.
 * 
 * 
 * Your Task:
 * You dont need to read input or print anything. Complete the function
 * longestConsecutive() which takes root node as input parameter and returns the
 * length of the longest consecutive increasing sequence (of at least length 2)
 * in the given Binary Tree. If such a sequence does not exist, return -1.
 * 
 * 
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(Height of Tree)
 * 
 * 
 * Constraints:
 * 1 ≤ N ≤ 10^3
 */

class Solution {
    int ans = -1;

    public int longestConsecutive(Node root) {
        solver(root, null, 1);
        if (ans == 1)
            return -1;
        return ans;
    }

    public void solver(Node root, Node prev, int count) {
        if (root == null)
            return;
        if (prev != null) {
            if (prev.data + 1 == root.data) {
                count++;
                ans = Math.max(ans, count);
            } else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        solver(root.right, root, count);
        solver(root.left, root, count);
    }
}
