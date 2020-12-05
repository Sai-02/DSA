
/*
Given a Binary Tree and a target key,
 you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1
Example 1:

Input:
        1
      /   \
     2     3
target = 2
Output: 1

Example 2:

Input:
         1
       /   \
      2     3
    /  \   /  \
   4    5 6    8
  /
 7
target = 7
Output: 4 2 1
 

Your Task:
Your task is to complete the function Ancestors()
 that finds all the ancestors of the key in the given binary tree.
Note:
The return type is
cpp: vector<int>
Java: ArrayList<Integer>
python: list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <= N <= 1000
1<= data of node <= 10000
 */

// { Driver Code Starts
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

public class Ancestors_in_Binary_Tree {
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

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int target = Integer.parseInt(br.readLine());

            GfG25 g = new GfG25();
            ArrayList<Integer> nodes = g.Ancestors(root, target);
            for (int i = 0; i < nodes.size(); i++) {
                System.out.print(nodes.get(i) + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

/*
 * class Node of the binary tree class Node { int data; Node left, right;
 * Node(int key) { data = key; left = right = null; } }
 */
class GfG25 {
    static Stack<Integer> a = new Stack<Integer>();
    static ArrayList<Integer> b = new ArrayList<>();

    public static ArrayList<Integer> Ancestors(Node root, int x) {
        int n = b.size();
        while (!b.isEmpty()) {
            b.remove(n - 1);
            n--;
        }

        findKey(root, x);

        return b;

    }

    public static void findKey(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.data == key) {

            while (!a.empty()) {

                b.add(a.pop());
            }

            return;
        }
        a.push(root.data);
        findKey(root.left, key);
        findKey(root.right, key);
        if (!a.empty()) {

            a.pop();
        }

    }
}


// ==========================================
// 
//  GFG Editorial
// 
// ===========================================


// recurse to left and right children to find the target key and if found, print the node.


// class GfG
// {
    
//     public static boolean AncestorsUtil(Node node, int target,ArrayList<Integer> nodes)
//     {
//         if (node == null)
//             return false;
//         if (node.data == target)
//             return true;
        
//         if ( AncestorsUtil(node.left, target,nodes) || AncestorsUtil(node.right, target,nodes) )
//         {
//             nodes.add(node.data);
//             return true;
//         }
//         return false;
//     }
    
//     public static ArrayList<Integer> Ancestors(Node node, int x)
//     {
//         ArrayList<Integer> nodes = new ArrayList<Integer>();
//         AncestorsUtil(node,x,nodes);
//         return nodes;
//     }
// }
