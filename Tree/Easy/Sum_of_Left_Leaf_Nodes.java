
/*
Given a Binary Tree of size N. 
Find the sum of all the leaf nodes that are left child of their parent
 of the given binary tree.

Example 1:

Input:
       1
     /   \
    2     3
Output: 2

Example 2:

Input : 
         1
        /  \
       2    3
     /  \     \
    4    5     8 
  /  \        /  \
 7    2      6    9
Output: 13
Explanation:
sum = 6 + 7 = 13
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function leftLeavesSum() 
 which takes the root node of the tree as input and 
 returns the sum of all the left leaf nodes present in the given binary tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=Number of nodes<=105

Note:The Input/Ouput format and Example given are used for system's internal purpose,
 and should be used by a user for Expected Output only.
  As it is function problem,
  hence a user should not read any input from stdin/console. 
The task is to complete the function specified, 
and not to write the full code.
 */

// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

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

public class Sum_of_Left_Leaf_Nodes {
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

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
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

                // Create the right child for the curr node
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

            Solution3 T = new Solution3();
            System.out.println(T.leftLeavesSum(root));

            t--;
        }
    }
}// } Driver Code Ends

// User function Template for Java

// class Node
// {
// int data;
// Node left, right;

// public Node(int d)
// {
// data = d;
// left = right = null;
// }
// }

class Solution3 {

    public int leftLeavesSum(Node root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (checkLeaf(root.left)) {
            left = root.left.data;
        }

        return left + leftLeavesSum(root.left) + leftLeavesSum(root.right);

    }

    public boolean checkLeaf(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

}





// =================================================
// 
//  GFG Editorial
// 
// ================================================


// The idea is to traverse the tree, starting from root. For every node, 
// check if its left subtree is a leaf. If it is, then add it to the result.

// class Solution{

//     public boolean isLeaf(Node root) 
//     { 
//         if(root == null) 
//            return false; 
//         if (root.left == null && root.right == null) 
//            return true; 
        
//         return false; 
//     } 
    
//     public int leftLeavesSum(Node root) 
//     { 
//         int ans = 0;
      
//         if(root != null) 
//         {
//             if(isLeaf(root.left)) 
//                 ans += root.left.data; 
//             else 
//                 ans += leftLeavesSum(root.left); 
//             ans += leftLeavesSum(root.right); 
//         }
        
//         return ans; 
//     } 

// }