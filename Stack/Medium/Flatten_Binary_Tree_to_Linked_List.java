
/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * 
 * The "linked list" should use the same TreeNode class where the right child
 * pointer points to the next node in the list and the left child pointer is
 * always null. The "linked list" should be in the same order as a pre-order
 * traversal of the binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,5,3,4,null,6] Output:
 * [1,null,2,null,3,null,4,null,5,null,6] Example 2:
 * 
 * Input: root = [] Output: [] Example 3:
 * 
 * Input: root = [0] Output: [0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000]. -100 <= Node.val
 * <= 100
 * 
 * 
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 * Accepted 531,990 Submissions 950,858
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

// ============================================================
//
// Inefficient solution
//
// =============================================================

class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> a = getPreOrder(root);
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode temp = dummyNode;
        for (Integer val : a) {
            TreeNode newNode = new TreeNode(val);
            temp.right = newNode;
            temp = temp.right;
        }
        // root=dummyNode.right;
        root.left = null;
        root.right = dummyNode.right.right;
    }

    public ArrayList<Integer> getPreOrder(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<>();
        if (root == null)
            return a;
        a.add(root.val);
        a.addAll(getPreOrder(root.left));
        a.addAll(getPreOrder(root.right));
        return a;
    }
}

// =============================================================================
//
// Solution using stack Space:O(n) Time:O(1)
//
// ===============================================================================

class Solution2 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode prev = null;
        Stack<Pair> st = new Stack<>();
        Pair rootPair = new Pair(root, 1);
        st.push(rootPair);
        while (!st.isEmpty()) {
            Pair pair = st.pop();
            if (pair.state == 1) {
                pair.state++;
                st.push(pair);
                if (pair.root.right != null) {
                    Pair newPair = new Pair(pair.root.right, 1);
                    st.push(newPair);
                }

            } else if (pair.state == 2) {
                pair.state++;
                st.push(pair);
                if (pair.root.left != null) {
                    Pair newPair = new Pair(pair.root.left, 1);
                    st.push(newPair);
                }
            } else {
                pair.root.left = null;
                pair.root.right = prev;
                prev = pair.root;
            }
        }

    }
}

class Pair {
    TreeNode root;
    int state;

    Pair(TreeNode root, int state) {
        this.root = root;
        this.state = state;
    }
}

// =====================================================================
//
// Solution using recursion Stack space:O(n) Time:O(1)
//
// =======================================================================

class Solution3 {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;

    }
}

// ============================================================================
// 
// Most optimized solution using Morris traversal
// 
// =============================================================================