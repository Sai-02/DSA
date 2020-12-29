/*
Given a binary tree and a integer value K,
 the task is to find all nodes data in given binary tree having exactly
  K leaves in sub-tree rooted with them.

NOTE: Nodes should be printed in the order in which they appear in postorder traversal.

Example 1:

Input:
K = 1
      0
    /   \
   1     2
Output: -1
Explanation: There is no node in this
tree which has one leaf in the sub tree
below it.
Example 2:

Input:
K = 2
          0
        /   \
       1     2
           /  
          4
        /   \
       5     9
Output: 4 2
Explanation: Nodes with data 2 and 4, have
2 leaves in the subtree below it.
Your Task:
Just complete the function btWithKleaves()
 and returns the answer (as a vector<int> in cpp,
  as a ArrayList<Integer> in java and as list in python)

Note: If no node is found the list returned should contain only one value -1.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 1000
1 <= K <= 1000
1 <= value of nodes <= 10000
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

class Main {
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
            int k = Integer.parseInt(br.readLine());

            String s = br.readLine();
            Node root = buildTree(s);

            GfG2 g = new GfG2();
            ArrayList<Integer> nodes = g.btWithKleaves(root, k);
            for (int i = 0; i < nodes.size(); i++) {
                System.out.print(nodes.get(i) + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right; Node(int d){ data=d; left=right=null; } }
 */

class GfG2{
    ArrayList<Integer> a = new ArrayList<>();

    public ArrayList<Integer> btWithKleaves(Node root, int k) {
        a.removeAll(a);
        findTotalLeaf(root, k);
        if (a.size() == 0) {
            a.add(-1);
        }
        return a;

    }

    public int findTotalLeaf(Node root, int k) {
        if (root == null) {
            return 0;
        }
        if (checkLeaf(root)) {
            return 1;
        }
        int left = findTotalLeaf(root.left, k);
        int right = findTotalLeaf(root.right, k);
        if (left + right == k) {
            a.add(root.data);

        }
        return left + right;

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



// ===============================
// 
//  GFG Editorial
// 
// ==============================


// class GfG
// {
//     public static int flag=0;
// 	public ArrayList<Integer> btWithKleaves(Node root, int k)
// 	{
// 		flag=0;
// 		ArrayList<Integer> nodes = new ArrayList<Integer>();
// 		kleaves(root,k,nodes);
// 		if(flag==0){
// 		    nodes.clear();
// 		    nodes.add(-1);
// 		}
		
// 		return nodes;
// 	}
// 	public static int kleaves(Node root,int k,ArrayList<Integer> nodes)
// 	{
// 		if(root==null)
// 			return 0;
// 		if(root.left==null&&root.right==null)
// 			return 1;
// 		int total=kleaves(root.left,k,nodes)+kleaves(root.right,k,nodes);
// 		if(k==total)
// 		{
// 			nodes.add(root.data);
// 		    flag=1;
// 		}
// 		return total;
// 	}
// }