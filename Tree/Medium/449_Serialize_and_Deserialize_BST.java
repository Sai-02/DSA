
/**
 * Serialization is converting a data structure or object into a sequence of
 * bits so that it can be stored in a file or memory buffer, or transmitted
 * across a network connection link to be reconstructed later in the same or
 * another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You need to ensure that a binary search tree can be serialized to a
 * string, and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The input tree is guaranteed to be a binary search tree.
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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        getSerializedTree(root, sb);
        return sb.toString();
    }

    private void getSerializedTree(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val + ",");
        getSerializedTree(root.left, sb);
        getSerializedTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return getDeserializedTree(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode getDeserializedTree(Queue<String> q, int low, int high) {
        if (q.isEmpty())
            return null;
        int val = Integer.parseInt(q.peek());
        if (val < low || val > high)
            return null;
        TreeNode node = new TreeNode(val);
        q.remove();
        node.left = getDeserializedTree(q, low, val);
        node.right = getDeserializedTree(q, val, high);
        return node;
    }
}