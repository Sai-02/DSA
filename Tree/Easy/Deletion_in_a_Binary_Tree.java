/*
Given a Binary Tree of size N, your task is to complete the function deletionBT(), 
that should delete a given node from the tree by making sure that tree shrinks
 from the bottom (the deleted node is replaced by bottommost and rightmost node).
Example:

Eample Deletion in Bt


Your Task:
You don't have to take input. Complete the function deletionBT()
 that takes root node of the tree and given node value (Key) 
 as input parameter and return the root of the modified tree.

Example 1:
 

Input:
Key=1
         1
       /   \
      4     7
     / \
    5   6 
Output:
5 4 6 7 

Explanation:
Modified Tree after deletion the 
node with key = 1
     7 
    /  
   4   
  /  \ 
 5    6 
The Inorder traversal of the modified 
tree is 5 4 6 7 

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

public class Deletion_in_a_Binary_Tree{

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
            String arr[] = br.readLine().split(" ");
            int key = Integer.parseInt(arr[0]);
            String s = br.readLine();
            Node root = buildTree(s);

            Solution15 g = new Solution15();
            g.deletionBT(root, key);
            printInorder(root);
            System.out.println();
            t--;

        }
    }
}

// } Driver Code Ends

/*
 * Node class is as follows:
 * 
 * class Node { int data; Node left, right;
 * 
 * public Node(int data){ this.data = data; } }
 */
class Solution15 {

    public Node deletionBT(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node last = null, toDelete = null;
        while (!q.isEmpty()) {
            last = q.remove();
            if (last.data == key) {
                toDelete = last;
            }
            if (last.left != null) {
                q.add(last.left);
            }
            if (last.right != null) {
                q.add(last.right);
            }
        }
        toDelete.data = last.data;
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.left != null) {
                if (temp.left == last) {
                    temp.left = null;
                } else {
                    q.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == last) {
                    temp.right = null;
                } else {
                    q.add(temp.right);
                }
            }

        }
        return root;

    }
}


// ===================================
// 
//  GFG Editorial
// 
// ===================================


// first find the bottommost and rightmost node.



// class Solution {
    
//     public Node deletionBT(Node root, int key){
        
//         if(root == null)
//             return root;
        
//         Node last = null, toDelete = null;
        
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty())
//         {
//             last = q.poll();
            
//             if(last.data == key)
//                 toDelete = last;
            
//             if(last.left != null)
//                 q.add(last.left);
                
//             if(last.right != null)
//                 q.add(last.right);
//         }
        
//         /*
//         int temp_d = last.data;
//         last.data = toDelete.data;
//         toDelete.data = temp_d;
//         */
//         /*
//         Node temp = last;
//         last = toDelete;
//         toDelete = temp;
//         */
        
//         q = new LinkedList<>();
//         q.add(root);
        
//         Node cn;
//         while(!q.isEmpty())
//         {
//             cn = q.poll();
            
//             if(cn.left != null){
//                 if(cn.left == last){
//                     cn.left = null;
//                 } else 
//                     q.add(cn.left);
//             }
                
//             if(cn.right != null){
//                 if(cn.right == last){
//                     cn.right = null;
//                 } else
//                     q.add(cn.right);
//             }
//         }
        
//         toDelete.data = last.data;
        
//         return root;
//     }
// }
