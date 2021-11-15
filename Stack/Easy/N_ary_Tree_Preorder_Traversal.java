
/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6] Output: [1,3,5,6,2,4] Example 2:
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104]. 0 <= Node.val <=
 * 104 The height of the n-ary tree is less than or equal to 1000.
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * Accepted 194,534 Submissions 258,566 Seen this question in a real interview
 * before?
 * 
 * Yes
 * 
 * No
 * 
 */
import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
// =================================================================
//
// Recursive Solution
//
// ==================================================================

class Solution12 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ans.add(root.val);
        for (Node child : root.children) {
            ans.addAll(preorder(child));
        }
        return ans;
    }
}

// ==============================================================
//
// Iterative Solution
//
// ==============================================================

class Solution13 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            Node node = nodeStack.pop();
            ans.add(node.val);
            Stack<Node> s = new Stack<>();
            for (Node child : node.children) {
                s.push(child);
            }
            while (!s.empty()) {
                nodeStack.push(s.pop());
            }
        }
        return ans;

    }
}
