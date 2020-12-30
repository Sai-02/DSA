
/*
Given a binary tree, your task is to complete the function findRightSibling(), that should return the right sibling to a given node if it doesn’t exist return null.

Structure of the node of the binary tree is as
struct Node
{
    int data;
    Node* left;
    Node* right;
    Node* parent;
};
Examples:

             1
            / \
           2   3
          /  \  \
         4    6  5
        /      \  \
       7        9  8
       /         \
      10         12
Input : Given above tree with parent pointer and node 10
Output : 12
Input:
The function takes a single argument as input,
 the reference pointer to the node whose right sibling is to be found 
 in the provided binary tree.
There will be T, test cases and for each test case, 
the function will be called separately.

Output:
For each test case return the pointer to the right sibling of a given node.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
10
1 2 L 1 3 R 2 4 L 2 6 R 4 7 L 7 10 L 6 9 R 9 12 R 3 5 R 5 8 R
7
2
1 2 L 1 3 R
2
Output:
9
3
 */
// { Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.HashSet;
import java.lang.Math;

class Node {
    int data;
    Node left, right, parent;

    Node(int d) {
        data = d;
        left = right = parent = null;
    }

    Node() {
    }
}

public class Right_Sibling_in_Binary_Tree {
    public static Node node, prev;

    public static void inorder(Node root, int key) {
        if (root == null)
            return;
        inorder(root.left, key);
        if (root.data == key)
            node = root;
        inorder(root.right, key);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Right_Sibling_in_Binary_Tree llist = new Right_Sibling_in_Binary_Tree();
            Node root = null, parent1 = null;
            HashMap<Integer, Node> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                char c = sc.next().charAt(0);
                if (m.containsKey(a) == false) {
                    parent1 = new Node(a);
                    m.put(a, parent1);
                    if (root == null)
                        root = parent1;
                } else
                    parent1 = m.get(a);
                Node child = new Node(b);
                if (c == 'L') {
                    parent1.left = child;
                    child.parent = parent1;
                } else {
                    parent1.right = child;
                    child.parent = parent1;
                }
                m.put(b, child);
            }
            int key = sc.nextInt();
            llist.inorder(root, key);
            llist.node = node;
            GFG obj = new GFG();
            Node ans = obj.findRightSibling(llist.node);
            if (ans != null)
                System.out.println(ans.data);
            else
                System.out.println("-1");
        }
    }
}// } Driver Code Ends

/*
 * class Node { int data; Node left, right,parent;
 * 
 * Node(int d) { data = d; left = right =parent= null; } }
 */

// function should return the right sibling of the given node.
class GFG {
    public static Node findRightSibling(Node node) {
        if (node.parent == null || node == null) {
            return null;
        }
        Node parent = node.parent;
        while (parent.parent != null) {
            parent = parent.parent;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(parent);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.peek() == null) {
                    return null;
                }
                q.add(null);
            } else {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (temp == node) {
                return q.peek();
            }
        }
        return null;

    }
}