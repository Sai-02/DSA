
/*
Given a Binary Tree. Check whether it is Symmetric or not,
 i.e. whether the binary tree is a Mirror image of itself or not.

Example 1:

Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: True
Explanation: Tree is mirror image of
itself i.e. tree is symmetric
Example 2:

Input:
         5
       /   \
      10     10
     /  \     \
    20  20     30
Output: False
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function isMirror()
 which takes the root of the Binary Tree as
  its input and returns True 
  if the given Binary Tree is a same as the Mirror image of itself. 
  Else, it returns False.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=Number of nodes<=100
 */

//{
// Driver Code Starts
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

public class Symmetric_Tree {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            GfG14 g = new GfG14();
            if (g.isSymmetric(root) == true)
                System.out.println("True");
            else
                System.out.println("False");

            t--;

        }
    }
}

// } Driver Code Ends

/*
 * class of the node of the tree is as class Node{ int data; Node left; Node
 * right; Node(int data){ this.data = data; left=null; right=null; } }
 * 
 */
// complete this function
// return true/false if the is Symmetric or not
class GfG14 {
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        }

        return (root1.data == root2.data) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);

    }
}


// ==============================
// 
//  GFG Editorial
// 
// ==============================

// Maintain two Node pointers in the tree.
// If the first moves right, the other moves left.
// If the first moves left, the other moves right.

// And, for every pair of node we get through the above traversal, we check the following:
// if node1 is NULL and node2 is not NULL: The tree is not symmetric, return False.
// If node1 is not NULL and node2 is NULL: The tree is not symmetric, return False.
// If both node1 and node2 are NULL: Return True.
// If both node1 and node2 are not NULL: Return ((node->data == node2->data) && (isSymm (node1->left, node2->right) && (isSymm (node1->right, node2->left))


// class GfG
// {
  
   
//     // returns true if trees with roots as root1 and root2 are mirror 
//     public boolean isMirror(Node node1, Node node2)  
//     { 
//         // if both trees are empty, then they are mirror image 
//         if (node1 == null && node2 == null) 
//             return true; 
   
//         // For two trees to be mirror images, the following three 
//         // conditions must be true 
//         // 1 - Their root node's key must be same 
//         // 2 - left subtree of left tree and right subtree 
//         //      of right tree have to be mirror images 
//         // 3 - right subtree of left tree and left subtree 
//         //      of right tree have to be mirror images 
//         if (node1 != null && node2 != null && node1.data == node2.data) 
//             return (isMirror(node1.left, node2.right) 
//                     && isMirror(node1.right, node2.left)); 
   
//         // if neither of the above conditions is true then 
//         // root1 and root2 are mirror images 
//         return false; 
//     } 
   
//     // returns true if the tree is symmetric i.e 
//     // mirror image of itself 
//    public boolean isSymmetric(Node root)  
//     { 
//         // check if tree is mirror of itself 
//         return isMirror(root, root); 
//     } 
// }