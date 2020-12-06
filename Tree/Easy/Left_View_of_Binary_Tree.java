/*
Given a Binary Tree, print Left view of it. 
Left view of a Binary Tree is set of nodes visible when tree is visited from Left side.
 The task is to complete the function leftView(), which accepts root of the tree 
 as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView()
 that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 */

// { Driver Code Starts
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

public class Left_View_of_Binary_Tree {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree26 g = new Tree26();
            ArrayList<Integer> result = g.leftView(root);
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
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
class Tree26 {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(null);
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                if (q.peek() == null) {
                    break;
                }
                a.add(q.peek().data);
                q.add(null);

            } else {
                if (temp.left != null) {

                    q.add(temp.left);
                }
                if (temp.right != null) {

                    q.add(temp.right);
                }
            }
        }
        return a;

    }
}



// ======================================
// 
//  GFG EDitorial
// 
// =====================================



// We can keep track of level of a node by passing a parameter to all recursive calls.
//  The idea is to keep track of maximum level also. Whenever we see a node whose level
//   is more than maximum level so far, we print the node because this is the first node
//    in its level
//  (Note that we traverse the left subtree before right subtree).


// class Tree
// {
// 	//Node root;
    
//     int max_level = 0;
    
//     // Util function to get the left view
//     void leftViewUtil(ArrayList<Integer> result, Node node, int level)
//     {
//         // base case
//         if (node==null) return;
        
//         // If this is the first node of its level 
//         if (max_level < level)
//         {
//             result.add(node.data);
//             max_level = level;
//         }
        
//         // Recur for left and right subtrees 
//         leftViewUtil(result, node.left, level+1);
//         leftViewUtil(result, node.right, level+1);
//     }
    
//     // Function to get the left view
//     ArrayList<Integer> leftView(Node root)
//     {
//         ArrayList<Integer> result = new ArrayList<Integer>();
// 		leftViewUtil(result, root, 1);
// 		return result;
//     }
// }
