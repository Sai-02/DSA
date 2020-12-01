/*
Given a Binary tree.
 Find the level in binary tree which has the maximum number of nodes.

Example 1:

Input:
      2
    /    \ 
   1      3
 /   \     \
4    6      8
     / 
    5
Output: 2
Explanation: The level 2 with nodes 4,
6 and 8 is the level with maximum
number of nodes. 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function maxNodeLevel() 
 that takes root node of the tree as input and 
 returns an integer which is level of the tree with maximum nodes.
  The root is at level 0. If two or more levels have same number of maximum nodes ,
   then return smallest level.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of level<=10
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

public class Maximum_Node_Level {

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
            Tree18 g = new Tree18();
            int ans = g.maxNodeLevel(root);
            System.out.println(ans);
            t--;

        }
    }

}

// } Driver Code Ends

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class Tree18 {
    // Return the level (0-indexed) with maximum number of nodes.
    public static int maxNodeLevel(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int maxLevel = 0, maxNodes = 1, nodes = 0, level = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {

            Node temp = q.remove();
            if (temp == null) {
                if (q.peek() == null) {
                    break;
                }
                if (maxNodes < nodes) {
                    maxNodes = nodes;
                    maxLevel = level;
                    nodes = 0;

                }
                q.add(null);
                level++;
            }

            else {

                if (temp.left != null) {
                    q.add(temp.left);
                    nodes++;
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    nodes++;
                }
            }

        }
        return maxLevel;

    }
}










// ========================================
// 
//  GFG Editorial
// 
// ========================================


// Try modifying the standard level-order traversal of a Binary Tree using Queue.
// You just need something to differentiate between two levels. Something through
//  which you know that the current level is completed and the next level has started.
//   How can you do that?
// Can you demarkate the levels via a NULL node in the queue.



// class Tree
// {
//     // function to find the level  
// // having maximum number of Nodes  
// public static int maxNodeLevel(Node root)  
// {  
//     if (root == null)  
//         return -1;  
  
//     Queue<Node> q = new LinkedList<Node> ();  
//     q.add(root);  
  
//     // Current level  
//     int level = 0;  
  
//     // Maximum Nodes at same level  
//     int max = Integer.MIN_VALUE;  
  
//     // Level having maximum Nodes  
//     int level_no = 0;  
  
//     while (true)  
//     {  
//         // Count Nodes in a level  
//         int NodeCount = q.size();  
  
//         if (NodeCount == 0)  
//             break;  
  
//         // If it is maximum till now  
//         // Update level_no to current level  
//         if (NodeCount > max)  
//         {  
//             max = NodeCount;  
//             level_no = level;  
//         }  
  
//         // Pop complete current level  
//         while (NodeCount > 0)  
//         {  
//             Node Node = q.peek();  
//             q.remove();  
//             if (Node.left != null)  
//                 q.add(Node.left);  
//             if (Node.right != null)  
//                 q.add(Node.right);  
//             NodeCount--;  
//         }  
  
//         // Increment for next level  
//         level++;  
//     }  
  
//     return level_no;  
// }  
// }
