
/*
Given two Binary Trees. Check whether they are Isomorphic or not.

Example 1:

Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function isIsomorphic() 
 that takes the root nodes of both the Binary Trees as its input and 
 returns True if the two trees are isomorphic. Else, it returns False. 
 (The driver code will print Yes if th returned values is true, otherwise false.)

Note: 
Two trees are called isomorphic if one of them can be obtained from other by a series of flips, i.e. by swapping left and right children of a number of nodes. Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
For example, following two trees are isomorphic with following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
ISomorphicTrees

Expected Time Complexity: O(min(M,N)) where M and N are the sizes of the two trees.
Expected Auxiliary Space: O(min(H1,H2)) where H1 and H2 are the heights of the two trees.

Constraints:
1<=Number of nodes<=105
 */

// { Driver Code Starts
// Initial Template for Java

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

public class Check_if_Tree_is_Isomorphic {

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
            String s1 = br.readLine();
            String s2 = br.readLine();
            Node root1 = buildTree(s1);
            Node root2 = buildTree(s2);
            BinaryTree tree = new BinaryTree();
            if (tree.isIsomorphic(root1, root2) == true)
                System.out.println("Yes");
            else
                System.out.println("No");
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

class BinaryTree {
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        if ((isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
                || (isIsomorphic(root1.right, root2.left) && isIsomorphic(root1.left, root2.right))) {
            return true;
        }
        return false;
    }

}


// ========================================
// 
//  GFG Editorial
// 
// ========================================

// We simultaneously traverse both trees. 
// Let the current internal nodes of two trees being traversed be n1 and n2 respectively. 
// There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic.
// 1) Data of n1 and n2 is same.
// 2) One of the following two is true for children of n1 and n2
//        a) Left child of n1 is isomorphic to left child of n2 and right child of 
//        n1 is isomorphic to right child of n2.
//        b) Left child of n1 is isomorphic to right child of n2 and right
//         child of n1 is isomorphic to left child of n2.




// class BinaryTree  
// { 
//     Node root1, root2; 
   
//     /* Given a binary tree, print its nodes in reverse level order */
//     boolean isIsomorphic(Node n1, Node n2)  
//     { 
//         // Both roots are NULL, trees isomorphic by definition 
//         if (n1 == null && n2 == null) 
//             return true; 
   
//         // Exactly one of the n1 and n2 is NULL, trees not isomorphic 
//         if (n1 == null || n2 == null) 
//             return false; 
   
//         if (n1.data != n2.data) 
//             return false; 
   
//         // There are two possible cases for n1 and n2 to be isomorphic 
//         // Case 1: The subtrees rooted at these nodes have NOT been  
//         // "Flipped".  
//         // Both of these subtrees have to be isomorphic. 
//         // Case 2: The subtrees rooted at these nodes have been "Flipped" 
//         return
//         (isIsomorphic(n1.left, n2.left) &&  isIsomorphic(n1.right, n2.right)) 
//         || (isIsomorphic(n1.left, n2.right) &&  isIsomorphic(n1.right, n2.left)); 
//     } 
    
// }    