
/*
Given a binary tree, find its minimum depth.

Example 1:

Input:
            1
          /   \
         3     2
        /
       4           

Output: 2

Explanation:
Minimum depth is between nodes 1 and 3.
Example 2:

Input:
             10
          /     \
        20       30
          \        \   
          40        60 
                   /
                  2 

Output: 3

Explanation:
Minimum depth is between nodes 10,20 and 40.

Your Task:  
You dont need to read input or print anything.
 Complete the function minDepth() which takes root node as input parameter
  and returns the minimum depth.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 

Constraints:
1 ≤ N ≤ 10^5
 */

// { Driver Code Starts
// Initial Template for Java

// Contributed by Sudarshan Sharma
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

public class Minimum_Depth_of_a_Binary_Tree {

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
            Tree11 g = new Tree11();
            int k = g.minDepth(root);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node{ int data; Node left; Node right; Node(int data){ this.data =
 * data; left=null; right=null; } }
 */

class Tree11 {
    int minDepth(Node root) {
        return getMinDepth(root);

    }

    int getMinDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.right == null || root.left == null) {
            return 1 + getMinDepth(root.left) + getMinDepth(root.right);
        }

        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }
}



// ================================
// 
// GFG Editorial
// 
// ================================


// class Tree
// {
// 	int minDepth(Node root)
// 	{
// 		if(root == null)
// 			return 0;
			
// 		if(root.left == null && root.right == null)
// 			return 1;
		
// 		if(root.left == null)
// 			return minDepth(root.right)+1;
			
// 		if(root.right == null)
// 			return minDepth(root.left)+1;
			
// 		return Math.min(minDepth(root.left), minDepth(root.right))+1;
// 	}
// }