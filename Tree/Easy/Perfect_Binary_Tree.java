/*
Given a Binary Tree,
 write a function to check whether the given Binary Tree is a prefect Binary Tree or not.
  A Binary tree is Perfect Binary Tree in which all internal nodes
   have two children and all leaves are at same level.

Input:
First line of input contains the number of test cases T.
 For each test case, there will be two lines: 

First line of each test case will be an integer N denoting
 the number of parent child relationships.

Second line of each test case will print the level order 
traversal of the tree in the form of N space separated triplets.
 The description of triplets is as follows:

Each triplet will contain three space-separated elements of the form (int, int char).

The first integer element will be the value of parent. 

The second integer will be the value of corresponding left or right child.
 In case the child is null, this value will be -1.

The third element of triplet which is a character can take any of the three values
 ‘L’, ‘R’ or ‘N’. L denotes that the children is a left child,
  R denotes that the children is a Right Child and N denotes that the child is NULL.

Please note that the relationships are printed only for internal nodes and
 not for leaf nodes.

Output:
Print "Yes" (without quotes) if the binary tree is perfect binary tree.
Print "No" (without quotes) if the binary tree is not a perfect binary tree.
Driver code will print the output based upon the value returned by function.

Your Task:
Finish the function such that it returns 1 if the given tree is perfect binary tree
 and 0 if not.

Constraints:
1<=T<=10^5
1<=N<=10^5
1<=data of node<=10^5

Example:
Input:
3
6
10 20 L 10 30 R 20 40 L 20 50 R 30 60 L 30 70 R
2
18 15 L 18 30 R
6
1 2 L 1 3 R 2 -1 N 2 4 R 3 5 L 3 6 R

Output: 
Yes
Yes
No

 */

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

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

public class Perfect_Binary_Tree {
    static int findADepth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    static boolean isPerfect(Node root) {
        int d = findADepth(root);
        GfG9 g = new GfG9();
        return g.isPerfectRec(root, d, 0);
    }

    public static void main(String[] args) throws IOException {
        // Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            Queue<Node> q = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");

            Node root = null;
            int j = 0;
            while (n > 0) {
                int a1 = Integer.parseInt(input[j]);
                int a2 = Integer.parseInt(input[j + 1]);
                char lr = input[j + 2].charAt(0);
                j += 3;

                if (root == null) {
                    root = new Node(a1);
                    q.add(root);
                }

                Node pick = q.peek();

                q.remove();

                if (lr == 'L') {
                    pick.left = new Node(a2);
                    q.add(pick.left);
                }
                a1 = Integer.parseInt(input[j]);
                a2 = Integer.parseInt(input[j + 1]);
                lr = input[j + 2].charAt(0);
                j += 3;

                if (lr == 'R') {
                    pick.right = new Node(a2);
                    q.add(pick.right);
                }

                n -= 2;
            }
            if (isPerfect(root))
                System.out.println("Yes");
            else
                System.out.println("No");
            t--;
        }
    }

}
// } Driver Code Ends

// User function Template for Java

// Back-end complete function Template for Java

/*
 * 
 * class Node{ int data; Node left,right; Node(int d){ data=d; left=right=null;
 * } }
 * 
 */
class GfG9 {
    static boolean isPerfectRec(Node root, int d, int level) {
        if (root == null) {
            return d == level + 1;

        }
        if (root.left == null && root.right == null) {
            return d == level + 1;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        return isPerfectRec(root.left, d, level + 1) && isPerfectRec(root.right, d, level + 1);
    }
}


// ===========================
// 
//  theory
// 
// ===========================


// GFG

// Check whether a given binary tree is perfect or not
// Last Updated: 04-09-2019
// Given a Binary Tree, write a function to check whether the given Binary Tree
//  is a prefect Binary Tree or not.

// A Binary tree is Perfect Binary Tree in which all internal nodes have two children
//  and all leaves are at same level.

// Examples:
// The following tree is a perfect binary tree

//                10
//            /       \  
//          20         30  
//         /  \        /  \
//       40    50    60   70


//                18
//            /       \  
//          15         30  
// The following tree is not a perfect binary tree

//       1
//     /    \
//    2       3
//     \     /  \   
//      4   5    6


// A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2h – 1 nodes.



// Below is an idea to check whether a given Binary Tree is perfect or not.

// Find depth of any node (in below tree we find depth of leftmost node).
//  Let this depth be d.
// Now recursively traverse the tree and check for following two conditions.
// Every internal node should have both children non-empty
// All leaves are at depth ‘d’

// // Java program to check whether a given  
// // Binary Tree is Perfect or not 




// ==============================
// 
// Code
// 
// ==============================




// class GfG {  
  
// /* Tree node structure */
// static class Node  
// {  
//     int key;  
//     Node left, right;  
// } 
  
// // Returns depth of leftmost leaf.  
// static int findADepth(Node node)  
// {  
// int d = 0;  
// while (node != null)  
// {  
//     d++;  
//     node = node.left;  
// }  
// return d;  
// }  
  
// /* This function tests if a binary tree is perfect  
// or not. It basically checks for two things :  
// 1) All leaves are at same level  
// 2) All internal nodes have two children */
// static boolean isPerfectRec(Node root, int d, int level)  
// {  
//     // An empty tree is perfect  
//     if (root == null)  
//         return true;  
  
//     // If leaf node, then its depth must be same as  
//     // depth of all other leaves.  
//     if (root.left == null && root.right == null)  
//         return (d == level+1);  
  
//     // If internal node and one child is empty  
//     if (root.left == null || root.right == null)  
//         return false;  
  
//     // Left and right subtrees must be perfect.  
//     return isPerfectRec(root.left, d, level+1) && isPerfectRec(root.right, d, level+1);  
// }  
  
// // Wrapper over isPerfectRec()  
// static boolean isPerfect(Node root)  
// {  
// int d = findADepth(root);  
// return isPerfectRec(root, d, 0);  
// }  
  
// /* Helper function that allocates a new node with the  
// given key and NULL left and right pointer. */
// static Node newNode(int k)  
// {  
//     Node node = new Node();  
//     node.key = k;  
//     node.right = null; 
//     node.left = null;  
//     return node;  
// }  
  
// // Driver Program  
// public static void main(String args[])  
// {  
//     Node root = null;  
//     root = newNode(10);  
//     root.left = newNode(20);  
//     root.right = newNode(30);  
  
//     root.left.left = newNode(40);  
//     root.left.right = newNode(50);  
//     root.right.left = newNode(60);  
//     root.right.right = newNode(70);  
  
//     if (isPerfect(root) == true)  
//         System.out.println("Yes");  
//     else
//         System.out.println("No");  
// } 
// }  




// Output:
// Yes
// Time complexity : O(n)