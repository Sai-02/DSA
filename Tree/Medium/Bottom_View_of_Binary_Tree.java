
/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if
 it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root,
 then print the later one in level traversal. For example, 
 in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0,
  we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
 

Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2.

Thus nodes of the binary tree will be
printed as such 3 1 2.
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
Your Task:
This is a functional problem, 
you don't need to care about input,
 just complete the function bottomView()
  which takes the root node of the tree as input 
  and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
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

public class Bottom_View_of_Binary_Tree {

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
            Tree6 g = new Tree6();
            ArrayList<Integer> res = g.bottomView(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

// class Node
// {
// int data; //data of the node
// int hd; //horizontal distance of the node
// Node left, right; //left and right references

// // Constructor of tree node
// public Node(int key)
// {
// data = key;
// hd = Integer.MAX_VALUE;
// left = right = null;
// }
// }

class Tree6 {
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> level = new ArrayList<>();

    int leftCount = 0, rightCount = 0;

    // Method that returns the bottom view.
    public ArrayList<Integer> bottomView(Node root) {
        a.removeAll(a);
        findDistance(root, 0);
        for (int i = 0; i < Math.abs(leftCount) + rightCount + 1; i++) {
            a.add(0);
            level.add(-1);
        }
        solver(root, 0);
        return a;

    }

    public void findDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        leftCount = Math.min(leftCount, distance);
        rightCount = Math.max(rightCount, distance);
        root.hd = distance;
        findDistance(root.right, distance + 1);
        findDistance(root.left, distance - 1);
    }

    public void solver(Node root, int currLevel) {
        if (root == null) {
            return;
        }
        solver(root.left, currLevel + 1);
        if (currLevel >= level.get(root.hd + Math.abs(leftCount))) {

            a.set(root.hd + Math.abs(leftCount), root.data);
            level.set(root.hd + Math.abs(leftCount), currLevel);
        }

        solver(root.right, currLevel + 1);

    }
}


// =============================
// 
// GFG Editorial
// 
// =============================


// Method 1 – Using Queue:
// The following are steps to print Bottom View of Binary Tree.
// 1. We put tree nodes in a queue for the level order traversal.
// 2. Start with the horizontal distance(hd) 0 of the root node,
//  keep on adding left child to queue along with the horizontal distance as hd-1 
//  and right child as hd+1.
// 3. Also, use a TreeMap which stores key value pair sorted on key.
// 4. Every time, we encounter a new horizontal distance or an existing horizontal 
// distance put the node data for the horizontal distance as key. For the first time
//  it will add to the map, next time it will replace the value. This will make sure 
//  that the bottom most element for that horizontal distance is present in the map 
//  and if you see the tree from beneath that you will see that element.


// OR

// Method 2 (Using HashMap):
// Create a map like, map where key is the horizontal distance and value is a pair(a, b)
//  where a is the value of the node and b is the height of the node. Perform a pre-order
//   traversal of the tree. If the current node at a horizontal distance of h is the first
//    we’ve seen, insert it in the map. Otherwise, compare the node with the existing one 
//    in map and if the height of the new node is greater, update in the Map.




// class Tree
// {
 
//     // Method that prints the bottom view.
//     public ArrayList <Integer> bottomView(Node root)
//     {
//         ArrayList <Integer> res = new ArrayList <Integer>(0);
//         if (root == null)
//             return res; 
 
//         // Initialize a variable 'hd' with 0 for the root element.
//         int hd = 0;
 
//         // TreeMap which stores key value pair sorted on key value
//         Map<Integer, Integer> map = new TreeMap<>();
 
//          // Queue to store tree nodes in level order traversal
//         Queue<Node> queue = new LinkedList<Node>();
 
//         // Assign initialized horizontal distance value to root
//         // node and add it to the queue.
//         root.hd = hd;
//         queue.add(root);
 
//         // Loop until the queue is empty (standard level order loop)
//         while (!queue.isEmpty())
//         {
//             Node temp = queue.remove();
 
//             // Extract the horizontal distance value from the
//             // dequeued tree node.
//             hd = temp.hd;
 
//             // Put the dequeued tree node to TreeMap having key
//             // as horizontal distance. Every time we find a node
//             // having same horizontal distance we need to replace
//             // the data in the map.
//             map.put(hd, temp.data);
 
//             // If the dequeued node has a left child add it to the
//             // queue with a horizontal distance hd-1.
//             if (temp.left != null)
//             {
//                 temp.left.hd = hd-1;
//                 queue.add(temp.left);
//             }
//             // If the dequeued node has a left child add it to the
//             // queue with a horizontal distance hd+1.
//             if (temp.right != null)
//             {
//                 temp.right.hd = hd+1;
//                 queue.add(temp.right);
//             }
//         }
 
//         // Extract the entries of map into a set to traverse
//         // an iterator over that.
//         Set<Map.Entry<Integer, Integer>> set = map.entrySet();
 
//         // Make an iterator
//         Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
 
//         // Traverse the map elements using the iterator.
//         while (iterator.hasNext())
//         {
//             Map.Entry<Integer, Integer> me = iterator.next();
//             res.add(me.getValue());
//         }
//         return res;
//     }
// }
