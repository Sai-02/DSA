/*
Consider Red lines of slope -1 passing between nodes
 (in following diagram). 
 The diagonal sum in a binary tree is the sum of all node’s data 
 lying between these lines. Given a Binary Tree of size N, print all diagonal sums.

For the following input tree, output should be 9, 19, 42.
9 is sum of 1, 3 and 5.
19 is sum of 2, 6, 4 and 7.
42 is sum of 9, 10, 11 and 12.

DiagonalSum

Example 1:

Input:
         4
       /   \
      1     3
           /
          3
Output: 7 4 
Example 2:

Input:
           10
         /    \
        8      2
       / \    /
      3   5  2
Output: 12 15 3 
Your Task:
You don't need to take input.
 Just complete the function diagonalSum()
  that takes root node of the tree as parameter 
  and returns an array containing the diagonal sums for every diagonal
   present in the tree with slope -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of nodes<=105
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

public class Diagonal_Sum_In_Binary_Tree {

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
            Tree16 g = new Tree16();
            ArrayList<Integer> res = g.diagonalSum(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right; Node(int d){ data=d; left=right=null; } }
 */
class Tree16 {
    ArrayList<Integer> a = new ArrayList<>();

    public ArrayList<Integer> diagonalSum(Node root) {
        int length = getTotalDiagonal(root);
        for (int i = 0; i < length; i++) {
            a.add(0);
        }
        diagonalSum(0, root);
        while (a.get(a.size() - 1) == 0) {
            a.remove(a.size() - 1);
        }
        return a;

    }

    public int getTotalDiagonal(Node root) {
        if (root == null) {
            return 1;
        }

        return 1 + getTotalDiagonal(root.left);
    }

    public void diagonalSum(int i, Node root) {
        if (root == null) {
            return;
        }
        a.set(i, a.get(i) + root.data);
        diagonalSum(i, root.right);
        diagonalSum(i + 1, root.left);
    }

}