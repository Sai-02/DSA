
/*
Given a Binary Tree. Check whether all of its nodes have the value equal
 to the sum of their child nodes.

Example 1:

Input:
     10
    /
  10 
Output: 1
Explanation: Here, every node is sum of
its left and right child.
Example 2:

Input:
       1
     /   \
    4     3
   /  \
  5    N
Output: 0
Explanation: Here, 1 is the root node
and 4, 3 are its child nodes. 4 + 3 =
7 which is not equal to the value of
root node. Hence, this tree does not
satisfy the given conditions.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function isSumProperty() 
 that takes the root Node of the Binary Tree as input and 
 returns 1 if all the nodes in the tree satisfy the following properties.
  Else, it returns 0.
For every node, data value must be equal to the sum of data values in left
 and right children. Consider data value as 0 for NULL child.
   Also, leaves are considered to follow the property.

Expected Time Complexiy: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 100
1 <= Data on nodes <= 1000
 */

// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

// Contributed by Sudarshan Sharma
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

public class Children_Sum_Parent {

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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree17 g = new Tree17();
            System.out.println(g.isSumProperty(root));

        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right;
 * 
 * Node(int key) { data = key; left = right = null; } }
 * 
 */
class Tree17 {
    // Return 1 if all the nodes in the tree satisfy the given property. Else return
    // 0
    public static int isSumProperty(Node root) {
        int k;
        if (checkSum(root)) {
            k = 1;
        } else {
            k = 0;
        }
        return k;

    }

    public static boolean checkSum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int left = 0, right = 0;
        if (root.right != null) {
            right = root.right.data;
        }
        if (root.left != null) {
            left = root.left.data;
        }
        if (root.data != left + right) {
            return false;
        }

        return checkSum(root.left) && checkSum(root.right);

    }
}

// =======================================
// 
//  GFG Editorial
// 
// =======================================

// 1. For each node, recursively check if the sum of left subtree and
//  sum of right subtree equals the parent's data. 
// If this property is followed for each node then return 1.

// 2.
// isSumProperty(node)
// {
//         left_data = 0
//         right_data = 0
      
//          if(node is null OR (node.left is null AND node.right is null))  //Since both leaf and NULL nodes follow this property.
//           return 1
        
//          else
//         {
//             if(node.left is not null)
//              left_data = node.left.data
             
//             if(node.right is not null)
//              right_data = node.right.data
             
//             if((node.data is left_data + right_data)AND (isSumProperty(node.left) is not 0 AND isSumProperty(node.right) is not 0)) //sum property check
//         return 1
//         else
//         return 0
        
//         }
        
// }







// class Tree
// {
//     public static int isSumProperty(Node node)
//     {
//         int left_data = 0;
//         int right_data = 0;
        
//         // base case
//         if(node == null || (node.left == null && node.right == null))
//           return 1;
          
//         else
//         {
//             // if left child is not null
//             // then store the value in left_Data
//             if(node.left != null)
//              left_data = node.left.data;
            
//             // if right child is not null
//             // then store the value in right_data
//             if(node.right != null)
//              right_data = node.right.data;
             
//             // if stored data of left and right child
//             // is equal to the current node data
//             // then this will return true
//             // So, recurse for left and right node
//             if((node.data == left_data + right_data)&& 
//                (isSumProperty(node.left)!=0 && isSumProperty(node.right) != 0))
//         return 1;
//         else
//         return 0;
        
//         }
        
//     }
// }