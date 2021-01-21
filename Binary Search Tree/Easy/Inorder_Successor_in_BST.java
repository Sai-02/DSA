
/*
Given a BST, and a reference to a Node x in the BST.
 Find the Inorder Successor of the given node in the BST.
 

Example 1:

Input:
      2
    /   \
   1     3
K(data of x) = 2
Output: 3 
Explanation: 
Inorder traversal : 1 2 3 
Hence, inorder successor of 2 is 3.

Example 2:

Input:
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
K(data of x) = 8
Output: 10
Explanation:
Inorder traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10.
 

Your Task:
You don't need to read input or print anything
. Your task is to complete the function inOrderSuccessor().
 This function takes the root node and the reference node as argument
  and returns the node that is inOrder successor of the reference node
  . If there is no successor, return null value.


Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N <= 1000, where N is number of nodes
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

public class Inorder_Successor_in_BST {

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

    public static Node search(Node root, int x) {
        if (root == null || root.data == x)
            return root;
        if (root.data > x)
            return search(root.left, x);
        return search(root.right, x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine());
            Node kNode = search(root, k);

            Tree2 g = new Tree2();
            Node x = g.inorderSuccessor(root, kNode);

            if (x == null)
                System.out.println("-1");
            else
                System.out.println(x.data);
            t--;
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right; Node(int d){ data=d; left=right=null; } }
 */



class Tree2 {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    ArrayList<Node> inOrder = new ArrayList<>();

    public Node inorderSuccessor(Node root, Node x) {
        inOrder.clear();
        inOrderTraversal(root);
        int n = inOrder.size();
        for (int i = 0; i < n; i++) {
            if (x == inOrder.get(i)) {
                if (i != n - 1) {
                    return inOrder.get(i + 1);
                }
            }
        }
        return null;

    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrder.add(root);
        inOrderTraversal(root.right);
    }
}


// ==============================
// 
// GFG Editorial
// 
// =============================


// Inorder successor of node x is the first element that occurs 
// after the node x in the inorder traversal of the tree.
// The inorder traversal of a BST has a sepcial property.
//  It is that, the inorder traversal of a BST gives us the nodes in the sorted order. 
// Try using this fact to get to an O(1) auxiliary space iterative solution.

// class Tree{
// 	public Node inorderSuccessor(Node root,Node k)
// 	{
// 		if(root==null||k==null)
// 			return null;
// 		Node temp=null;
// 		while(root!=null){
// 			if(root.data<=k.data){
// 				root=root.right;
// 			}
// 			else{
// 				temp=root;
// 				root=root.left;
// 			}
// 		}
// 		return temp;
		
// 	}
// }
