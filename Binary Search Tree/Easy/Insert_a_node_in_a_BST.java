/*
Given a BST and a key K. 
If K is not present in the BST, 
Insert a new Node with a value equal to K into the BST. 

Example 1:

Input:
     2
   /   \
  1     3
K = 4
Output: 1 2 3 4
Explanation: After inserting the node 4
Inorder traversal will be 1 2 3 4.
Example 2:

Input:
        2
      /   \
     1     3
             \
              6
K = 4
Output: 1 2 3 4 6
Explanation: After inserting the node 4
Inorder traversal of the above tree
will be 1 2 3 4 6.

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function insert()
  which takes the root of the BST and Key K as
   input parameters and returns the root of the modified BST after inserting K. 
Note: The generated output contains the inorder traversal of the modified tree.


Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(1).


Constraints:
1 <= Number of nodes <= 105
1 <= K <= 106

 
 */

// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Insert_a_node_in_a_BST {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int key = Integer.parseInt(br.readLine().trim());
            Solution3 T = new Solution3();
            root = T.insert(root, key);
            inorder(root);
            System.out.println();
            t--;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends

// User function Template for Java

// class Node
// {
// int data;
// Node left, right;

// public Node(int d)
// {
// data = d;
// left = right = null;
// }
// }

class Solution3 {

    // The function returns the root of the BST (currently rooted at 'root')
    // after inserting a new Node with value 'Key' into it.
    Node insert(Node root, int Key) {
        root = solver(root, Key);
        return root;
    }

    Node solver(Node root, int key) {
        if (root == null) {
            Node newNode = new Node(key);
            return newNode;
        }
        if (root.data > key) {
            root.left = solver(root.left, key);
        } else if (root.data < key) {
            root.right = solver(root.right, key);
        }
        return root;
    }
}


// ==============================
// 
//  GFG Editorial
// 
// ===============================


// . If the element to be inserted is smaller then it goes to left of root,
//  else it goes to right of root. What if it's equal?

// To handle duplicates, 
// as the Note in the problem statement suggests,
//  you simply need to ignore the insertion.
// Hence, make the recursive calls only if the given
//  key value is either strictly greater or strictly smaller than the node value.

// insert(node, data)
// {
//     if (node is NULL) return newNode(data)
//     if (data is less than node.data)
//         node.left  = insert(node.left, data)
//     else if (data is greater than node.data)
//         node.right = insert(node.right, data)
//    return node
// }


// class Solution{
    
//     Node insert(Node root,int key)
//     {
//         if(root == null) return new Node(key);
//         if(key < root.data)
//             root.left  = insert(root.left,key);
//         else if(key > root.data)
//             root.right = insert(root.right,key);
//         return root;
//     }


// }
