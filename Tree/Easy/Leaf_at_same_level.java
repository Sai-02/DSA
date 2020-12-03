
/*
Given a Binary Tree, check if all leaves are at same level or not.

Example 1:

Input: 
            1
          /   \
         2     3

Output: 1

Explanation: 
Leaves 2 and 3 are at same level.

Example 2:

Input:
            10
          /    \
        20      30
       /  \        
     10    15

Output: 0

Explanation:
Leaves 10, 15 and 30 are not at same level.

Your Task: 
You dont need to read input or print anything.
 Complete the function check() which takes root node
  as input parameter and returns true/false depending on whether 
  all the leaf nodes are at the same level or not.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
 

Constraints:
1 ≤ N ≤ 10^3
 */

// { Driver Code Starts
// Initial Template for Java

// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;

// A Binary Tree node
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

public class Leaf_at_same_level {

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

    // driver function to test the above functions
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            GfG15 g = new GfG15();
            boolean b = g.check(root);
            if (b == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * A Binary Tree node class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */

class GfG15 {
    int level = 0;

    boolean check(Node root) {
        if (root == null) {
            return true;
        }
        return checkLevel(root, 0);

    }

    boolean checkLevel(Node root, int currentLevel) {
        if (root == null) {
            return true;
        }
        if (checkLeaf(root)) {
            if (level == 0) {
                level = currentLevel;
            } else if (currentLevel != level) {
                return false;
            }
        }
        return checkLevel(root.left, currentLevel + 1) && checkLevel(root.right, currentLevel + 1);

    }

    boolean checkLeaf(Node root) {
        if (root.left == null && root.right == null) {
            return true;

        }
        return false;
    }
}
