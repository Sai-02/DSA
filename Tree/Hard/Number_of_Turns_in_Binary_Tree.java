/*
Given a binary tree and data value of two of its nodes. 
Find the number of turns needed to reach from one node to another
 in the given binary tree.

Example 1:

Input :      
Tree = 
           1
        /    \
       2       3
     /  \     /  \
    4    5   6    7                        
   /        / \                        
  8        9   10   

first node = 5
second node = 10

Output: 4

Explanation : 
Turns will be at 2, 1, 3, 6.

Example 2:

Input :      
Tree = 
           1
        /     \
       2        3
     /  \      /  \
    4    5    6    7                        
   /         / \                        
  8         9   10   

first node = 1
second node = 4  

Output : -1

Explanation: No turn is required since 
they are in a straight line.

Your Task:  
You don't need to read input or print anything. 
Complete the function NumberOFTurns()
 which takes root node and data value of 2 nodes as input parameters 
 and returns number of turns required to navigate between them. 
 If the two nodes are in a straight line,
  ie- the path does not involve any turns, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 10^3
 */

// { Driver Code Starts
//Initial template for Java

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

public class Number_of_Turns_in_Binary_Tree {

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

            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Tree g = new Tree();
            if ((turn = g.NumberOfTurns(root, nd1, nd2)) != 0)
                System.out.println(turn);
            else
                System.out.println("-1");
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java
/*
 * Node defined as class Node{ int data; Node left,right; Node(int d){ data=d;
 * left=right=null; } }
 */
class Path {
    boolean left;
    int data;

    Path(int data, boolean left) {
        this.data = data;
        this.left = left;
    }

}

class Tree {
    static int NumberOfTurns(Node root, int first, int second) {
        ArrayList<Path> path1 = new ArrayList<>();
        ArrayList<Path> path2 = new ArrayList<>();
        hasPath(root, path1, first, true);
        hasPath(root, path2, second, true);
        int n1 = path1.size();
        int n2 = path2.size();

        int i = 0;
        try {

            while (path1.get(i).data == path2.get(i).data) {
                path1.remove(i);
                path2.remove(i);

            }
            Collections.reverse(path2);
        } catch (Exception e) {
            int some;
        }

        path2.addAll(path1);
        int count = 0;
        n2 = path2.size();
        for (i = 1; i < n2; i++) {
            if (Boolean.compare(path2.get(i - 1).left, path2.get(i).left) != 0) {

                count++;
            }

        }
        if (count == 0) {
            count = -1;
        }
        return count;

    }

    public static boolean hasPath(Node root, ArrayList<Path> path, int key, boolean left) {

        if (root == null) {

            return false;
        }
        Path newPath = new Path(root.data, left);

        path.add(newPath);

        if (root.data == key) {

            return true;
        }

        if (hasPath(root.left, path, key, true) || hasPath(root.right, path, key, false)) {

            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}



// =================================
// 
//  GFG Editorial
// 
// =================================


// Find the LCA of given two node.
// If none of the 2 nodes is equal to LCA this means that one lies on the left side of LCA
//  and the other on right side.
//  Count the number of turns needed to reach LCA from both sides and then sum their count. 
// If one of the nodes is equal to LCA then
//  we only need to count the turns needed for the other node to reach the LCA. 


// class Tree
// {
    
//    static int Count;
//    static Node findLCA(Node root, int n1, int n2) {
       
//         if (root == null)
//             return null;
 
       
//         if (root.data == n1 || root.data == n2)
//             return root;
 
       
//         Node left_lca = findLCA(root.left, n1, n2);
//         Node right_lca = findLCA(root.right, n1, n2);
 
       
//         if (left_lca != null && right_lca != null)
//             return root;
 
      
//         return (left_lca != null) ? left_lca : right_lca;
//     }
//    static boolean CountTurn(Node root, int key, boolean turn) {
//         if (root == null)
//             return false;
 
        
//         if (root.data == key)
//             return true;
 
       
//         if (turn == true) {
//             if (CountTurn(root.left, key, turn))
//                 return true;
//             if (CountTurn(root.right, key, !turn)) {
//                 Count += 1;
//                 return true;
//             }
//         } else
//         {
//             if (CountTurn(root.right, key, turn))
//                 return true;
//             if (CountTurn(root.left, key, !turn)) {
//                 Count += 1;
//                 return true;
//             }
//         }
//         return false;
//     }
    
    
//    static int NumberOfTurns(Node root, int first, int second)
//     {
//         Node LCA = findLCA(root, first, second);
 
       
//         if (LCA == null)
//             return -1;
//         Count = 0;
 
        
//         if (LCA.data != first && LCA.data != second) {
 
//              // count number of turns needs to reached
//             // the second node from LCA
//             if (CountTurn(LCA.right, second, false)
//                     || CountTurn(LCA.left, second, true));
 
//              // count number of turns needs to reached 
//              // the first node from LCA
//             if (CountTurn(LCA.left, first, true)
//                     || CountTurn(LCA.right, first, false));
//             return Count + 1;
//         }
 
       
//         // count number of turns needs to reach 
//         // the second node from LCA
//         if (LCA.data == first) {
 
           
//             CountTurn(LCA.right, second, false);
//             CountTurn(LCA.left, second, true);
//             return Count;
//         } else {
 
//             // count number of turns needs to reached
//             // the first node from LCA1 
//             CountTurn(LCA.right, first, false);
//             CountTurn(LCA.left, first, true);
//             return Count;
//         }
//     }
// }