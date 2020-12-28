/*
Given two binary trees with head reference as T and S having at most N nodes.
 The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all 
of its descendants in T1.

Example:

S:          10
              /   \
            4     6
                 /
             30

T:                  26
                      /   \
                    10   3
                   /   \     \

               4       6     3
                       /
                    30

In above example S is subtree of T.

Please note that subtree has to be having same leaves non leaves.

   10
  /
20

For example, above tree is not subtree of

         10
       /     \
    20     50
   /   \
30   40

But a subtree of

         30
       /     \
    10     50
   /  
20  

Example 1:

Input:
T:      1          S:   3
      /   \            /
     2     3          4
   /  \    /
  N    N  4
Output: 1

Example 2:

Input:
T:      26         S:   26
       /   \           /  \
     10     N        10    N
   /    \           /  \
   20    30        20  30
  /  \            /  \
 40   60         40  60
Output: 1
Your Task:
Complete the function isSubtree() 
that takes two nodes as parameter and returns true or false.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 104
1 <= Value of nodes <= 104
 */

//{Driver Code Starts
//Initial Template for Java

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

public class Check_if_subtree {

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
        while (t-- > 0) {
            String tt = br.readLine();
            Node rootT = buildTree(tt);

            String s = br.readLine();
            Node rootS = buildTree(s);
            // printInorder(root);

            Tree9 tr = new Tree9();
            boolean st = tr.isSubtree(rootT, rootS);
            if (st == true) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}// } Driver Code Ends

// User function Template for Java

/* complete the given function */

/*
 * class Node{ int data; Node left,right; Node(int d) { data=d; left=null;
 * right=null; } }
 */

class Tree9 {
    static boolean ans = false;

    public static boolean isSubtree(Node T, Node S) {
        ans = false;
        find(T, S);
        return ans;
    }

    public static void find(Node T, Node S) {
        if (T == null) {
            return;
        }
        if (T.data == S.data) {
            ans = ans || checkSame(T, S);
            if (ans) {
                return;
            }
        }
        find(T.left, S);
        find(T.right, S);
    }

    public static boolean checkSame(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && checkSame(root1.left, root2.left) && checkSame(root1.right, root2.right);

    }
}


// ==================================
// 
//  GFG Editorial
// 
// =================================


/* Following are detailed steps.

1) Find inorder and preorder traversals of T, 
store them in two auxiliary arrays inT[] and preT[].

2) Find inorder and preorder traversals of S,
 store them in two auxiliary arrays inS[] and preS[].

3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[],
 then S is a subtree of T. Else not.

Also,

The above algorithm doesn't work for cases where a tree is present
in another tree, but not as a subtree. Consider the following example.

        Tree1
          x 
        /    \
      a       b
     /        
    c         


        Tree2
          x 
        /    \
      a       b
     /         \
    c            d

Inorder and Preorder traversals of the big tree or Tree2 are.

Inorder and Preorder traversals of small tree or Tree1 are

The Tree2 is not a subtree of Tree1, but inS[] and preS[] are
subarrays of inT[] and preT[] respectively.
The above algorithm can be extended to handle such cases by adding a 
special character whenever we encounter NULL in inorder and preorder traversals.

 */



// class Tree {
//     public static boolean areIdentical(Node root1, Node root2) {
//         // base case
//         if (root1 == null && root2 == null) return true;

//         // if any of the root is null
//         if (root1 == null || root2 == null) return false;

//         // recurse for left and right subtree
//         return (root1.data == root2.data &&
//                 areIdentical(root1.left, root2.left) &&
//                 areIdentical(root1.right, root2.right));
//     }

//     /* This function returns true if S is a subtree of T, otherwise false */
//     public static boolean isSubtree(Node T, Node S) {
//         /* base cases */
//         if (S == null) return true;

//         if (T == null) return false;

//         /* Check the tree with root as current node */
//         if (areIdentical(T, S)) return true;

//         /* If the tree with root as current node doesn't match then
//            try left and right subtrees one by one */
//         return isSubtree(T.left, S) || isSubtree(T.right, S);
//     }
// }