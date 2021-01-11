/*
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
 The left and right pointers in nodes are to be used as previous and next pointers
  respectively in converted DLL. The order of nodes in DLL must be same as
   Inorder of the given Binary Tree. The first node of Inorder traversal 
   (leftmost node in BT) must be the head node of the DLL.

TreeToList

Example 1:

Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3 
Explanation: DLL would be 3<=>1<=>2
Example 2:

Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:  DLL would be 
40<=>20<=>60<=>10<=>30.
Your Task:
You don't have to take input.
 Complete the function bToDLL() 
 that takes root node of the tree as a parameter and returns the head of DLL . 
 The driver code prints the DLL both ways.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <= Number of nodes <= 1000
1 <= Data of a node <= 1000
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }

}

public class Binary_Tree_to_DLL {

    static Node buildTree(String str) throws IOException {

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

    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            GfG g = new GfG();

            Node ans = g.bToDLL(root);
            printList(ans);
            t--;
            System.out.println();
        }

    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * class Node class Node { Node left, right; int data;
 * 
 * Node(int d) { data = d; left = right = null; }
 * 
 * }
 */

// This function should return head to the DLL



class GfG {
    ArrayList<Node> inOrder = new ArrayList<>();

    Node bToDLL(Node root) {
        inOrder.clear();
        inorderTraversal(root);
        Node head = null;
        Node temp = null;
        int n = inOrder.size();
        for (int i = 0; i < n; i++) {
            if (head == null) {

                head = inOrder.get(i);
                head.left = null;
                head.right = null;
                temp = head;
            } else {

                Node newNode = inOrder.get(i);
                newNode.right = null;
                newNode.left = temp;
                temp.right = newNode;

                temp = temp.right;
            }

        }

        temp.right = null;

        return head;

    }

    void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        inOrder.add(root);
        inorderTraversal(root.right);
    }
}

// ===================================
// 
//  Alternate solution
// 
// ==================================

// class GfG
// {
//     ArrayList<Integer> inOrder=new ArrayList<>();
//     Node bToDLL(Node root)
//     {
//         inOrder.clear();
//         inorderTraversal(root);
//         Node head=null;
//         Node temp=null;
//         int n=inOrder.size();
//         for(int i=0;i<n;i++){
//             if(head==null){
                
//                 head=new Node(inOrder.get(i));
//               temp=head;
//             }
//             else{
                
            
//                 Node newNode=new Node(inOrder.get(i));
//                 newNode.left=temp;
//                 temp.right=newNode;
//                 newNode.right=null;
//                 temp=temp.right;
//             }
            
            
            
            
            
           
//         }
//         temp.right=null;
        
        
//         return head;
        
	
//     }
//     void inorderTraversal(Node root){
//         if(root==null){
//             return ;
//         }
//         inorderTraversal(root.left);
//         inOrder.add(root.data);
//         inorderTraversal(root.right);
//     }
// }

// ======================================
// 
//  GFG Editorial
// 
// ======================================

// The idea is to do inorder traversal of the binary tree. 
// While doing inorder traversal,
//  keep track of the previously visited node in a variable say prev. 
// For every visited node, make it next of prev and previous of this node as prev.




// class GfG
// {
// 	Node head;
// 	Node bToDLL(Node root)
// 	{
// 	    // base case
// 		if(root == null)
// 			return null;
		
// 		// Recursively convert right subtree 
// 		bToDLL(root.right);
		
// 		// Now convert this node 
// 		root.right = head;
		
// 		// if head doesn't exists
// 		// mark the node as head
// 		if(head != null)
// 			head.left = root;
		
// 		head = root;
		
// 		// recurse for left subtree
// 		bToDLL(root.left);
		
// 		return head;
// 	}
// }