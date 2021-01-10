/*
Given a binary tree, check if the tree can be folded or not.
 A tree can be folded if left and right subtrees of the tree are structure wise same.
  An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.


(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
 
Example 1:

Input:
     10
    /    \
   7     15
 /  \   /  \
N   9  11   N
Output:Yes
Example 2:

Input:
      10
    /    \
   7     15
 /  \   /  \
5   N  11   N
Output: No

Your Task:
The task is to complete the function isFoldable()
 that takes root of the tree as input and returns 
 true or false depending upon whether the tree is foldable or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 103
1 <= data of node <= 104
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

public class Foldable_Binary_Tree {

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
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree10 tr = new Tree10();
            boolean st = tr.IsFoldable(root);
            if (st == true) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * node class of the binary tree class Node { int data; Node left, right;
 * Node(int key) { data = key; left = right = null; } }
 */
class Tree10 {
    boolean IsFoldable(Node root) {
        if (root == null) {
            return true;
        }
        return solver(root.left, root.right);

    }

    boolean solver(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (checkLeaf(root1) && checkLeaf(root2)) {
            return true;
        }
        return (solver(root1.left, root2.right) && solver(root1.right, root2.left));

    }

    boolean checkLeaf(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}

// =========================================
// 
//  GFG Editorial
// 
// =========================================


// 1) If tree is empty, then return true.
// 2) Convert the left subtree to its mirror image
//     mirror(root->left); /* See this post */
// 3) Check if the structure of left subtree and right subtree is same
//    and store the result.
//     res = isStructSame(root->left, root->right); /*isStructSame()
//         recursively compares structures of two subtrees and returns
//         true if structures are same */
// 4) Revert the changes made in step (2) to get the original tree.
//     mirror(root->left);
// 5) Return result res stored in step 2.




// class Tree {
//     boolean IsFoldable(Node node) 
// 	{ 
// 		if (node == null) 
// 			return true; 

// 		return IsFoldableUtil(node.left, node.right); 
// 	} 

// 	/* A utility function that checks if trees with roots as n1 and n2 
// 	are mirror of each other */
// 	boolean IsFoldableUtil(Node n1, Node n2) 
// 	{ 

// 		/* If both left and right subtrees are NULL, 
// 		then return true */
// 		if (n1 == null && n2 == null) 
// 			return true; 

// 		/* If one of the trees is NULL and other is not, 
// 		then return false */
// 		if (n1 == null || n2 == null) 
// 			return false; 

// 		/* Otherwise check if left and right subtrees are mirrors of 
// 		their counterparts */
// 		return IsFoldableUtil(n1.left, n2.right) 
// 			&& IsFoldableUtil(n1.right, n2.left); 
// 	}
// }

