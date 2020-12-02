
/*
Given a Binary Tree and a target key you need to find the level of target key 
in the given Binary Tree.

           3
         /   \
        2     5
      /   \
     1     4
Key: 4
Level: 3  
Note: if no such key exists then return 0.

Example 1:

Input:
        1
      /   \
     2     3
target = 4
Output: 0

Example 2:

Input:
         3
       /   \
      2     5
    /   \
   1     4
target = 4
Output: 2
Your Task:
 You don't have to take input. 
 Just complete the function getLevel()
  that takes a node and a target as parameters and returns the level of the target value. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and
 this space is used implicitly for recursion stack.

Constraints:
1 <= Number of nodes<= 105
1 <= Data of a node<= 105
1 <= Target <= 105
 */

// {
// Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Level_of_a_Node_in_Binary_Tree {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int target = Integer.parseInt(br.readLine().trim());

            Solution T = new Solution();
            System.out.println(T.getLevel(root, target));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    /* Returns level of given data value */
    int getLevel(Node node, int data) {
        return getKeyLevel(node, data, 1);
    }

    int getKeyLevel(Node node, int data, int level) {
        if (node == null) {
            return 0;

        }
        if (node.data == data) {
            return level;
        }
        return Math.max(getKeyLevel(node.left, data, level + 1), getKeyLevel(node.right, data, level + 1));
    }

}


// =============================
// 
//  GFG Editorial
// 
// =============================

// The idea is to start from the root and level as 1. If the key matches
//  with root’s data, return level.
//  Else recursively call for left and right subtrees with level as level + 1.


//  class Solution
// {
//     int getLevelUtil(Node node, int data, int level)
//     {
//     	if (node == null) 
//             return 0; 
   
//         if (node.data == data) 
//             return level; 
   
//         int downlevel = getLevelUtil(node.left, data, level + 1); 
//         if (downlevel != 0) 
//             return downlevel; 
   
//         downlevel = getLevelUtil(node.right, data, level + 1); 
//         return downlevel; 
//     } 
   
//     /* Returns level of given data value */
//     int getLevel(Node node, int data)  
//     { 
//         return getLevelUtil(node, data, 1); 
//     } 

// }