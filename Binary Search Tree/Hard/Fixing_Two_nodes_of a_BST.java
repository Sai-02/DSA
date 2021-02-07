/*

Two of the nodes of a Binary Search Tree (BST) are swapped. 
Fix (or correct) the BST by swapping them back. 
Do not change the structure of the tree.
Note: It is guaranteed than the given input will form BST,
 except for 2 nodes that will be wrong.
 
Example 1:
Input:
       10
     /    \
    5      8
   / \
  2   20
Output: 1
Explanation:
 
Example 2:

Input:
         11
       /    \
      3      17
       \    /
        4  10
Output: 1 
Explanation: 
By swapping nodes 11 and 10, the BST 
can be fixed.
Your Task:
You don't need to take any input. 
Just complete the function correctBst()
 that takes root node as parameter. 
 The function should return the root of corrected BST.
  BST will then be checked by driver code and 0 or 1 will be printed.

Expected Time Complexity : O(n)
Expected Auxiliary Space : O(1)
 
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

class pair {
    int first;
    int second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class GfG {

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

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null)
            return true;
        if (n.data <= lower || n.data >= upper)
            return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }

        return (compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Sol g = new Sol();

            root = g.correctBST(root);

            // check 1: is tree now a BST
            if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false) {
                System.out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree

            ArrayList<pair> mismatch = new ArrayList<pair>();
            // an arraylist to store data of mismatching nodes

            if (compare(root, duplicate, mismatch) == false) {
                // false output from this function indicates change in structure of tree
                System.out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 || mismatch.get(0).first != mismatch.get(1).second
                    || mismatch.get(0).second != mismatch.get(1).first)
                System.out.println(0);
            else
                System.out.println(1);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Sol {
    ArrayList<Node> inOrder = new ArrayList<>();

    public Node correctBST(Node root) {
        inOrderTraversal(root);
        int n = inOrder.size();
        for (int i = n - 1; i > 0; i--) {
            if (inOrder.get(i).data < inOrder.get(i - 1).data) {
                int j = i - 1;
                while (j >= 0 && inOrder.get(i).data < inOrder.get(j).data) {
                    j--;
                }
                int temp = inOrder.get(i).data;
                inOrder.get(i).data = inOrder.get(j + 1).data;
                inOrder.get(j + 1).data = temp;
                break;
            }
        }
        return root;

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
//  GFG Editorial
// 
// =============================


// 1. We can solve this in O(n) time and with a single traversal of the given BST.
//  Since inorder traversal of BST is always a sorted array, the 
// problem can be reduced to a problem where two elements of a sorted array are swapped.


// 1. The swapped nodes are not adjacent in the inorder traversal of the BST.

//  For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}. 
//  The inorder traversal of the given tree is 3 25 7 8 10 15 20 5 
// If we observe carefully, during inorder traversal, we find node 7 is smaller 
// than the previous visited node 25. Here save the context of node 25 (previous node).
//  Again, we find that node 5 is smaller than the previous node 20.
//   This time, we save the context of node 5 ( current node ).
//    Finally swap the two node’s values.

// 2. The swapped nodes are adjacent in the inorder traversal of BST.

//   For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20 25}. 
//   The inorder traversal of the given tree is 3 5 8 7 10 15 20 25 
// Unlike case #1, here only one point exists where a node value is smaller than 
// previous node value. e.g. node 7 is smaller than node 8.

// How to Solve? We will maintain three pointers, first, middle and last. When we find the first point where current node value is smaller than previous node value, we update the first with the previous node & middle with the current node. When we find the second point where current node value is smaller than previous node value, we update the last with the current node. In case #2, we will never find the second point. So, last pointer will not be updated. After processing, if the last node value is null, then two swapped nodes of BST are adjacent.



// class Sol
// {
//     Node first, middle, last, prev;
//     public Node correctBST(Node root)
//     {
//         first = middle = last = prev = null;
 
//         // Set the poiters to find out 
//         // two nodes
//         correctBSTUtil( root );
 
//         // Fix (or correct) the tree
//         if( first != null && last != null )
//         {
//             int temp = first.data;
//             first.data = last.data;
//             last.data = temp; 
//         }
//         // Adjacent nodes swapped
//         else if( first != null && middle !=
//                                     null ) 
//         {
//             int temp = first.data;
//             first.data = middle.data;
//             middle.data = temp;
//         }
//         return root;
//     }
    
//     public void correctBSTUtil(Node root)
//     {
//         if( root != null )
//         {
//             // Recur for the left subtree
//             correctBSTUtil( root.left);
 
//             // If this node is smaller than
//             // the previous node, it's 
//             // violating the BST rule.
//             if (prev != null && root.data < prev.data)
//             {
//                 // If this is first violation,
//                 // mark these two nodes as
//                 // 'first' and 'middle'
//                 if (first == null)
//                 {
//                     first = prev;
//                     middle = root;
//                 }
 
//                 // If this is second violation,
//                 // mark this node as last
//                 else
//                     last = root;
//             }
 
//             // Mark this node as previous
//             prev = root;
 
//             // Recur for the right subtree
//             correctBSTUtil( root.right);
//         }
//     }
// }
