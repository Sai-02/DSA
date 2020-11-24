
/*
Given a Binary Tree of size N, 
find all the nodes which don't have any sibling. 
Root node can not have a sibling.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 20 113
Explanation: 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: -1
Explanation: Every node has a sibling.

Your Task:  
You dont need to read input or print anything.
 Complete the function noSibling() which takes the
  root of the tree as input parameter and returns a list of integers containing all 
  the nodes that don't have a sibling in sorted order. If all nodes have a sibling,
   then the returning list should contain only one element -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the tree)


 */

// { Driver Code Starts

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

class GfG4 {

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
            Tree4 g = new Tree4();
            ArrayList<Integer> ans = g.noSibling(root);

            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * A Binary Tree nodea class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class Tree4 {
    ArrayList<Integer> noSibling(Node node) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.addAll(noSibling1(node));

        if (a.size() == 0) {
            a.add(-1);
        }
        Collections.sort(a);
        return a;

    }

    ArrayList<Integer> noSibling1(Node node) {
        ArrayList<Integer> a = new ArrayList<>();
        if (node == null) {
            return a;
        }
        if (node.left != null && node.right != null) {
            a.addAll(noSibling1(node.left));
            a.addAll(noSibling1(node.right));

        } else if (node.right != null) {
            a.add(node.right.data);
            a.addAll(noSibling1(node.right));

        } else if (node.left != null) {
            a.add(node.left.data);
            a.addAll(noSibling1(node.left));
        }

        return a;

    }

}