

/*
Given a BST and an integer K. Find the Kth Smallest element in the BST. 

Example 1:

Input:
      2
    /   \
   1     3
K = 2
Output: 2
Example 2:

Input:
        2
      /  \
     1    3
K = 5
Output: -1
 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function KthSmallestElement()
  which takes the root of the BST and integer K as inputs 
  and return the Kth smallest element in the BST, if no such element exists return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1<=Number of nodes<=100000

 
 */

// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Kth_smallest_element_in_BST {
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
            Node currrNode = q.remove();

            // Get the currrent node's value from the string
            String currrVal = s[i];

            // If the left child is not null
            if (!currrVal.equals("N")) {

                // Create the left child for the currrent node
                currrNode.left = new Node(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currrVal = s[i];

            // If the right child is not null
            if (!currrVal.equals("N")) {

                // Create the right child for the currrent node
                currrNode.right = new Node(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.right);
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

            int k = Integer.parseInt(br.readLine().trim());

            Solution1 T = new Solution1();
            System.out.println(T.KthSmallestElement(root, k));
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

// class Node
// {
// int data;
// Node left, right;

// public Node(int d)
// {
// data = d;
// left = right = null;
// }
// }

class Solution1 {
    // Return the Kth smallest element in the given BST
    int count = 0, result = -1;

    public int KthSmallestElement(Node root, int K) {
        count = 0;
        solver(root, K);
        return result;

    }

    void solver(Node root, int k) {
        if (root == null) {
            return;
        }
        solver(root.left, k);
        count++;
        if (k == count) {
            result = root.data;
            return;
        }
        solver(root.right, k);
    }

}



// ==============================
// 
//  GFG Editorial
// 
// ==============================

// You can solve this by iterative inorder traversal of the BST 
// (about which you can read here) but that method would require some extra auxiliary space.
//  You can optimize the Auxiliary space to O(1). 
// Try it using the Morris Traversal of the BST.



// class Solution
// {
//     public int KthSmallestElement(Node root, int k) 
//     {
//         Node temp = MorrisInorderTraversal(root, k);
//         if(temp != null)
//             return temp.data;
//         else
//             return -1;
//     }
    
//     public Node MorrisInorderTraversal(Node root, int k)
//     {
//     	if(root == null)
//     		return null;
    	
//     	Node prev = null;
//     	Node curr = root;
    	
//     	while(curr != null)
//     	{
//     		// check for presence of left subtree
//     		if(curr.left == null)
//     		{
//     		    // If kth smallest is found
//                 if(k == 1)
//                 {
//                     // Return the current node
//                     return curr;
//                 }
                
//                 k--;
//                 // Traverse right subtree otherwise
//     			curr = curr.right;
//     		}
//     		else
//     		{
//     			// Find the inorder predecessor of current
//     			prev = curr.left;
//     			while(prev.right != null && prev.right != curr)
//     			{
//     				prev = prev.right;
//     			}
    			
    			
//     			if(prev.right == null)
//     			{
//     			    // Make current as the right child of  
//                     // its inorder predecessor 
//     				prev.right = curr;
//     				curr = curr.left;
//     			}
//     			else
//     			{
//     				// Revert the changes to right child
//     				// of predecessor
//     				prev.right = null;
//     				k--;
//                     if(k == 0)
//                         return curr;
                    
//     				// Traverse right subtree
//     				curr = curr.right;
//     			}
//     		}
//     	}
    	
//     	return null;
//     }
// }