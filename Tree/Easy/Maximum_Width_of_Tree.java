
/*
Given a Binary Tree, find the maximum width of it.
 Maximum width is defined as the maximum number of nodes in any level.
For example, maximum width of following tree is 4 as there are 4 nodes at 3rd level.

          1
       /     \
     2        3
   /    \    /    \
  4    5   6    7
    \
      8

Example 1:

Input:
       1
     /    \
    2      3
Output: 2
Example 2:

Input:
        10
      /     \
    20      30
   /    \
  40    60
Output: 2
Your Task:
You don't have to read any input.
 Just complete the function getMaxWidth()
  that takes node as parameter and returns the maximum width. 
  The printing is done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= edges <= 1000
0 <= nodes values <= 105
 
 */

// { Driver Code Starts
// Initial Template for Java

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

public class Maximum_Width_of_Tree {

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
            Tree21 g = new Tree21();
            int res = g.getMaxWidth(root);
            System.out.println(res);
            // CLN.inorder(root);
            t--;
            // System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * A Binary Tree node class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */

class Tree21 {
    // /* Function to get the maximum width of a binary tree*/
    ArrayList<Integer> a = new ArrayList<>();

    int getMaxWidth(Node root) {
        int n = maxLevel(root);
        for (int i = 0; i < n; i++) {
            a.add(0);
        }
        countLevelNodes(root, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) > max) {
                max = a.get(i);
            }
        }
        return max;
    }

    int maxLevel(Node root) {
        if (root == null) {
            return 0;

        }
        return 1 + Math.max(maxLevel(root.left), maxLevel(root.right));
    }

    void countLevelNodes(Node root, int level) {
        if (root == null) {
            return;
        }
        int k = a.get(level - 1) + 1;
        a.set(level - 1, k);
        countLevelNodes(root.left, level + 1);
        countLevelNodes(root.right, level + 1);
    }
}



// =================================
// 
//  GFG Editorial
// 
// ================================

// . You can either solve this
//  question recursively or by iteratively traversing level by level.

//  To solve it iteratively, just count the number of nodes in a
//   level and check if these are maximum.
//   You'd need to keep track of levels using a marker.


//   class Tree
// {
// 	int getMaxWidth(Node root)
// 	{
// 		int width = 0;
// 		int h = height(root);
// 		int maxWidth = 0;
		
// 		// iterate till height of tree
// 		for(int i=0;i<=h;i++)
// 		{
// 			// get width recursively,
// 			// for next height
// 			width = getWidth(root, i);
			
// 			// update maxWidth
// 			if(width > maxWidth)
// 				maxWidth = width;
// 		}
// 		return maxWidth;
// 	}
	
// 	/* Get width of a given level */
// 	int getWidth(Node root, int level)
// 	{
// 		// base case
// 		if(root == null)
// 			return 0;
			
// 		// 1st level
// 		if(level == 1)
// 			return 1;
		
// 		// if level is greater than 1
// 		// recurse for left and right with sum of width of both
// 		else if(level>1)
// 		return getWidth(root.left,level-1)+getWidth(root.right, level-1);
	
// 	    return 0;
// 	}
	
// 	int height(Node root)
// 	{
// 		if(root == null)
// 			return 0;
// 		else
// 		{
// 		    /* compute the height of each subtree */
// 			int lHeight = height(root.left);
// 			int rHeight = height(root.right);
			
// 			/* use the larger one */
// 			return (lHeight>rHeight) ?(lHeight + 1) : (rHeight+1);
// 		}
// 	}
// }


