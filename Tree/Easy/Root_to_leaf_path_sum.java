/*
Given a binary tree and an integer S, check whether
 there is root to leaf path with its sum as S.

Example 1:

Input:
Tree = 
            1
          /   \
        2      3
S = 2

Output: 0

Explanation:
There is no root to leaf path with sum 2.
Example 2:

Input:
Tree = 
            1
          /   \
        2      3
S = 4

Output: 1

Explanation:
The sum of path from leaf node 3 to root 1 is 4.

Your Task:  
You dont need to read input or print anything. 
Complete the function hasPathSum() which takes root node and target sum S as
 input parameter and returns true if path exists otherwise it returns false.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ N ≤ 10^4
1 ≤ S ≤ 10^6
 */

// { Driver Code Starts
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

public class Root_to_leaf_path_sum {
    public static Node buildTree(String str) {

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

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int sum = Integer.parseInt(br.readLine().trim());
            Tree27 tr = new Tree27();
            if (tr.hasPathSum(root, sum)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}// } Driver Code Ends

/*
 * // A Binary Tree node class Node{ int data; Node left; Node right; Node(int
 * data){ this.data = data; left=null; right=null; } }
 */

class Tree27 {
    /* you are required to complete this function */
    int counter = 0, reqSum = 0;

    boolean hasPathSum(Node root, int S) {
        reqSum = S;
        solver(root, 0);
        return counter > 0;

    }

    void solver(Node root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum + root.data;
        if (checkLeaf(root)) {
            if (sum == reqSum) {
                counter++;
            }
        }
        solver(root.left, sum);
        solver(root.right, sum);

    }

    boolean checkLeaf(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

}




// ==================================
// 
//  GFG Editorial
// 
// =================================


// Algorithm:
// Recursively check if left
//  or right child has path sum equal to ( number – value at current node)


// class Tree {
//     boolean hasPathSum(Node node, int sum) {
//         if (node == null) {
//             return (sum == 0);
//         }

//         boolean ans = false;

//         /* otherwise check both subtrees */
//         int subsum = sum - node.data;
//         if (subsum == 0 && node.left == null && node.right == null) {
//             return true;
//         }
//         if (node.left != null) {
//             ans = ans || hasPathSum(node.left, subsum);
//         }
//         if (node.right != null) {
//             ans = ans || hasPathSum(node.right, subsum);
//         }
//         return ans;
//     }
// }