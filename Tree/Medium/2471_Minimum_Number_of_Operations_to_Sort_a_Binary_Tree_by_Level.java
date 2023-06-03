
/**
 * You are given the root of a binary tree with unique values.
 * 
 * In one operation, you can choose any two nodes at the same level and swap
 * their values.
 * 
 * Return the minimum number of operations needed to make the values at each
 * level sorted in a strictly increasing order.
 * 
 * The level of a node is the number of edges along the path between it and the
 * root node.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
 * Output: 3
 * Explanation:
 * - Swap 4 and 3. The 2nd level becomes [3,4].
 * - Swap 7 and 5. The 3rd level becomes [5,6,8,7].
 * - Swap 8 and 7. The 3rd level becomes [5,6,7,8].
 * We used 3 operations so return 3.
 * It can be proven that 3 is the minimum number of operations needed.
 * Example 2:
 * 
 * 
 * Input: root = [1,3,2,7,6,5,4]
 * Output: 3
 * Explanation:
 * - Swap 3 and 2. The 2nd level becomes [2,3].
 * - Swap 7 and 4. The 3rd level becomes [4,6,5,7].
 * - Swap 6 and 5. The 3rd level becomes [4,5,6,7].
 * We used 3 operations so return 3.
 * It can be proven that 3 is the minimum number of operations needed.
 * Example 3:
 * 
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: 0
 * Explanation: Each level is already sorted in increasing order so return 0.
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
 * All the values of the tree are unique.
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
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            ArrayList<Integer> a = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.remove();
                a.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            ans += getMinSwapsToSort(a);
        }
        return ans;

    }

    class Pair {
        int val, index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int getMinSwapsToSort(ArrayList<Integer> a) {
        int swaps = 0;
        Pair pairs[] = new Pair[a.size()];
        for (int i = 0; i < a.size(); i++) {
            pairs[i] = new Pair(a.get(i), i);
        }
        Arrays.sort(pairs, (ab, b) -> {
            return ab.val - b.val;
        });
        boolean visited[] = new boolean[a.size()];
        for (int i = 0; i < pairs.length; i++) {
            int cycleCount = 0;
            if (!visited[i] && !(pairs[i].index == i)) {
                int node = i;
                while (!visited[node]) {
                    visited[node] = true;
                    node = pairs[node].index;
                    cycleCount++;
                }
            }
            swaps += (cycleCount > 0 ? cycleCount - 1 : 0);
        }
        return swaps;
    }
}