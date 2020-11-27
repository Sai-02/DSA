
/*
Given a Binary Tree.
 Find the difference between the sum of node values at 
 even levels and the sum of node values at the odd levels.

Example 1:

Input:
            1
          /   \
         2     3

Output: -4

Explanation:
sum at odd levels - sum at even levels
= (1)-(2+3) = 1-5 = -4

Example 2:

Input:
            10
          /    \
        20      30
       /  \         
     40    60      

Output: 60

Explanation:
sum at odd levels - sum at even levels
= (10+40+60) - (20+30)
= 110 - 50
= 60

Your Task:  
You dont need to read input or print anything.
 Complete the function getLevelDiff() which takes root
  node as input parameter and returns an integer.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 

Constraints:
1 ≤ N ≤ 10^5
 */


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

public class Odd_even_level_difference {

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
            Tree9 g = new Tree9();
            System.out.println(g.getLevelDiff(root));
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node{ int data; Node left; Node right; Node(int data){ this.data =
 * data; left=null; right=null; } }
 */
class Tree9 {
    int getLevelDiff(Node root) {
        return getOddSum(root);

    }

    int getEvenSum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data - getOddSum(root.left) - getOddSum(root.right);

    }

    int getOddSum(Node root) {
        if (root == null) {
            return 0;

        }
        return root.data - getEvenSum(root.left) - getEvenSum(root.right);

    }
}

// ==================
// 
//  GFG Editorial
// 
// ==================

// class Tree
// {
// 	int getLevelDiff(Node root)
// 	{
// 		if(root == null)
// 			return 0;
		
// 		return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
// 	}
// }