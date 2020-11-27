
/*
Given two binary trees, the task is to find if both of them are identical or not. 

Example 1:

Input:
     1          1
   /   \      /   \
  2     3    2     3
Output: Yes
Explanation: There are two trees both
having 3 nodes and 2 edges, both trees
are identical having the root as 1,
left child of 1 is 2 and right child
of 1 is 3.
Example 2:

Input:
    1       1
  /  \     /  \
 2    3   3    2
Output: No
Explanation: There are two trees both
having 3 nodes and 2 edges, but both
trees are not identical.
Your task:
Since this is a functional problem you don't have to worry about input,
 you just have to complete the function isIdentical() that takes two roots 
 as parameters and returns true or false. 
 The printing is done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 1000
1 <=Data of a node <= 1000
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

public class Determine_if_Two_Trees_are_Identical {

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
            String s1 = br.readLine();
            String s2 = br.readLine();
            Node root1 = buildTree(s1);
            Node root2 = buildTree(s2);
            Tree10 g = new Tree10();
            // System.out.println(g.isIdentical(root,roott));
            boolean b = g.isIdentical(root1, root2);
            if (b == true)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * 
 * class Node{ int data; Node left,right; Node(int d){ data=d; left=right=null;
 * } }
 * 
 */
/*
 * Should return true if trees with roots as root1 and root2 are identical
 */

class Tree10 {
    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        } else if (root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.right, root2.right) && isIdentical(root1.left, root2.left);

    }

}

// =========================
// 
// GFG Editorial
// 
// =========================


// sameTree(tree1, tree2)
// 1. If both trees are empty then return 1.
// 2. Else If both trees are non -empty
//      (a) Check data of the root nodes (tree1->data ==  tree2->data)
//      (b) Check left subtrees recursively  i.e., call sameTree( 
//           tree1->left_subtree, tree2->left_subtree)
//      (c) Check right subtrees recursively  i.e., call sameTree( 
//           tree1->right_subtree, tree2->right_subtree)
//      (d) If a,b and c are true then return 1.
// 3  Else return 0 (one is empty and other is not)


// class Tree
// {
// 	boolean isIdentical(Node root1, Node root2)
// 	{
// 	    // base case when both roots are null
// 		if(root1==null && root2==null)
// 			return true;
			
// 		// if not null
//         // then compare the data of both the root
//         // and then recurse for left child of both the trees
//         // and right child of both the trees
// 		if(root1 != null && root2 != null)
// 			return (root1.data == root2.data && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right));
	
// 		return false;
// 	}
	
// }