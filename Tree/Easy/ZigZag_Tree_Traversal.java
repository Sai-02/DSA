/*

Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

 

Example 1:

Input:
        3
      /   \
     2     1
Output: 3 1 2
 

Example 2:

Input:
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
Output: 7 7 9 8 8 6 9 10 
 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function zigZagTraversal()
  which takes the root node of the Binary Tree as 
  its input and returns a list containing the node values as they
   appear in the Zig-Zag Level-Order Traversal of the Tree.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 <= N <= 104

 
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class ZigZag_Tree_Traversal {
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

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            GFG g = new GFG();

            ArrayList<Integer> res = g.zigZagTraversal(root);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();

            t--;

        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left,right; Node(int d) { data=d;
 * left=right=null; } }
 */
// Print the zig zag traversal of tree.
class GFG {
    // return an array containing the zig zag level order traversal of the given
    // tree
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        boolean even = false;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.peek() == null) {
                    break;
                }
                q.add(null);

                while (!st.empty()) {
                    int k = st.pop();
                    a.add(k);

                }
                if (even) {
                    even = false;
                } else {
                    even = true;
                }
            } else {
                if (temp.left != null) {

                    q.add(temp.left);
                }
                if (temp.right != null) {

                    q.add(temp.right);
                }
                if (even) {
                    st.push(temp.data);
                } else {
                    a.add(temp.data);
                }
            }

        }
        while (!st.empty()) {
            int k = st.pop();
            a.add(k);

        }
        return a;

    }
}




// ================================================
// 
//  GFG EDITORIAL
// 
// ================================================


// Assume the two stacks are current: currentlevel and nextlevel.
//  We would also need a variable to keep track of the current level 
// order(whether it is left to right or right to left).


// class GFG
// {
// 	ArrayList<Integer> zigZagTraversal(Node root)
// 	{
// 	    ArrayList<Integer> res = new ArrayList<Integer>(0); 
// 	    if(root==null)
//             return res;
//         Stack<Node>s1=new Stack<Node>();
//         Stack<Node>s2=new Stack<Node>();
//         s1.push(root);
//         while(s1.empty()==false || s2.empty()==false)
//         {
//             while(s1.empty()==false)
//             {
//                 Node p=s1.pop();
//                 res.add (p.data);
//                 if(p.left!=null)
//                 s2.push(p.left);
//                 if(p.right!=null)
//                 s2.push(p.right);
//             }
//             while(s2.empty()==false)
//             {
//                 Node p=s2.pop();
//                 res.add (p.data);
//                 if(p.right!=null)
//                 s1.push(p.right);
//                 if(p.left!=null)
//                 s1.push(p.left);
//             }
//         }
        
//         return res; 
// 	}
// }
