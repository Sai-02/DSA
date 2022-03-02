
/**
 * We run a preorder depth-first search (DFS) on the root of a binary tree.
 * 
 * At each node in this traversal, we output D dashes (where D is the depth of
 * this node), then we output the value of this node. If the depth of a node is
 * D, the depth of its immediate child is D + 1. The depth of the root node is
 * 0.
 * 
 * If a node has only one child, that child is guaranteed to be the left child.
 * 
 * Given the output traversal of this traversal, recover the tree and return its
 * root.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: traversal = "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * Example 2:
 * 
 * 
 * Input: traversal = "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 * Example 3:
 * 
 * 
 * Input: traversal = "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the original tree is in the range [1, 1000].
 * 1 <= Node.val <= 109
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Pair {
    int val, depth;

    Pair(int val, int depth) {
        this.val = val;
        this.depth = depth;
    }
}

class Solution {
    int i = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        ArrayList<Pair> nodes = decodeString(traversal);
        return getTree(nodes, -1);
    }

    public TreeNode getTree(ArrayList<Pair> nodes, int prevDepth) {
        if (i >= nodes.size() || prevDepth + 1 != nodes.get(i).depth)
            return null;
        TreeNode root = new TreeNode(nodes.get(i).val);
        i++;
        root.left = getTree(nodes, prevDepth + 1);
        root.right = getTree(nodes, prevDepth + 1);
        return root;
    }

    public ArrayList<Pair> decodeString(String traversal) {
        ArrayList<Pair> ans = new ArrayList<>();
        int depth = 0, val = 0, length = traversal.length(), i = 0;
        while (i < length) {
            char c = traversal.charAt(i);
            if (c == '-') {
                depth++;
                i++;
            } else {
                val = (val * 10) + (c - '0');
                i++;
                while (i < length && traversal.charAt(i) != '-') {
                    val = (val * 10) + (traversal.charAt(i) - '0');
                    i++;
                }
                ans.add(new Pair(val, depth));
                depth = 0;
                val = 0;
            }
        }
        return ans;

    }
}