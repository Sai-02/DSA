
/*
iven a Binary Search Tree and a range. Find all the numbers in the BST that lie in 
the given range.
Note: Element greater than or equal to root go to the right side.

 

Example 1:

Input:
       17
     /    \
    4     18
  /   \
 2     9 
l = 4, h = 24
Output: 4 9 17 18 

Example 2:

Input:
       16
     /    \
    7     20
  /   \
 1    10
l = 13, h = 23
Output: 16 20 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function printNearNodes()
  which takes the root Node of the BST and the range elements
   low and high as inputs and returns an array that 
   contains the BST elements in the given range low to high (
       inclusive) in non-decreasing order.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 104
1 <= l < h < 105
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

public class Print_BST_elements_in_given_range {

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        // Scanner sc = new Scanner(System.in);
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution1 g = new Solution1();
            String X = br.readLine();
            String arr[] = X.split(" ");
            int x, y;
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.printNearNodes(root, x, y);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * Node is as follows: class Node{ int data; Node left; Node right; Node(int
 * data){ this.data = data; left=null; right=null; } }
 * 
 */
class Solution1 {
    static ArrayList<Integer> ans = new ArrayList<>();

    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ans.clear();
        solver(root, low, high);
        Collections.sort(ans);
        return ans;

    }

    public static void solver(Node root, int low, int high) {
        if (root == null) {
            return;
        }

        if (low < root.data) {
            solver(root.left, low, high);

        }
        if (low <= root.data && root.data <= high) {
            ans.add(root.data);
        }

        if (root.data <= high) {

            solver(root.right, low, high);
        }

    }

}

// ===============================
// 
//  GFG Editorial
// 
// ================================


// Algorithm:
// 1) If value of root’s key is greater than k1, then recursively call in left subtree.
// 2) If value of root’s key is in range, then print the root’s key.
// 3) If value of root’s key is smaller than k2, then recursively call in right subtree.


// Morris Traversal is a very nice memory efficient technique to do tree traversal 
// without using stack or recursion in constant memory O(1) based on Threaded Binary Trees.
//  Morris traversal can be used in solving problems where inorder tree traversals 
//  are used especially in order statistics eg-Kth largest element in BST,
//   Kth smallest in BST etc. Hence, this is where Morris traversal would
//    come handy as a more efficient method to do inorder traversal in constant O(1)
//     space without using any stack or recursion.

// Algorithm

// 1) Initialize Current as root.
// 2) While current is not NULL :
//    2.1) If current has no left child
//     a) Check if current lies between n1 and n2.
//        1)If so, then visit the current node.

//     b)Otherwise, Move to the right child of current.

//   3) Else, here we have 2 cases:
//    a) Find the inorder predecessor of current node. 
//       Inorder predecessor is the right most node 
//       in the left subtree or left child itself.

//    b) If the right child of the inorder predecessor is NULL:
//       1) Set current as the right child of its inorder predecessor.
//       2) Move current node to its left child.

//    c) Else, if the threaded link between the current node 
//       and it's inorder predecessor already exists :
//       1) Set right pointer of the inorder predecessor as NULL.
//       2) Again check if current node lies between n1 and n2.
//         a)If so, then visit the current node.
//       3)Now move current to it's right child.


// class Solution
// {   
// 	public static void printNearNodesUtil(Node node, int k1, int k2 , ArrayList<Integer> res)
// 	{
         
//         /* base case */
//         if (node == null) {
//             return;
//         }
 
//         /* Since the desired o/p is sorted, recurse for left subtree first
//          If root->data is greater than k1, then only we can get o/p keys
//          in left subtree */
//         if (k1 < node.data) {
//             printNearNodesUtil(node.left, k1, k2, res);
//         }
 
//         /* if root's data lies in range, then prints root's data */
//         if (k1 <= node.data && k2 >= node.data) {
//             res.add(node.data);
//         }
 
//         /* If root->data is smaller than k2, then only we can get o/p keys
//          in right subtree */
//         if (k2 > node.data) {
//             printNearNodesUtil(node.right, k1, k2,res);
//         }
//     }

//     public static ArrayList<Integer> printNearNodes(Node root, int low, int high)
// 	{
//         ArrayList<Integer> res = new ArrayList<Integer>();
//         printNearNodesUtil(root, low, high, res);
//         return res;
//     }    
    
// }

