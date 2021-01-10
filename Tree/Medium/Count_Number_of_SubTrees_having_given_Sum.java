/*
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

public class Count_Number_of_SubTrees_having_given_Sum {

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
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int x = Integer.parseInt(br.readLine());
            Tree23 tr = new Tree23();
            System.out.println(tr.countSubtreesWithSumX(root, x));

        }

    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left,right; Node(int d) { data=d;
 * left=right=null; } }
 */

// Return the count of the sub-trees having sum as X.


// =======================================
// 
// Naive approach in O(n2)
// 
// =======================================
// class Tree23 {

//     int countSubtreesWithSumX(Node root, int X) {
//         int count = 0;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         q.add(null);
//         while (!q.isEmpty()) {
//             Node temp = q.remove();
//             if (temp == null) {
//                 if (q.peek() == null) {
//                     break;
//                 }
//                 q.add(null);
//             } else {
//                 if (X == sumSubTree(temp)) {
//                     count++;
//                 }
//                 if (temp.left != null) {
//                     q.add(temp.left);
//                 }
//                 if (temp.right != null) {
//                     q.add(temp.right);
//                 }
//             }
//         }
//         return count;

//     }

//     int sumSubTree(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         return sumSubTree(root.left) + root.data + sumSubTree(root.right);

//     }

// }


// =================================
// 
//  Optimized approach in O(n)
// 
// ================================

class Tree23
{
    int count=0;
    int countSubtreesWithSumX(Node root, int X)
    {
        count=0;
        int k=sumSubTree(root,X);
        return count;
        
	
    }
    int sumSubTree(Node root,int X){
        if(root==null){
            return 0;
        }
        int left=sumSubTree(root.left,X);
        int right=sumSubTree(root.right,X);
        if(root.data+left+right==X){
            count++;
        }
        return left+right+root.data;
    }
    
}


// ==============================================
// 
//  GFG Editorial
// 
// ==============================================

// One way is to traverse the tree from top to bottom,
//  caluclate the sum of the subtree rooted at a particular node and
//   check if the sum is equal to X. If it is,
//    incremenet your count. Else, move on to the next node and repeat the same.

// This approach would be O(N^2) as you'll be separately calling for the subtree sum rooted at each and every node (calculating the subtree sum is O(N)).

// Can you do it better? Think about traversing the tree from bottom to up.
// How about using a Post-order traversal of the tree for the same?


// class Tree
// {
//     int c=0;
//     Tree()
//     {
//         c=0;
//     }
    
//     int countSubtreesWithSumXUtil(Node root,int x)
//     {
//         // if tree is empty 
//     	if (root==null)return 0;
    	
//     	// sum of nodes in the left subtree  
//     	int ls = countSubtreesWithSumXUtil(root.left,x);
    	
//     	// sum of nodes in the right subtree  
//     	int rs = countSubtreesWithSumXUtil(root.right, x);
    	
    	
//     	int sum = ls + rs + root.data;
    	
//     	// if tree's nodes sum == x 
//     	if (sum == x)c++;
//     	return sum;
//     }

//     int countSubtreesWithSumX(Node root, int x)
//     {
//         // if tree is empty 
//     	if (root==null)return 0;
    	
//     	// sum of nodes in the left subtree  
//     	int ls = countSubtreesWithSumXUtil(root.left, x);
    	
//     	// sum of nodes in the right subtree  
//     	int rs = countSubtreesWithSumXUtil(root.right, x);
    	
//     	// check if above sum is equal to x
//     	if ((ls + rs + root.data) == x)c++;
//     	return c;
//     }
    
// }

