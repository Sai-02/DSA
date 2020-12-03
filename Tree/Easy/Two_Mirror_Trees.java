
/*
Given a Two Binary Trees, 
write a function that returns true if one is mirror of other, else returns false.
MirrorTree1            

Example 1:

Input:
T1:     1     T2:     1
      /   \         /   \
     2     3       3     2
Output: 1
Example 2:

Input:
T1:     10      T2:   10
       /  \          /  \
      20  30        20  30
     /  \          /  \
    40   60       40  60
Output: 0

Your Task:
You don't need to take input. 
Just complete the function areMirror()
 that takes root node of two tree as parameter and returns true,
  if one is the mirror of other else returns false. 
  (The driver's code print 1 if the returned value is true, otherwise 0)
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes<= 10000
-1000 <= Data of a node<= 1000

 */

// { Driver Code Starts
// INITIAL CODE

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

public class Two_Mirror_Trees {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            String s1 = br.readLine();
            Node root = buildTree(s);
            Node root1 = buildTree(s1);
            Tree20 g = new Tree20();
            if (g.areMirror(root, root1)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}// } Driver Code Ends

// FUNCTION CODE
/*
 * A Binary Tree node class Node { int data; Node left, right; Node(int item) {
 * data = item; left = right = null; } }
 */

class Tree20 {
    boolean areMirror(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }
        return (a.data == b.data) && areMirror(a.right, b.left) && areMirror(a.left, b.right);
    }
}



// ====================================
// 
//  GFG Editorial
// 
// ====================================


// For two trees ‘a’ and ‘b’ to be mirror images, the following
//  three conditions must be true:

// Their root node’s key must be same
// Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
// Right subtree of ‘a’ and left subtree of ‘b’ are mirror.

// class Tree {
//     boolean areMirror(Node a, Node b) {
//         /* Base case : Both empty */
//         if (a == null && b == null) return true;

//         // If only one is empty
//         if (a == null || b == null) return false;

//         /* Both non-empty, compare them recursively
//            Note that in recursive calls, we pass left
//            of one tree and right of other tree */
//         return a.data == b.data && areMirror(a.left, b.right) &&
//                areMirror(a.right, b.left);
//     }
// }
