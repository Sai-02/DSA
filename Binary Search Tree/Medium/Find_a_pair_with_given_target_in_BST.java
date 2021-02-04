/*
Given a Binary Search Tree and a target sum.
 Check whether there's a pair of Nodes in the BST with value summing up to the target sum.


Example 1:

Input:
        2
      /   \
     1     3
sum = 5
Output: 1 
Explanation: 
Nodes with value 2 and 3 sum up to 5.
Example 2:

Input:
           6
          /    
         5     
        /
       3 
     /  \
    1    4
sum = 2
Output: 0 
Explanation: 
There's no pair that sums up to 2.
 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function isPairPresent() 
 that takes a root node and a target value as a parameter
  and returns 1 if there's a pair of Nodes in the BST with values summing 
  up to the target sum, else returns 0. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1<=Number of Nodes<=100000
1<=K<=1000005
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

public class Find_a_pair_with_given_target_in_BST {
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

            int target = Integer.parseInt(br.readLine().trim());

            Solution4 T = new Solution4();
            System.out.println(T.isPairPresent(root, target));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution4 {
    // root : the root Node of the given BST
    // target : the target sum
    int found = 0;
    ArrayList<Integer> a = new ArrayList<>();

    public int isPairPresent(Node root, int target) {
        a.clear();
        found = 0;
        getInorderTraversal(root);
        checkTarget(target);
        return found;

    }

    public void getInorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        getInorderTraversal(root.left);
        a.add(root.data);
        getInorderTraversal(root.right);
    }

    public void checkTarget(int target) {
        int l = 0, r = a.size() - 1;
        while (l < r) {
            if (a.get(l) + a.get(r) == target) {
                found = 1;
                break;
            }
            if (a.get(l) + a.get(r) > target) {
                r--;
            } else {
                l++;
            }
        }

    }
}

// ========================================
// 
//  GFG Editoial
// 
// =======================================


// The inorder traversal of a BST gives us the keys in sorted order.
// Hence, you can generate a sorted array of keys and the question then
//  reduces to finding the pair sum in a sorted array.
// The O(N) solution for this is pretty straightforward using 2-pointers.

// But, storing all the keys in an array requires O(N) extra space.
//  Can you use the same idea of the 2-pointers without actually storing 
//  the node values in an array? What about doing an
//   iterative in-order traversal of the tree, one normal and the other reverse?



// class Solution
// {
//     HashSet<Integer> nodeValues = new HashSet<>();
    
//     public int isPairPresent(Node root,int k)
//     {
        
//         if(root == null)
//             return 0;
        
//         // Return true if value of current 
//         // node is already present in set 
//         if(nodeValues.contains(root.data)) 
//             return 1;
        
//         // Add the difference to set
//         nodeValues.add(k - root.data);
        
//         // Return 1 if pair found in left or right subtree
//         // and 0 otherwise
//         return Math.max(isPairPresent(root.left,k),isPairPresent(root.right,k));
//     }
// }
