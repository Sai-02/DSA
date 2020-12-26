/*
Given a binary tree, connect the nodes that are at same level. 
You'll be given an addition nextRight pointer for the same.

Initially, all the nextRight pointers point to garbage values.
 Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL

 

Example 1:

Input:
     3
   /  \
  1    2
Output:
3 1 2
1 3 2
Explanation:The connected tree is
        3 ------> NULL
     /    \
    1-----> 2 ------ NULL
Example 2:

Input:
      10
    /   \
   20   30
  /  \
 40  60
Output:
10 20 30 40 60
40 20 60 10 30
Explanation:The connected tree is
         10 ----------> NULL
       /     \
     20 ------> 30 -------> NULL
  /    \
 40 ----> 60 ----------> NULL
Your Task:
You don't have to take input. 
Complete the function connect() 
that takes root as parameter and connects the nodes at same level.
 The printing is done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
 */

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
    }
}

public class Connect_Nodes_at_Same_Level {

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

    public static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void printSpecial(Node root) {
        if (root == null)
            return;

        Node next_root = null;

        while (root != null) {
            System.out.print(root.data + " ");

            if (root.left != null && next_root == null)
                next_root = root.left;
            else if (root.right != null && next_root == null)
                next_root = root.right;

            root = root.nextRight;
        }

        printSpecial(next_root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree5 g = new Tree5();
            g.connect(root);
            printSpecial(root);
            System.out.println();
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

class Tree5 {
    /*
     * Node class is Defined as follows: class Node{ int data; Node left; Node
     * right; Node nextRight; Node(int data){ this.data = data; left=null;
     * right=null; nextRight = null; } }
     */
    public static void connect(Node p) {
        Queue<Node> q = new LinkedList<>();
        q.add(p);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.peek() == null) {
                    break;
                }
                q.add(null);

            } else {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                temp.nextRight = q.peek();
            }
        }
    }

}



// ==========================================
// 
//  GFG Editorial
// 
// =========================================


// Traverse the nextRight node before the left and right children
//  (root, nextRight, left), then we can make sure that all nodes at level i have
//   the nextRight set, before the level i+1 nodes.

// In this method, we make sure that all nodes at the 4’s level 
// (level 2) have nextRight set, before we try to set the nextRight of 9.
//  So when we set the nextRight of 9, we search for a nonleaf node on right side of node 4
//   (getNextRight() does this for us).

//             1            -------------- Level 0
//           /    \
//         2        3       -------------- Level 1
//        / \      /  \
//       4   5    6    7    -------------- Level 2
//      / \           / \
//     8   9        10   11 -------------- Level 3





// class Tree
// {
    
// void connect(Node p)
// {
//     // creating queue for level order traversal of tree
//     Queue<Node> q = new LinkedList<>(); 
//     q.add(p);
    
//     Node prev=null;
//     // prev hold the value of previous node on the particular level
//     Node end = p;
//     Node nextend = null;
//     // end will hold value of last node of a level
//     // and nextend will store the same for the next level
    
//     while(!q.isEmpty())
//     {
//         Node temp = q.peek();
//         q.poll();
//         if(temp.left!=null) { q.add(temp.left); nextend = temp.left; }
//         if(temp.right!=null){ q.add(temp.right); nextend = temp.right; }
//         // storing all available nodes and updating nextend
        
//         if(prev!=null) prev.nextRight = temp;
//         // setting nextRight of previous node of that level
        
//         if(temp == end)
//         {
//             // If we've reached the end of a level, we need to :
//             // 1. Set nextRight of the node to NULL
//             temp.nextRight = null;
//             // 2. Make sure that it doesnt get connected to node of next level
//             prev = null;
//             // 3. Set the value of end for next level
//             end = nextend;
//         }
//         // If not at end of a level, we need to make sure that 'prev' gets
//         // the address of current node before we move to the next one
//         else prev = temp;
//     }
// }
// }

