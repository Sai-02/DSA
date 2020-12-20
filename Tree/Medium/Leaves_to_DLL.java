
/*
Given a Binary Tree of size N, 
extract all its leaf nodes to form a Doubly Link List strating from the left most leaf.
 Modify the original tree to make the DLL thus removing the leaf nodes from the tree.
  Consider the left and right pointers of the tree to be the previous and next pointer 
  of the DLL respectively.

Example 1:

Input :
        1
      /   \
     2     3
    / \   / \
   4   5 6   7    

Output: 
Modified Tree :
        1
      /   \
     2     3

Doubly Link List :
4 <-> 5 <-> 6 <-> 7

Explanation:
The leaf nodes are modified to form the DLL 
in-place. Thus their links are removed from 
the tree.
Example 2:

Input :
        1
      /   \
     2     3
    / \   
   4   5 

Output: 
Modified Tree :
        1
      /   
     2    

Doubly Link List :
4 <-> 5 <-> 3

Your Task:  
You dont need to read input or print anything. 
Complete the function convertToDLL() 
which takes root of the given tree as input parameter
 and returns the head of the doubly link list.

Note:
The generated output will contain the inorder traversal of the modified tree,
 the DLL from left to right and the DLL from right to left.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ N ≤ 10^4
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

public class Leaves_to_DLL {

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
            Tree2 g = new Tree2();
            Node head = g.convertToDLL(root);
            printInorder(root);
            System.out.println();
            Node curr = head;
            Node last = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                last = curr;
                curr = curr.right;
            }
            System.out.println();
            curr = last;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * Node is as follows: class Node{ int data; Node left; Node right; Node(int
 * data){ this.data = data; left=null; right=null; } }
 */

class Tree2 {
    ArrayList<Node> a = new ArrayList<>();

    public Node convertToDLL(Node root) {
        a.removeAll(a);
        removeLeaf(root);
        Node head = null;
        Node temp = null;
        int n = a.size();
        for (int i = 0; i < n; i++) {
            if (head == null) {
                head = a.get(i);
                temp = head;
            } else {
                Node New = a.get(i);
                New.left = temp;
                temp.right = New;
                temp = temp.right;
            }
        }

        return head;

    }

    public boolean checkLeaf(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    public void removeLeaf(Node root) {
        if (root == null) {
            return;
        }
        if (checkLeaf(root.left)) {
            a.add(root.left);
            root.left = null;
        }
        removeLeaf(root.left);
        if (checkLeaf(root.right)) {
            a.add(root.right);
            root.right = null;
        }

        removeLeaf(root.right);

    }

}
