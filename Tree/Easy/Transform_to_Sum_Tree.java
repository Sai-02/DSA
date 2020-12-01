
/*
Given a Binary Tree of size N ,
 where each node can have positive or negative values.
  Convert this to a tree where each node contains the sum of the left and right 
  sub trees of the original tree. The values of leaf nodes are changed to 0.

Example 1:

Input:
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5

Output:
            20
          /    \
        4        12
       /  \     /  \
     0     0   0    0

Explanation:

           (4-2+12+6)
          /           \
      (8-4)          (7+5)
       /   \         /  \
      0     0       0    0
 

Your Task:  
You dont need to read input or print anything. 
Complete the function toSumTree() which takes root node as input parameter
 and modifies the given tree in-place.

Note: If you click on Compile and Test
 the output will be the in-order traversal of the modified tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 

Constraints:
1 ≤ N ≤ 104
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

public class Transform_to_Sum_Tree {

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
            Tree19 g = new Tree19();
            g.toSumTree(root);
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

/*
 * Complete the Given Function Node is as follows: class Tree{ int data; Tree
 * left,right; Tree(int d){ data=d; left=null; right=null; } }
 */
class Tree19 {
    public void toSumTree(Node root) {
        solve(root);
        makeLeafZero(root);
    }

    public void makeLeafZero(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.data = 0;
        }
        makeLeafZero(root.right);
        makeLeafZero(root.left);
    }

    public void solve(Node root) {
        if (root == null) {
            return;
        }
        int prev = root.data;

        root.data = makeSum(root.left) + makeSum(root.right);
        if (root.left == null || root.right == null) {
            if (prev != 0 && root.data == 0) {
                root.data = prev;
            }
        }
        solve(root.left);
        solve(root.right);

    }

    public int makeSum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + makeSum(root.left) + makeSum(root.right);
    }

}


// ======================================
// 
//  GFG Editorial
// 
// ======================================

// Recursively call for left and right subtrees and change the value
//  of current node as sum of the values returned by the recursive calls.

// class Tree
// {
//     // Convert a given tree to a tree where every node contains sum of 
//     // values of nodes in left and right subtrees in the original tree 
//     public int toSumTreeUtil(Node node)  
//     { 
//         // Base case 
//         if (node == null) 
//             return 0; 
   
//         // Store the old value 
//         int old_val = node.data; 
   
//         // Recursively call for left and right subtrees and store the sum 
//         // as new value of this node 
//         node.data = toSumTreeUtil(node.left) + toSumTreeUtil(node.right); 
   
//         // Return the sum of values of nodes in left and right subtrees 
//         // and old_value of this node 
//         return node.data + old_val; 
//     } 

//     public void toSumTree(Node node)
//         {
//             toSumTreeUtil(node);
//         }
// }
