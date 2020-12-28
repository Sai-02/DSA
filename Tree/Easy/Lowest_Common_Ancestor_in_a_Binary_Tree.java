/*
Given a Binary Tree with all unique values and two nodes value n1 and n2. 
The task is to find the lowest common ancestor of the given two nodes. 
We may assume that either both n1 and n2 are present in the tree or none of them is 
present



Example 1:

Input:
n1 = 2 , n2 =  3

     1
   /  \
  2    3
Output: 1

Example 2:

Input:
n1 = 3 , n2 = 4

         5
        /
       2
     /  \
    3    4
Output: 2
Your Task:
 Just complete the function lca() that takes nodes,
  n1, and n2 as parameters and returns LCA node as output.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 
 */

// { Driver Code Starts
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

public class Lowest_Common_Ancestor_in_a_Binary_Tree {

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
            String input[] = br.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            String s = br.readLine();
            Node root = buildTree(s);
            Tree36 g = new Tree36();
            Node k = g.lca(root, a, b);
            System.out.println(k.data);

        }
    }
}
// } Driver Code Ends

/*
 * A Binary Tree node class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */

class Tree36 {
    ArrayList<Node> a1 = new ArrayList<>();

    ArrayList<Node> b1 = new ArrayList<>();
    ArrayList<Node> temp = new ArrayList<>();

    Node lca(Node root, int a, int b) {
        a1.removeAll(a1);
        b1.removeAll(b1);
        temp.removeAll(temp);
        addDistance(root, a, 'a');
        temp.removeAll(temp);
        addDistance(root, b, 'b');
        Node lca = null;
        int k = Math.min(a1.size(), b1.size());
        for (int i = 0; i < k; i++) {
            if (a1.get(i) == b1.get(i)) {
                lca = a1.get(i);
            } else {
                break;
            }
        }
        if (lca == null) {
            lca = new Node(-1);
        }
        return lca;

    }

    void addDistance(Node root, int key, char choice) {
        if (root == null) {
            return;
        }
        if (root.data == key) {
            temp.add(root);
            int n = temp.size();
            if (choice == 'a') {
                for (int i = 0; i < n; i++) {
                    a1.add(temp.get(i));
                }

            } else {
                for (int i = 0; i < n; i++) {
                    b1.add(temp.get(i));
                }
            }
            return;
        }
        temp.add(root);

        if (root.left != null) {

            addDistance(root.left, key, choice);
            temp.remove(root.left);
        }
        if (root.right != null) {

            addDistance(root.right, key, choice);
            temp.remove(root.right);
        }
    }
}


// ===================================
// 
//  GFG Editorial
// 
// ====================================


// Following is simple O(n) algorithm to find LCA of n1 and n2.
// 1) Find path from root to n1 and store it in a vector or array.
// 2) Find path from root to n2 and store it in another vector or array.
// 3) Traverse both paths till the values in arrays are same. 
// Return the common element just before the mismatch.

// class Tree
// {
// 	Node lca(Node root, int n1,int n2)
// 	{
// 	    // base case
// 		if(root==null)
// 			return null;
		
// 		// If either n1 or n2 matches with root's key, report 
//         // the presence by returning root (Note that if a key is 
//         // ancestor of other, then the ancestor key becomes LCA
// 		if(root.data==n1 || root.data==n2)
// 			return root;
		
// 		// Look for keys in left and right subtrees 	
// 		Node l = lca(root.left,n1,n2);
// 		Node r = lca(root.right,n1,n2);
		
// 		// If both of the above calls return Non-NULL, then one key 
//         // is present in once subtree and other is present in other, 
//         // So this node is the LCA
// 		if(l != null && r != null)
// 			return root;
			
		
// 		// Otherwise check if left subtree or right subtree is LCA
// 		return(l!=null)?l:r;
// 	}
// }
