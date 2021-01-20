
/*
Given two Binary Search Trees(without duplicates). 
Find need to print the common nodes in them.
 In other words, find intersection of two BSTs

Example 1:

Input:
BST1:
                  5
               /     \
             1        10
           /   \      /
          0     4    7
                      \
                       9
BST2:
                10 
              /    \
             7     20
           /   \ 
          4     9
Output: 4 7 9 10

Example 2:

Input:
BST1:
     10
    /  \
   2   11
  /  \
 1   3
BST2:
       2
     /  \
    1    3
Output: 1 2 3
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function printCommon()
 that takes roots of both the BSTs as input and
  returns an array containing the intersection of the 2 BSTs in a sorted order. 

Expected Time Complexity: O(N1 + N2) where N1 and N2 are the sizes of the 2 BSTs.
Expected Auxiliary Space: O(H1 + H2) where H1 and H2 are the Heights of the 2 BSTs.

Constraints:
1 <= N <= 103
 */

// { Driver Code Starts
// Initial Template for Java

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

public class Print_Common_Nodes_in_two_BSTs {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals("N"))
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
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            BST1 g = new BST1();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.printCommon(root1, root2);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}// } Driver Code Ends

// User function Template for Java

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right; Node (int d){ data=d; left=right=null; } }
 */
class BST1 {
    // print a list containing the intersection of the two BSTs in a sorted order
    static ArrayList<Integer> ans = new ArrayList<>();

    public static ArrayList<Integer> printCommon(Node root1, Node root2) {
        ans.clear();
        solver(root1, root2);
        Collections.sort(ans);
        return ans;

    }

    public static void solver(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        if (root1.data == root2.data && !ans.contains(root1.data)) {
            ans.add(root1.data);
            solver(root1.right, root2);
            solver(root1.left, root2);
            solver(root1, root2.right);
            solver(root1, root2.left);
            return;

        }
        if (root1.data < root2.data) {
            solver(root1.right, root2);
        } else {
            solver(root1.left, root2);
        }
        if (root2.data < root1.data) {
            solver(root1, root2.right);
        } else {
            solver(root1, root2.left);
        }

    }
}



// =========================================
// 
//  GFG Editorial
// 
// =========================================

//  This question can be solved by many approaches.
//  One such approach is the use iteartive inorder traversal.


//  The idea is to use iterative inorder traversal.
//   We use two auxiliary stacks for two BSTs. 
//   Since we need to find common elements, 
//   whenever we get same element during the inorder traversal,
//    we print it. Else, if the elements are not same, 
//    we should accordingly go to right of first or second tree.
//     Also, when you go for the right subtree if elements are not equal,
//      then you should keep track of node of another subtree.

//Back-end complete function Template for Java

// class BST{
// 	// Function two print common elements in given two trees  
//     public static ArrayList<Integer> printCommon(Node root1, Node root2)  
//     {
//         ArrayList<Integer> res = new ArrayList<Integer>();
//         Stack<Node> stack1 = new Stack<Node> (); 
//         Stack<Node> s1 = new Stack<Node> ();  
//         Stack<Node> s2 = new Stack<Node> (); 

//         while (true)
//         {  
//             // push the Nodes of first tree in stack s1  
//             if (root1 != null)  
//             {  
//                 s1.push(root1);  
//                 root1 = root1.left;  
//             }  
      
//             // push the Nodes of second tree in stack s2  
//             else if (root2 != null)  
//             {  
//                 s2.push(root2);  
//                 root2 = root2.left;  
//             }  
      
//             // Both root1 and root2 are NULL here  
//             else if (!s1.isEmpty() && !s2.isEmpty())  
//             {  
//                 root1 = s1.peek();  
//                 root2 = s2.peek();  
      
//                 // If current keys in two trees are same  
//                 if (root1.data == root2.data)  
//                 {  
//                     res.add(root1.data);  
//                     s1.pop();  
//                     s2.pop();  
      
//                     // move to the inorder successor  
//                     root1 = root1.right;  
//                     root2 = root2.right;  
//                 }  
      
//                 else if (root1.data < root2.data)  
//                 {  
//                     // If Node of first tree is smaller, than that of  
//                     // second tree, then its obvious that the inorder  
//                     // successors of current Node can have same value  
//                     // as that of the second tree Node. Thus, we pop  
//                     // from s1
//                     s1.pop();  
//                     root1 = root1.right;  
      
//                     // root2 is set to NULL, because we need  
//                     // new Nodes of tree 1  
//                     root2 = null;  
//                 }  
//                 else if (root1.data > root2.data)  
//                 {  
//                     s2.pop();  
//                     root2 = root2.right;  
//                     root1 = null;  
//                 }  
//             }  
      
//             // Both roots and both stacks are empty  
//             else break;  
//         } 
    
//         return res;    
//     }
// }

