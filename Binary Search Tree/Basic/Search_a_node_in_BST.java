/*
Given a Binary Search Tree and a node value X, 
find if node with value X is present in the BST or not. 

Example 1:

Input:
         2
          \
          81
        /    \
      42      87
    /   \       \
   45   66      90
x = 87
Output: 1
Explanation: As 87 is present in the
given nodes , so the output will be
1.
Example 2:

Input:
      6
       \
        7
       / \
      8   9
x = 11
Output: 0
Explanation: As 11 is not present in 
he given nodes , so the output will
be 0.

Your Task:
You don't need to read input or print anything.
 Complete the function search() which returns true if the node with value
  x is present in the BST else returns false. 


Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).


Constraints:
1 <= Number of nodes <= 100
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Search_a_node_in_BST {
    void insert(Node root, int key) {

        if (key < root.data) {
            if (root.left != null)
                insert(root.left, key);
            else
                root.left = new Node(key);
        } else if (key > root.data) {
            if (root.right != null)
                insert(root.right, key);
            else
                root.right = new Node(key);
        }

    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Search_a_node_in_BST obj = new Search_a_node_in_BST();
            int a1 = sc.nextInt();
            Node root = new Node(a1);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                obj.insert(root, a);
            }

            int s = sc.nextInt();
            BST g = new BST();
            if (g.search(root, s) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }

    }

}// } Driver Code Ends

/*
 * Node class class Node { int data; Node left, right; Node(int d) { data = d;
 * left = right = null; } }
 */

/* You are required to complete this method */
class BST {
    boolean search(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        if (root.data > x) {
            return search(root.left, x);
        }

        return search(root.right, x);

    }
}



// =================================
// 
//  GFG Editorial
// 
// =================================


// 1. Check root data is equal to x or not. 
// If not then recur for right subtree when root data is less than x.
//  Otherwise recur for left subtree if root data is greater than x.

// class BST
// {
// 	boolean search(Node root, int x)
// 	{
// 	    // base case
// 		if(root == null)
// 			return false;
		
// 		// if data of root
// 		// is equal to x
// 		if(root.data == x)
// 			return true;
		
// 		// recurse for right subtree when root->data
// 		// is less than x
// 		if(x > root.data)
// 		{
// 			return search(root.right, x);
// 		}
		
// 		// else recurse for left subtree
// 		else
// 			return search(root.left, x);
// 	}
// }

