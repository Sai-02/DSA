/*

Given a Binary Tree of size N,
 you need to find all the possible paths from root node to all the leaf node's 
 of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 1 2 #1 3 #
Explanation: 
All possible paths:
1->2
1->3

Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 10 20 40 #10 20 60 #10 30 #

Your Task:
Your task is to complete the function Paths() 
that takes the root node as an argument and return all the possible path.
 (All the path are printed '#' separated by the driver's code.)

Note: The return type
cpp: vector<vector<int>
java: ArrayList<ArrayList<Integer>>
python: list of list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1<=N<=103
 */

// { Driver Code Starts
// Initial Template for Java

// Contributed by Sudarshan Sharma
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data; // data of the node
    int hd; // horizontal distance of the node
    Node left, right; // left and right references

    // Constructor of tree node
    public Node(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

public class Root_to_Leaf_Paths {

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
            String s = br.readLine();
            Node root = buildTree(s);
            Tree24 g = new Tree24();
            ArrayList<ArrayList<Integer>> paths = g.Paths(root);
            for (int i = 0; i < paths.size(); i++) {
                ArrayList<Integer> temp = paths.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    System.out.print(temp.get(j) + " ");
                }
                System.out.print("#");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * 
 * class Node{ int data; Node left,right; Node(int d){ data=d; left=right=null;
 * } }
 * 
 */
class Tree24 {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> a = new ArrayList<>();
    int length = 0;

    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        if (root == null) {
            return ans;
        }
        solver(root);

        return ans;

    }

    public void solver(Node root) {
        if (root == null) {
            return;
        }
        if (checkLeaf(root)) {
            a.add(root.data);
            length++;
            ArrayList<Integer> b = new ArrayList<Integer>();
            for (int i = 0; i < length; i++) {
                b.add(a.get(i));

            }

            ans.add(b);
            if (a.size() != 0) {

                a.remove(a.size() - 1);
                length--;
            }
            return;

        }

        a.add(root.data);
        length++;
        solver(root.left);
        solver(root.right);
        if (a.size() != 0) {

            a.remove(a.size() - 1);
            length--;
        }

    }

    public boolean checkLeaf(Node root) {
        if (root == null) {
            return false;

        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;

    }

}



// ============================================
// 
//  GFG Editorial
// 
// ============================================

// Use a path array path[] to store current root to leaf path.
//  Traverse from root to all leaves in top-down fashion. While traversing,
//   store data of all nodes in current path in array path[].
//  When we reach a leaf node, print the path array.


// class Tree{
//     public ArrayList<ArrayList<Integer>> Paths(Node root){
//         int[] path=new int[1000];
//         ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
//         printPathsRecur(root, path, 0,paths);
//         return paths;
//     }
    
//     public static void printPathsRecur(Node root,int[] path, int pathLen,ArrayList<ArrayList<Integer>> paths){
//         if(root==null)
//             return;
//         path[pathLen]=root.data;
//         pathLen++;
//         if(root.left==null&&root.right==null){
//             paths.add(printArray(path,pathLen));
            
//         }
//         else{
//             printPathsRecur(root.left,path,pathLen,paths);
//             printPathsRecur(root.right,path,pathLen,paths);
//         }
//     }
    
//     public static ArrayList<Integer> printArray(int[] path,int l){
//         ArrayList<Integer> p = new ArrayList<Integer>();
//         for(int i=0;i<l;i++)
//         p.add(path[i]);
//         return p;
//     }
// }