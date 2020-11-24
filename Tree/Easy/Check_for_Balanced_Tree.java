/*
Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right 
subtrees is not more than one for all nodes of tree. 

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5

Example 1:

Input:
      1
    /
   2
    \
     3 
Output: 0
Explanation: The max difference in height
of left subtree and right subtree is 2,
which is greater than 1. Hence unbalanced
Example 2:

Input:
       10
     /   \
    20   30 
  /   \
 40   60
Output: 1
Explanation: The max difference in height
of left subtree and right subtree is 1.
Hence balanced. 
Your Task:
You don't need to take input. Just complete the function isBalanced()
 that takes root node as parameter and returns true, 
 if the tree is balanced else returns false.

Constraints:
1 <= Number of nodes <= 105
0 <= Data of a node <= 106

Expected time complexity: O(N)
Expected auxiliary space: O(h) , where h = height of tree
 */



// { Driver Code Starts
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

public class Check_for_Balanced_Tree {

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
            Tree6 g = new Tree6();

            if (g.isBalanced(root) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * A binary tree node class class Node { int data; Node left,right;
 * 
 * Node(int d) { data = d; left = right = null; } }
 */

class Tree6 {

    /*
     * This function should return tree if passed tree is balanced, else false.
     */
    boolean isBalanced(Node root) {
        if (!checkDiff(root))
            return false;

        return true;

    }

    boolean checkDiff(Node root) {
        if (root == null)
            return true;
        int a = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (a > 1)
            return false;

        return checkDiff(root.right) && checkDiff(root.left);

    }

    int getHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }
}


// =============================
//
// GFG Editorial
// 
// ============================


// To check if a tree is height-balanced,
//  get the height of left and right subtrees. 
//  Return true if difference between heights is not more than 1 
//  and left and right subtrees are balanced, otherwise return false.




// GFG Solution



// A wrapper class used to modify height across 
// recursive calls. 
// class Height { 
//     int height = 0; 
// } 

// class Tree
// { 
  
//     Node root; 
  
//     /* Returns true if binary tree with root as root is height-balanced */
//     boolean isBalancedUtil(Node root, Height height) 
//     { 
//         /* If tree is empty then return true */
//         if (root == null) { 
//             height.height = 0; 
//             return true; 
//         } 
  
//         /* Get heights of left and right sub trees */
//         Height lheight = new Height(), rheight = new Height(); 
//         boolean l = isBalancedUtil(root.left, lheight); 
//         boolean r = isBalancedUtil(root.right, rheight); 
//         int lh = lheight.height, rh = rheight.height; 
  
//         /* Height of current node is max of heights of 
//            left and right subtrees plus 1*/
//         height.height = (lh > rh ? lh : rh) + 1; 
  
//         /* If difference between heights of left and right 
//            subtrees is more than 2 then this node is not balanced 
//            so return 0 */
//         if (Math.abs(lh -rh) >= 2) 
//             return false; 
  
//         /* If this node is balanced and left and right subtrees 
//            are balanced then return true */
//         else
//             return l && r; 
//     }
    
//     boolean isBalanced(Node root)
//         {
//              Height height = new Height(); 
//             return isBalancedUtil(root,height);
//         }
    
    
// }    