/*
Given a Binary Tree, 
convert it to Binary Search Tree in such a way that keeps 
the original structure of Binary Tree intact.
 

Example 1:

Input:
      1
    /   \
   2     3
Output: 1 2 3

Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1
 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function binaryTreeToBST() 
 which takes the root of the Binary tree as input and returns the root of the BST. 
 The driver code will print inorder traversal of the converted BST.


Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).


Constraints:
1 <= Number of nodes <= 1000
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

public class Binary_Tree_to_BST  {

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
            GfG2 g = new GfG2();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Structure of the node class is class Node { int data; Node left, right;
 * Node(int item){ data = item; left = right = null; } }
 */

class GfG2 {
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    ArrayList<Integer> inOrder = new ArrayList<>();
    int index = 0;

    Node binaryTreeToBST(Node root) {
        inOrderTraversal(root);
        Collections.sort(inOrder);
        convertToBst(root);
        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrder.add(root.data);
        inOrderTraversal(root.right);
    }

    public void convertToBst(Node root) {
        if (root == null) {
            return;
        }
        convertToBst(root.left);
        root.data = inOrder.get(index++);
        convertToBst(root.right);

    }
}


// =================================
// 
// GFG Editorial
// 
// =================================


// The inorder traversal of a BST generates the node values in a sorted order.
//  Can you use this fact to get to the result?


// How about storing the node values of the given binary tree into an array
//  and then sorting the values?
// This will basically give us the inorder traversal of the required BST.
//  Can you generate the BST from its inorder traversal?


// class index
// {
//     int x = 0;
// }
// class GfG
// {
//     void arrayToBST(int arr[], Node root, index index_ptr)
//     {
//         if(root == null)
//             return ;
        
//         arrayToBST(arr, root.left, index_ptr);
//         root.data = arr[index_ptr.x];
//         index_ptr.x++;
//         arrayToBST(arr, root.right, index_ptr);
//     }
//     void storeInorder(Node node, int inorder[], index index_ptr)
//     {
//         //int index_ptr = 0;
//         if(node == null)
//             return ;
        
//         storeInorder(node.left, inorder, index_ptr);
//         inorder[index_ptr.x] = node.data;
//         index_ptr.x++;
//         storeInorder(node.right, inorder, index_ptr);
//     }
//     int countNodes(Node root)
//     {
//         if(root == null)
//             return 0;
//         return countNodes(root.left) + countNodes(root.right)+1;
//     }
//     Node binaryTreeToBST (Node root)
//     {
//         if(root == null)
//             return null;
        
//         int n = countNodes(root);
        
//         int arr[] = new int[n];
//         index index = new index();
//         storeInorder(root, arr,index);
        
//         Arrays.sort(arr);
//         index.x = 0;
//         arrayToBST(arr, root, index);
//         return root;
//     }
// }

