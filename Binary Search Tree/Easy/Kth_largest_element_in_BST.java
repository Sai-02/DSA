/*
Given a Binary search tree.
 Your task is to complete the function which will
  return the Kth largest element without doing any modification in Binary Search Tree.


Example 1:

Input:
      4
    /   \
   2     9
k = 2 
Output: 4

Example 2:

Input:
       9
        \ 
          10
K = 1
Output: 10

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function kthLargest()
 which takes the root of the BST and an integer K as 
 inputs and returns the Kth largest element in the given BST.


Expected Time Complexity: O(H + K).
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 1000
1 <= K <= N
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

public class Kth_largest_element_in_BST {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine());

            Tree11 g = new Tree11();
            System.out.println(g.kthLargest(root, k));
            t--;
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left; Node right; Node(int data) { this.data =
 * data; left=null; right=null; } }
 */


//  ==================
// 
// Solution having Space Complexity-O(n)
//                  Time Complexity-O(n)
// 
// ===================
class Tree11 {
    // return the Kth largest element in the given BST rooted at 'root'
    ArrayList<Integer> inOrderReverse = new ArrayList<>();

    public int kthLargest(Node root, int K) {
        inOrderReverse.clear();
        inOrderTraversal(root);
        int length = inOrderReverse.size();
        for (int i = 0; i < length; i++) {
            if ((i + 1) == K) {
                return inOrderReverse.get(i);
            }

        }
        return -1;

    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.right);
        inOrderReverse.add(root.data);
        inOrderTraversal(root.left);

    }
}


// =======================
// 
//  Solution in space Complexity-O(1) and Time Compexity-O(n)
// 
// ========================


// 
// class Tree
// {
//     // return the Kth largest element in the given BST rooted at 'root'
//     int result=-1;
//     int count=0;
//     public int kthLargest(Node root,int K)
//     {
//         solver(root,K);
//         return result;   
//     }
//     public void solver(Node root,int k){
//         if(root==null){
//             return ;
//         }
//         solver(root.right,k);
//         count++;
//         if(count==k){
//         
    // result=root.data;
//         }
//         solver(root.left,k);
        
        
//     }
// }



// ========================================
// 
//  GFG Editorial
// 
// ======================================

// The idea is to do reverse inorder traversal of BST.
//  The reverse inorder traversal traverses all nodes in decreasing order.
//   While doing the traversal, we keep track of count of nodes visited so far. 
// When the count becomes equal to k,
//  we stop the traversal and print the key.