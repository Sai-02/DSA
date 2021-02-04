
/*
Given a Binary Search Tree and a node value X.
 Delete the node with the given value X from the BST. 
 If no node with value x exists, then do not make any change. 

Example 1:

Input:
      2
    /   \
   1     3
X = 12
Output: 1 2 3
Explanation: In the given input there
is no node with value 12 , so the tree
will remain same.
Example 2:

Input:
            1
             \
              2
                \
                 8 
               /    \
              5      11
            /  \    /  \
           4    7  9   12
X = 9
Output: 1 2 4 5 7 8 11 12
Explanation: In the given input tree after
deleting 9 will be
             1
              \
               2
                 \
                  8
                 /   \
                5     11
               /  \     \
              4    7     12
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function deleteNode()
  which takes two arguments. The first being the root of the tree,
   and an integer 'X' denoting the node value to be deleted from the BST.
    Return the root of the BST after deleting the node with value X.
     Do not make any update if there's no node with value X present in the BST.

Note: The generated output will be the inorder traversal of the modified tree.
 

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).
 

Constraints:
1 <= N <= 105
 */

// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Delete_a_node_from_BST {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            Node root = buildTree(s);
            Tree2 g = new Tree2();
            root = g.deleteNode(root, x);
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * Structure of a Node is as follows:- class Node{ int data; Node left; Node
 * right; Node(int data){ this.data = data; left=null; right=null; } }
 */

class Tree2 {
    // Return the root of the modified BST after deleting the node with value X
    public static Node deleteNode(Node root, int X) {
        return solver(root, X);
    }

    public static Node solver(Node root, int X) {
        if (root == null) {
            return null;
        }
        if (root.data < X) {
            root.left = solver(root.left, X);
        } else if (root.data > X) {
            root.right = solver(root.right, X);

        } else {
            if (root.left == null) {

                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = findMin(root.right);
                root.right = solver(root.right, root.data);
            }

        }
        return root;
    }

    public static int findMin(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
}



// ======================================
// 
//  GFG Editorial
// 
// ======================================


// 1. You need to take care of three possibilities:

// Node to be deleted is leaf
// Node to be deleted has only one child
// Node to be deleted has two children


// 2.

// Node to be deleted is leaf: Simply remove from the tree.
// Node to be deleted has only one child: Copy the child to the node and delete the child
// Node to be deleted has two children: Find inorder successor of the node.
//  Copy contents of the inorder successor to the node and delete the inorder successor.
//  Note that inorder predecessor can also be used.


// class Tree
// {
// public static Node minimumElement(Node root) {
// 		if (root.left == null)
// 			return root;
// 		else {
// 			return minimumElement(root.left);
// 		}
// 	}
 
// 	public static Node deleteNode(Node root, int value) {
// 		if (root == null)
// 			return null;
// 		if (root.data > value) {
// 			root.left = deleteNode(root.left, value);
// 		} else if (root.data < value) {
// 			root.right = deleteNode(root.right, value);
 
// 		} else {
// 			// if nodeToBeDeleted have both children
// 			if (root.left != null && root.right != null) {
// 				Node temp = root;
// 				// Finding minimum element from right
// 				Node minNodeForRight = minimumElement(temp.right);
// 				// Replacing current node with minimum node from right subtree
// 				root.data = minNodeForRight.data;
// 				// Deleting minimum node from right now
// 				root.right = deleteNode(root.right, minNodeForRight.data);
 
// 			}
// 			// if nodeToBeDeleted has only left child
// 			else if (root.left != null) {
// 				root = root.left;
// 			}
// 			// if nodeToBeDeleted has only right child
// 			else if (root.right != null) {
// 				root = root.right;
// 			}
// 			// if nodeToBeDeleted do not have child (Leaf node)
// 			else
// 				root = null;
// 		}
// 		return root;
// 	}
// }	
