
/*

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

public class Check_for_BST {

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
            Tree1 g = new Tree1();
            if (g.isBST(root))
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
 * Structure of Node: class Node{ int data; Node left; Node right; Node(int
 * data){ this.data = data; left=null; right=null; } }
 */

class Tree1 {
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root) {
        return solver(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean solver(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (min < root.data && root.data < max) {
            return solver(root.left, min, root.data) && solver(root.right, root.data, max);
        }
        return false;
    }
}

// =========================================
// 
//  GFG Editorial
// 
// =========================================



// The trick is to write a utility helper function 
// isBSTUtil(struct node* node, int min, int max) that traverses
//  down the tree keeping track of the narrowing min and max allowed values as it goes,
//   looking at each node only once. The initial values for
//    min and max should be INT_MIN and INT_MAX — they narrow from there.

// /* Returns true if the given tree is a binary search tree 
//  (efficient version). */ 
// int isBST(struct node* node) 
// { 
//   return(isBSTUtil(node, INT_MIN, INT_MAX)); 
// } 

// /* Returns true if the given tree is a BST and its 
//  values are >= min and <= max. */ 
// int isBSTUtil(struct node* node, int min, int max) 
// The time complexity for this will be O(N) 
// as we need to check it for all the nodes whether they lie in the correct range or not.
// Whereas, the auxiliary space we used for recursion
//  in O(height) as we make the right subtree call only 
//  when the left subtree has been checked.


// public class Tree
// {
//     //Root of the Binary Tree 
//     Node root; 
  
//     /* can give min and max value according to your code or 
//     can write a function to find min and max value of tree. */
  
//     /* returns true if given search tree is binary 
//      search tree (efficient version) */
//     boolean isBST(Node root)  { 
//         return isBSTUtil(root, Integer.MIN_VALUE, 
//                                Integer.MAX_VALUE); 
//     } 
  
//     /* Returns true if the given tree is a BST and its 
//       values are >= min and <= max. */
//     boolean isBSTUtil(Node node, int min, int max) 
//     { 
//         /* an empty tree is BST */
//         if (node == null) 
//             return true; 
  
//         /* false if this node violates the min/max constraints */
//         if (node.data < min || node.data > max) 
//             return false; 
  
//         /* otherwise check the subtrees recursively 
//         tightening the min/max constraints */
//         // Allow only distinct values 
//         return (isBSTUtil(node.left, min, node.data-1) && 
//                 isBSTUtil(node.right, node.data+1, max)); 
//     } 
// }
