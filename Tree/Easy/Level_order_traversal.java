/*
Given a binary tree, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:

Input:
    1
  /   \ 
 3     2
Output:1 3 2

Example 2:

Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:10 20 30 40 60 N N

Your Task:
You don't have to take any input. Complete the function levelOrder()
 that takes the root node as input parameter and 
 returns a list of integers containing the level
  order traversal of the given Binary Tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 <= Number of nodes<= 104
1 <= Data of a node <= 104
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

public class Level_order_traversal {

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
            tree23 g = new tree23();
            ArrayList<Integer> res = g.levelOrder(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class tree23 {
    // You are required to complete this method
    static ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return a;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.peek() == null) {
                    break;
                }
                q.add(null);
            }

            else {

                a.add(temp.data);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
        return a;

    }
}



// ==================================
// 
//  GFG Editorial
// 
// =================================


// For level order traversal, you'd need to use a queue.
// Push the root in queue and while queue is not empty just 
// keep on printing the front and push the left and right child of front if they exist.


// class Level_order_traversal
// {
// 	static ArrayList <Integer> levelOrder(Node node)
//     {
// 		 ArrayList <Integer> res = new ArrayList <Integer> (0);
// 		 // Base case
// 		 if(node == null)
// 		    return res;
// 		// Create an empty queue for level order tarversal
// 		Queue<Node> q = new LinkedList<>();
// 		q.add(node);
// 		while(q.isEmpty() == false)
// 		{
// 		    // Print front of queue and remove it from queue
// 		     node = q.peek();
// 		    res.add (node.data);
// 		    q.poll();
		    
// 		    /*Enqueue left child*/
// 		    if(node.left != null)
// 		      q.add(node.left);
		      
// 		    /*Enqueue right child*/
// 		    if(node.right != null)
// 		      q.add(node.right);
		    
// 		}
// 		return res;
// 	}

// }



