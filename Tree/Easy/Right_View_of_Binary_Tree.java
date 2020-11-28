

/*
Given a Binary Tree, find Right view of it.
 Right view of a Binary Tree is set of nodes visible 
 when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /  \
  4     5   6     7
    \
     8

Example 1:

Input:
       1
    /    \
   3      2
Output: 1 2
Example 2:

Input:
     10
    /   \
  20     30
 /   \
40  60 
Output: 10 30 60
Your Task:
Just complete the function rightView() 
that takes node as parameter and returns the right view as a list. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105.
 */

// { Driver Code Starts
// Initial Template for Java

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

public class Right_View_of_Binary_Tree {

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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree12 tree = new Tree12();
            ArrayList<Integer> arr = tree.rightView(root);
            for (int x : arr)
                System.out.print(x + " ");
            System.out.println();

        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Complete The Function Provided Given Below is The Node Of Tree class Node {
 * int data; Node left, right; public Node(int data) { this.data = data; left =
 * right = null; } }
 */


//  ========================================
// 
//  Solution using Morris Traversal
// 
// ==========================================


class Tree12 {
    ArrayList<Integer> rightView(Node root) {
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

                if (q.peek() == null) {
                    a.add(temp.data);
                }
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



// ==========================
// 
//  GFG Editorial
// 
// ==========================

// class Tree{
//     Max_level max = new Max_level();
//     void rightViewUtil(ArrayList<Integer> arr, Node node, int level, Max_level max_level) {
        
//         // base case
//         if (node == null) 
//             return;
            
//         // If this is the last Node of its level
//         if (max_level.max_level < level) {
//             arr.add(node.data);
//             max_level.max_level = level;
//         }
        
//         // recurse for left and right subtree
//         rightViewUtil(arr, node.right, level + 1, max_level);
//         rightViewUtil(arr, node.left, level + 1, max_level);
//     }
    
// 	ArrayList<Integer> rightView(Node node) {
// 	    ArrayList<Integer> arr = new ArrayList<Integer>();
//         rightViewUtil(arr, node, 1, max);
//         return arr;
//     }
// }
// class Max_level {
//     int max_level;
// }