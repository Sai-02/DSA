
/*
Given a Binary Search Tree of size N, find the Median of its Node values.

Example 1:

Input:
       6
     /   \
   3      8   
 /  \    /  \
1    4  7    9
Output: 6
Explanation: Inorder of Given BST will be:
1, 3, 4, 6, 7, 8, 9. So, here median will 6.

Example 2:

Input:
       6
     /   \
   3      8   
 /   \    /   
1    4   7   
Output: 5
Explanation:Inorder of Given BST will be:
1, 3, 4, 6, 7, 8. So, here median will
(4 + 6)/2 = 10/2 = 5.
 

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function findMedian()
 which takes the root of the Binary Search Tree as 
 input and returns the Median of Node values in the given BST.
Median of the BST is:

If number of nodes are even: then median = (N/2 th node + (N/2)+1 th node)/2
If number of nodes are odd : then median = (N+1)/2th node.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).


Constraints:
1<=N<=1000
 */
// { Driver Code Starts
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

public class Median_of_BST {

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

            Tree g = new Tree();
            g.findMedian(root);
            System.out.println();
            t--;

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Tree {
    static ArrayList<Integer> inOrder = new ArrayList<>();

    public static void findMedian(Node root) {
        inOrder.clear();
        inOrderTraversal(root);
        int n = inOrder.size();
        if (n == 2) {
            int ans = inOrder.get(0) + inOrder.get(1);
            if (ans % 2 == 0) {

                System.out.print((ans / 2));
            } else {
                System.out.print((ans / 2.0));
            }
            // System.out.println("fwefewilfn");
            return;
        }
        if ((n & 1) == 1) {
            System.out.print(inOrder.get(n / 2));
        } else {
            int ans = inOrder.get(n / 2) + inOrder.get((n / 2) - 1);
            if (ans % 2 == 0) {

                System.out.print((ans / 2));
            } else {
                System.out.print((ans / 2.0));
            }

        }
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrder.add(root.data);
        inOrderTraversal(root.right);
    }

}


// ===============================
// 
//  GFG Editorial
// 
// =================================

// Store inorder traversal of BST  in a data struture



// class Tree
// {
    

// public static int countNodes(Node n)
// {
//     // this function returns number of nodes in tree
//     if(n==null) return 0;
//     return 1 + countNodes(n.left) + countNodes(n.right);
// }

// public static int find(Node n, int serialNo, int target, int value[])
// {
//     // this function keeps track of serial number while doing
//     // inorder traveresal and finds the target node
    
//     if(n==null) return serialNo;
//     serialNo = find(n.left, serialNo, target, value);
    
//     serialNo++;
//     // current value of serialNo variable is the rank of
//     // current Node
//     if(serialNo==target) value[0] = n.data;
    
//     serialNo = find(n.right, serialNo, target, value);
//     return serialNo;
// }

// public static void findMedian(Node root)
// {
//     int n = countNodes(root);
    
//     if(n%2!=0)
//     {
//         // odd number of nodes in tree:
//         // 1+n/2 is the rank of mid node
        
//         int mid[] = new int[1];
//         mid[0] = 0;
//         find( root, 0, 1+n/2, mid );
//         System.out.print(mid[0]);
//     }
//     else
//     {
//         // even number of nodes in tree:
//         // n/2 and 1+n/2 are the ranks of mid nodes
        
//         int mid1[] = new int[1];
//         int mid2[] = new int[1];
//         mid1[0] = 0;
//         mid2[0] = 0;
//         find( root, 0, n/2, mid1 );
//         find( root, 0, 1+n/2, mid2 );
//         if( (mid1[0]+mid2[0])%2 == 0)
//             System.out.print((mid1[0]+mid2[0])/2);
//         else    
//             System.out.print(((float)(mid1[0]+mid2[0])/2) );
//     }
// }

// }

