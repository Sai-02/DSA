
/**
 * A complete binary tree is a binary tree in which every level, except possibly
 * the last, is completely filled, and all nodes are as far left as possible.
 * 
 * Design an algorithm to insert a new node to a complete binary tree keeping it
 * complete after the insertion.
 * 
 * Implement the CBTInserter class:
 * 
 * CBTInserter(TreeNode root) Initializes the data structure with the root of
 * the complete binary tree.
 * int insert(int v) Inserts a TreeNode into the tree with value Node.val == val
 * so that the tree remains complete, and returns the value of the parent of the
 * inserted TreeNode.
 * TreeNode get_root() Returns the root node of the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * Output
 * [null, 1, 2, [1, 2, 3, 4]]
 * 
 * Explanation
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3); // return 1
 * cBTInserter.insert(4); // return 2
 * cBTInserter.get_root(); // return [1, 2, 3, 4]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree will be in the range [1, 1000].
 * 0 <= Node.val <= 5000
 * root is a complete binary tree.
 * 0 <= val <= 5000
 * At most 104 calls will be made to insert and get_root.
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

class CBTInserter {
    TreeNode root;
    Queue<TreeNode> q = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            if (node.left != null) {
                q.add(node.left);
            } else
                break;
            if (node.right != null) {
                q.add(node.right);
            } else
                break;
            q.remove();
        }
    }

    public int insert(int val) {
        TreeNode ans = q.peek();
        TreeNode newNode = new TreeNode(val);
        q.add(newNode);
        if (ans.left == null) {
            ans.left = newNode;
        } else {
            ans.right = newNode;
            q.remove();
        }
        return ans.val;

    }

    public TreeNode get_root() {
        return root;
    }
}
