
/*
Given the binary Tree of and two-node values.
 Check whether the two-node values are cousins of each other or not.

Example 1:

Input:
      1
    /   \
   2     3
a = 2, b = 3
Output: 0

Example 2:

Input:
       1
     /   \ 
    2     3
   /       \
  5         4 
a = 5, b = 4
Output: 1
Explanation: Here, nodes 5 and 4 are
at the same level and have different
parent nodes. Hence, they both are cousins 

Your Task:
You don't need to read input or print anything. 
 Your task is to complete the function isCousins() 
 that takes the root node of the tree (having all nodes distinct),
  and two integers 'a' and 'b' as inputs. 
  It returns true if the nodes with given 
  values 'a' and 'b' are Cousins of each other and returns false otherwise. 
Two nodes value are cousins of each other if they are at the same 
level and have different parents. (The driver code will print 1 if
 the returned values is true,otherwise 0.)

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1<=Number of Nodes<=1000


 */

// /{
// Driver Code Starts
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

public class Check_if_two_Nodes_are_Cousins {

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
            Solution4 g = new Solution4();
            String X = br.readLine();
            String arr[] = X.split(" ");
            int x, y;
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            if (g.isCousins(root, x, y))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}

// } Driver Code Ends

/*
 * Node is as follows: class Node{ int data; Node left,right; Node(int d){
 * data=d; left=right=null; } }
 */
// User function Template for Java

class Solution4 {
    boolean bool = true;
    int k = 0;

    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns
    // false
    public boolean isCousins(Node root, int a, int b) {
        int aLevel = findLevel(root, 0, a);
        int bLevel = findLevel(root, 0, b);
        // System.out.print(aLevel+" "+bLevel+" ");
        if (aLevel != bLevel)
            return false;
        if (a == b) {
            bool = false;
            if (k >= 2) {
                bool = true;
            }
        }

        checkSameParent(root, a, b);
        return bool;
    }

    public int findLevel(Node root, int level, int value) {
        if (root == null) {
            return -1;
        }
        if (root.data == value) {
            return level;

        }
        return Math.max(findLevel(root.left, level + 1, value), findLevel(root.right, level + 1, value));

    }

    public void checkSameParent(Node root, int a, int b) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }
        if (root.left.data == a) {
            k++;
        }
        if ((root.left.data == a && root.right.data == b) || (root.left.data == b && root.right.data == a)) {
            bool = false;
        }
        checkSameParent(root.left, a, b);
        checkSameParent(root.right, a, b);
    }

}



// ======================================
// 
//  GFG Editorial
// 
// ======================================

// The idea is to find level of one of the nodes. Using the found level,
//  check if ‘a’ and ‘b’ are at this level. If ‘a’ and ‘b’ are at given level,
//  then finally check if they are not children of same parent.


// class Solution {
//     Map<Integer, Integer> depth;
//     Map<Integer, Node> parent;

//     public boolean isCousins(Node root, int x, int y) {
//         depth = new HashMap();
//         parent = new HashMap();
//         dfs(root, null);
//         return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
//     }

//     public void dfs(Node node, Node par) {
//         if (node != null) {
//             depth.put(node.data, par != null ? 1 + depth.get(par.data) : 0);
//             parent.put(node.data, par);
//             dfs(node.left, node);
//             dfs(node.right, node);
//         }
//     }
// }
