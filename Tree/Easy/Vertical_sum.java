/*
Given a Binary Tree,
 find vertical sum of the nodes that are in same vertical line.
  Print all sums through different vertical lines starting from
   left-most vertical line to right-most vertical line.

Example 1:

Input:
       1
    /   \
  2      3
 / \    / \
4   5  6   7
Output: 
Explanation:
The tree has 5 vertical lines
Vertical-Line-1 has only one node
4 => vertical sum is 4
Vertical-Line-2: has only one node
2=> vertical sum is 2
Vertical-Line-3: has three nodes:
1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3
=> vertical sum is 3
Vertical-Line-5: has only one node 7
=> vertical sum is 7
Your Task:
You don't need to take input.
 Just complete the function verticalSum()
  that takes root node of the tree as parameter 
  and returns an array containing the vertical sum of tree from left to right.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
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

public class Vertical_sum {

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
            Tree30 g = new Tree30();

            ArrayList<Integer> res = g.verticalSum(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left, right; Node(int item) { data = item; left = right = null } }
 */

class Tree30 {
    ArrayList<Integer> a = new ArrayList<>();
    int leftCount = 0, rightCount = 0;

    public ArrayList<Integer> verticalSum(Node root) {
        a.removeAll(a);
        findDistance(root, 0);
        for (int i = 0; i < Math.abs(leftCount) + rightCount + 1; i++) {
            a.add(0);
        }
        int k = Math.abs(leftCount);
        findSum(root, k);
        return a;

    }

    public void findDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        leftCount = Math.min(leftCount, distance);
        rightCount = Math.max(rightCount, distance);
        findDistance(root.right, distance + 1);
        findDistance(root.left, distance - 1);
    }

    public void findSum(Node root, int index) {
        if (root == null) {
            return;
        }

        a.set(index, a.get(index) + root.data);
        findSum(root.right, index + 1);
        findSum(root.left, index - 1);

    }

}
