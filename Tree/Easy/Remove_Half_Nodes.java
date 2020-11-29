/* 
Given A binary Tree.
 Your task is to remove all the half nodes (which has only one child).

Example 1:

Input:
         7
       /   \
      7     8
     / 
    2
Output: 2 7 8 
Example 2:

Input:
         2
       /   \
      7     5
       \      \
        9      1
       /  \
      11   4
Output: 1 6 11 2 4
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function removeHalfNodes() 
 which takes the root node of the tree as input and 
 returns the root node of the modified tree after removing all the half nodes,
  ie the ones having just a single child node.
   (The inorder traversal of the returned tree is printed by the driver's code.)
For example consider the below tree.


Nodes 7, 5 and 9 are half nodes as one of their child is Null. 
We need to remove all such half nodes and return the root pointer of following new tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Binary Tree).

Constraints:
1<=Number of nodes<=104





*/

// { Driver Code Starts
//Initial Template for Java

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

public class Remove_Half_Nodes {

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
            Tree13 g = new Tree13();
            Node fresh = g.RemoveHalfNodes(root);
            printInorder(fresh);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * 
 * class Node{ int data; Node left,right; Node(int d){ data=d; left=right=null;
 * } }
 * 
 */

class Tree13 {
    // Return the root of the modified tree after removing all the half nodes.
    public static Node RemoveHalfNodes(Node root) {
        root = removeHalfNodes(root);
        return root;
    }

    public static Node removeHalfNodes(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            return removeHalfNodes(root.right);
        } else if (root.right == null) {
            return removeHalfNodes(root.left);
        }
        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);

        return root;

    }

}


// ========================================
// 
//  GFG Editorial
// 
// ========================================


// Try building your tree bottom-up, 
// ie moving from the leaf nodes towards the root node to solve this problem efficiently.
// How about doing a post-order traversal of the tree for the same? 

// The idea is to use post-order traversal to solve this problem efficiently.
//  We first process the left children, then right children, and finally the node itself. 
//  So we form the new tree bottom up, starting from the leaves towards the root. 
//  By the time we process the current node,
//  both its left and right subtrees were already processed.


// class Tree
// {
    
//    // Removes all nodes with only one child and returns 
//     // new root (note that root may change) 
//     Node RemoveHalfNodes(Node node)  
//     { 
//         if (node == null) 
//             return null; 
   
//         node.left = RemoveHalfNodes(node.left); 
//         node.right = RemoveHalfNodes(node.right); 
   
//         if (node.left == null && node.right == null) 
//             return node; 
   
//         /* if current nodes is a half node with left 
//          child NULL left, then it's right child is 
//          returned and replaces it in the given tree */
//         if (node.left == null)  
//         { 
//             Node new_root = node.right; 
//             return new_root; 
//         } 
   
//         /* if current nodes is a half node with right 
//            child NULL right, then it's right child is 
//            returned and replaces it in the given tree  */
//         if (node.right == null)  
//         { 
//             Node new_root = node.left; 
//             return new_root; 
//         } 
   
//         return node; 
//     } 
   
// }
