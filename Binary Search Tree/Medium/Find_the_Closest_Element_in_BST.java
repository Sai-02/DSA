
/*
Given a BST and an integer. 
Find the least absolute difference between any node value of the BST and the given integer



Example 1:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 2
Explanation: K=13. The node that has
value nearest to K is 11. so the answer
is 2
Example 2:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
K = 9
Output: 0
Explanation: K=9. The node that has
value nearest to K is 9. so the answer
is 0.
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function minDiff() 
that takes the root of the BST and an integer K 
as its input and returns the minimum absolute diff
erence between any node value of the BST and the integer K.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 100000


 */

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Find_the_Closest_Element_in_BST {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine().trim());

            Solution3 T = new Solution3();
            System.out.println(T.maxDiff(root, k));
            t--;
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution3 {
    static int minDiff = Integer.MAX_VALUE;

    static int maxDiff(Node root, int K) {
        minDiff = Integer.MAX_VALUE;
        solver(root, K);
        return minDiff;

    }

    static void solver(Node root, int k) {
        if (root == null) {
            return;
        }
        int diff = Math.abs(root.data - k);
        minDiff = Math.min(minDiff, diff);
        solver(root.left, k);
        solver(root.right, k);

    }
}



// ==============================
// 
//  GFG Editorial
// 
// ==============================


// Try making the use of BST properties. 
// When will you want to move right and when will you want to move left?
// Also, what if there's a node with the value equal to K present in the BST?

// Following three cases may arise:
// If target value K is present in given BST, then it’s the node having minimum absolute difference.
// If target value K is less than the value of current node then move to the left child.
// If target value K is greater than the value of current node then move to the right child.



// class Solution
// {
//     static int maxDiff(Node  root, int k) 
//     { 
//         if(root==null)
//             return Integer.MAX_VALUE;
        
//         if(root.data==k)
//             return 0;
        
//         if(root.data>k)
//             return Math.min( Math.abs(root.data-k) , maxDiff(root.left,k) );
        
//         return Math.min( Math.abs(root.data-k) , maxDiff(root.right,k) );
//     }
// }