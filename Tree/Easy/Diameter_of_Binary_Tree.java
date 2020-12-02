
/*
Given a Binary Tree, find diameter of it.
The diameter of a tree is the number of nodes on the longest path between
 two leaves in the tree. The diagram below shows two trees each with diameter nine, 
 the leaves that form the ends of a longest path are shaded 
 (note that there is more than one path in each tree of length nine, 
 but no path longer than nine nodes).



Example 1:

Input:
       1
     /  \
    2    3
Output: 3
Example 2:

Input:
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 4
Your Task:
You need to complete the function diameter() that takes root as parameter 
and returns the diameter.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000

 
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

public class Diameter_of_Binary_Tree {

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
            Tree22 g = new Tree22();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Tree22 {
    /* Complete the function to get diameter of a binary tree */
    int d = Integer.MIN_VALUE;

    int diameter(Node root) {
        solveDiameter(root);
        return d + 1;

    }

    void solveDiameter(Node root) {
        if (root == null) {
            return;
        }
        int left = maxLevel(root.left);
        int right = maxLevel(root.right);

        solveDiameter(root.right);
        solveDiameter(root.left);
        if (left + right > d) {
            d = left + right;
        }
    }

    int maxLevel(Node root) {
        if (root == null) {
            return 0;

        }
        return 1 + Math.max(maxLevel(root.left), maxLevel(root.right));
    }
}


// ==================================
// 
//  GFG Editorial
// 
//==================================

// The diameter of a tree T is the largest of the following quantities:

// -> The diameter of T’s left subtree.
// -> The diameter of T’s right subtree.
// -> The longest path between leaves that goes through the root of T 
// (this can be computed from the heights of the subtrees of T).


// class Tree {
//     /* Complete the function to get diameter of a binary tree */
//     int dia = 0;
//     public int util(Node root) {
//         if (root == null) return 0;

//         int l = util(root.left);  // height of left subtree
//         int r = util(root.right); // height of right subtree

//         if (l + r + 1 > dia) dia = l + r + 1; // l+r+1 is a possible max dia

//         return 1 + Math.max(l, r); // returning height of subtree
//     }

//     public int diameter(Node root) {
//         util(root);
//         return dia;
//     }
// }

 