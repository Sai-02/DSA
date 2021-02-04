/*
Given a BST, modify it so that all greater values 
in the given BST are added to every node.


Example 1:

Input:
           50
         /    \
        30    70
      /   \   / \  
     20   40 60  80
Output: 350 330 300 260 210 150 80
Explanation:The tree should be modified to
following:
             260
          /       \
        330      150
       /   \   /     \
    350   300 210    80
Example 2:

Input:
          2
        /   \
       1     5
            /  \
           4    7
Output: 19 18 16 12 7
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function modify() 
which takes one argument: root of the BST.
 The function should contain the logic to modify the BST 
 so that in the modified BST, every node has a value equal
  to the sum of its value in the original BST and 
  values of all the elements larger than it in the original BST.
   Return the root of the modified BST. 
   The driver code will print the inorder traversal of the returned BST/

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1<=N<=100000


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
public class Add_all_greater_values_to_every_node_in_a_BST {
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

            Solution2 T = new Solution2();
            root = T.modify(root);
            inorder(root);
            System.out.println();
            t--;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
// } Driver Code Ends

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

class Solution2 {

    int sum = 0;

    public Node modify(Node root) {
        sum = 0;
        getSum(root);
        changeValues(root);
        return root;

    }

    public void getSum(Node root) {
        if (root == null) {
            return;
        }
        sum = sum + root.data;
        getSum(root.left);
        getSum(root.right);
    }

    public void changeValues(Node root) {
        if (root == null) {
            return;
        }
        changeValues(root.left);
        int temp = root.data;
        root.data = sum;
        sum = sum - temp;
        changeValues(root.right);
    }

}



// ==============================
// 
// GFG Editorial
// 
// ==============================


// Uses the technique of reverse in-order tree traversal of BST

// class Solution{
    
//     public Node modify(Node root)
//     {
//         if(root == null) return null;
        
//         generateGreaterTree(root,0);
//         return root;
//     }
    
//     int generateGreaterTree(Node root,int sum)
//     {
//         if(root.right != null) sum = generateGreaterTree(root.right,sum);
//         root.data +=sum;
//         if(root.left != null)
//             return generateGreaterTree(root.left,root.data);
//         else
//             return root.data;
//     }
// }

