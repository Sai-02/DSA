/*
Given a Binary Search Tree (BST) and a range l-h(inclusive),
 count the number of nodes in the BST that lie in the given range.

The values smaller than root go to the left side
The values greater and equal to the root go to the right side
Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range
Example 2:

Input:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the
given range.
Your Task:
This is a function problem. You don't have to take input.
 You are required to complete the function getCountOfNode() 
 that takes root, l ,h as parameters and returns the count.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 100
1 <= l < h < 103

Company Tags
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

public class Count_BST_nodes_that_lie_in_a_given_range {

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
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            Node root = buildTree(s);
            Tree g = new Tree();
            System.out.println(g.getCount(root, a, b));
            t--;

        }
    }

}

// } Driver Code Ends

// A Binary Search Tree node
/*
 * 
 * class Node { int data; Node left; Node right;
 * 
 * Node(int data){ this.data = data; this.left = this.right = null; } }
 * 
 */
// Complete this function
class Tree {
    int count = 0;

    int getCount(Node root, int l, int h) {
        count = 0;
        solver(root, l, h);
        return count;
    }

    void solver(Node root, int l, int h) {
        if (root == null) {
            return;
        }
        if (l <= root.data && root.data <= h) {
            count++;
        }

        solver(root.left, l, h);
        solver(root.right, l, h);

    }
}

// =========================================================
//
// GFG Editorial
//
// ==========================================================

// The idea is to traverse the given binary
//  search tree starting from root. For every node being visited,
//   check if this node lies in range, if yes, then add
//    1 to result and recur for both of its children. 
//    If current node is smaller than low value of range,
//  then recur for right child, else recur for left child.



// class Tree {
//     int getCount(Node node, int low, int high) 
//     { 
//         // Base Case 
//         if(node == null) 
//             return 0; 
  
//         // If current node is in range, then  
//         // include it in count and recur for  
//         // left and right children of it 
//         if(node.data >= low && node.data <= high) 
//             return 1 + this.getCount(node.left, low, high)+ 
//                 this.getCount(node.right, low, high); 
                  
//         // If current node is smaller than low,  
//         // then recur for right child 
//         else if(node.data < low) 
//             return this.getCount(node.right, low, high); 
          
//         // Else recur for left child 
//         else
//             return this.getCount(node.left, low, high);      
//     } 
// }
