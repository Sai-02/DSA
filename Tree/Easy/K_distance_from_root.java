
/*
Given a Binary Tree of size N and an integer K.
 Print all nodes that are at distance k from root
  (root is considered at distance 0 from itself).
   Nodes should be printed from left to right. 
   If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6 
     \
      8

Example 1:

Input:
K = 0
      1
    /   \
   3     2
Output: 1

Example 2:

Input:
K = 3
        3
       /
      2
       \
        1
      /  \
     5    3


Output: 5 3
Your Task:
You don't have to take input.
 Complete the function Kdistance() that accepts root node
  and k as parameter and return the value of the nodes that are at a distance k
   from the root. (The values are returned as vector<int> in cpp, 
   as ArrayList<Integer> in java and list in python)
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 104
0 <= K <= 30
 */

//{
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

public class K_distance_from_root {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String X[] = br.readLine().trim().split(" ");
            int k = Integer.parseInt(X[0]);
            String s = br.readLine();
            Node root = buildTree(s);
            Tree14 g = new Tree14();
            ArrayList<Integer> nodes = g.Kdistance(root, k);
            for (int i = 0; i < nodes.size(); i++) {
                System.out.print(nodes.get(i) + " ");
            }
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left, right; Node(int item) { data = item; left =
 * right = null; } }
 */

class Tree14 {
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        if (k > getDepth(root)) {
            return a;
        }
        return kDistance(root, 0, k);

    }

    ArrayList<Integer> kDistance(Node root, int level, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        if (root == null)
            return a;
        if (k == level) {
            a.add(root.data);
            return a;
        }
        a.addAll(kDistance(root.left, level + 1, k));
        a.addAll(kDistance(root.right, level + 1, k));
        return a;

    }

    int getDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}

// =====================================
//
// GFG Editorial
//
// ======================================

// class Tree
// {
//     void KdistanceUtil(Node root,int k,ArrayList<Integer> nodes){
//         if(root == null){
//               return;
//           }
//           if(k == 0){
//               nodes.add(root.data);
//               return;
//           }
//           KdistanceUtil(root.left, k-1,nodes);
//           KdistanceUtil(root.right, k-1,nodes);
//     }
//      // Recursive function to print right view of a binary tree.
//      ArrayList<Integer> Kdistance(Node root, int k)
//      {
//           // Your code here
//           ArrayList<Integer> nodes = new ArrayList<Integer>();
//           KdistanceUtil(root,k,nodes);
//           return nodes;
//      }
// }