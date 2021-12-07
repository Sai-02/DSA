/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode serializes
 * a binary tree. You do not necessarily need to follow this format, so please
 * be creative and come up with different approaches yourself.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * Example 3:
 * 
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 * 
 * Input: root = [1,2]
 * Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 * Accepted
 * 530,499
 * Submissions
 * 1,011,885
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        getSerializedString(root, sb);
        return sb.toString();
    }

    public void getSerializedString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        getSerializedString(root.left, sb);
        getSerializedString(root.right, sb);

    }

    // Decodes your encoded data to tree.
    int index = 0;

    public TreeNode deserialize(String data) {
        String dataArray[] = data.split(",");
        return getDeserialize(dataArray);
    }

    public TreeNode getDeserialize(String dataArray[]) {
        if (index > dataArray.length || dataArray[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataArray[index++]));
        node.left = getDeserialize(dataArray);
        node.right = getDeserialize(dataArray);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));