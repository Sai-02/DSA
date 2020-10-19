/*
Given a Binary Tree of size N, your task is to complete the function countNonLeafNodes(),
 that should return the count of all the non-leaf nodes of the given binary tree.
Example:

Input : 
Image
Output :
2
Input:
The function takes a single arguments as input, 
the reference pointer to the root of the binary tree.
There are T test cases and for each test case the function will be called separately.

Output:
The function should return the count of all the non-leaf nodes of the binary tree.

Constraints:
1<=T<=103
0<=N<=103

Example:
Input:
2
2
1 2 L 1 3 R
5
10 20 L 10 30 R 20 40 L 20 60 R 30 90 L
Output:
1
3

 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Count_Non_Leaf_Nodes_in_Tree {
    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Count_Non_Leaf_Nodes_in_Tree llist = new Count_Non_Leaf_Nodes_in_Tree();
            Node root = null, parent = null;
            HashMap<Integer, Node> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                char c = sc.next().charAt(0);
                if (m.containsKey(a) == false) {
                    parent = new Node(a);
                    m.put(a, parent);
                    if (root == null)
                        root = parent;
                } else
                    parent = m.get(a);
                Node child = new Node(b);
                if (c == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(b, child);
            }
            GFG obj = new GFG();
            int p = obj.countNonLeafNodes(root);
            System.out.println(p);
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left,right; Node(int d){ data=d; left=right=null;
 * } }
 */

// function should return the count of total number of non leaf nodes in the
// tree.
class GFG {
    int countNonLeafNodes(Node root) {

        if (root == null || (root.right == null && root.left == null)) {
            return 0;

        }
        return 1 + countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
    }

}