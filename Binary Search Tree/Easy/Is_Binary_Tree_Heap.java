/*
Given a binary tree you need to check if it follows max heap property or not.
Input:
The task is to complete the method which takes one argument, 
root of Binary Tree. The struct Node has a data part which stores the data,
 pointer to left child and pointer to right child.There are multiple test cases.
  For each test case, this method will be called individually.

Output:
The function should return true if property holds else false.
 

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example:
Input:
2
2
5 2 L 5 3 R
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
1
0

There are two test cases.  First case represents a tree with 3 nodes and 2 edges 
where root is 5, left child of 5 is 2 and right child of 5 is 3.
   Second test case represents a tree with 4 edges and 5 nodes.
 */

// { Driver Code Starts
// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;

// A Binary Tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Is_Binary_Tree_Heap {
    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);

    }

    // driver function to test the above functions
    public static void main(String args[]) {
        Is_Binary_Tree_Heap CLN = new Is_Binary_Tree_Heap();
        // Index index_obj = new Index();
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();

            Node root = null;

            while (n > 0) {

                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);

                // cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }

                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            GfG3 g = new GfG3();

            boolean res = g.isHeap(root);
            if (res == true)
                System.out.println(1);
            else
                System.out.println(0);
            // CLN.inorder(root);
            t--;
            // System.out.println();
        }
    }
}// } Driver Code Ends

/*
 * A Binary Tree node class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */

class GfG3 {
    /* You are required to complete this method */
    boolean isHeap(Node tree) {
        if (tree == null) {
            return true;
        }
        if (tree.left != null) {
            if (tree.left.data > tree.data) {
                return false;
            }
        }
        if (tree.right != null) {
            if (tree.right.data > tree.data) {
                return false;
            }
        }
        return isHeap(tree.left) && isHeap(tree.right);

    }
}