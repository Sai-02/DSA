/*
Given a Binary Search Tree,
 modify the given BST such that itis balanced and has minimum possible height.

Examples :

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30

Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4 

Your Task:
The task is to complete the function buildBalancedTree()
 which takes root as the input argument, and
  returns the root of tree after converting the given BST
   into a balanced BST that has minimum possible height. 
   The driver code will print the height of the updated tree in output itself.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
Here N denotes total number of nodes in given BST.


Constraints:
1<=N<=200
 */

// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node right, left;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Normal_BST_to_Balanced_BST {
    static Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

    }

    int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

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
            String s = br.readLine();
            Node root = buildTree(s);

            GfG gfg = new GfG();

            root = gfg.buildBalancedTree(root);
            // preOrder(root);
            Normal_BST_to_Balanced_BST bst = new Normal_BST_to_Balanced_BST();
            System.out.println(bst.height(root));
            t--;
        }
    }

    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

// } Driver Code Ends

/*
 * class Node { int data; Node right, left; Node(int item) { data = item; left =
 * right = null; } }
 */

class GfG {
    Node buildBalancedTree(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        return solver(inOrder, 0, inOrder.size() - 1);

    }

    Node solver(ArrayList<Integer> inOrder, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node newNode = new Node(inOrder.get(mid));
        newNode.left = solver(inOrder, start, mid - 1);
        newNode.right = solver(inOrder, mid + 1, end);
        return newNode;
    }

    void inOrderTraversal(Node root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right, inOrder);
    }
}

// ===========================================
// 
//  GFG Editorial
// 
// ==========================================



// Store the inorder traversal 
// and try to build a balanced BST using a recursive approach.


// class GfG
// {
    
//      void storeBSTNodes(Node root, Vector<Node> nodes) 
//     {
//         // Base case
//         if (root == null)
//             return;
 
//         // Store nodes in Inorder (which is sorted
//         // order for BST)
//         storeBSTNodes(root.left, nodes);
//         nodes.add(root);
//         storeBSTNodes(root.right, nodes);
//     }
    
    
//      Node buildTreeUtil(Vector<Node> nodes, int start, int end) 
//     {
//         // base case
//         if (start > end)
//             return null;
 
//         /* Get the middle element and make it root */
//         int mid = (start + end) / 2;
//         Node node = nodes.get(mid);
 
//         /* Using index in Inorder traversal, construct
//            left and right subtress */
//         node.left = buildTreeUtil(nodes, start, mid - 1);
//         node.right = buildTreeUtil(nodes, mid + 1, end);
 
//         return node;
//     }
    
    
    
//     Node buildBalancedTree(Node root) 
//     {
//         // Store nodes of given BST in sorted order
//         Vector<Node> nodes = new Vector<Node>();
//         storeBSTNodes(root, nodes);
 
//         // Constucts BST from nodes[]
//         int n = nodes.size();
//         return buildTreeUtil(nodes, 0, n - 1);
//     }
// }

