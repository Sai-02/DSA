/*
Given a Binary Tree, your task is to find its level order traversal.
For the below tree the output will be 1 $ 2 3 $ 4 5 6 7 $ 8 $.

          1
       /     \
     2        3
   /    \     /   \
  4     5   6    7
    \
     8

Example 1:

Input:
          1
        /
       4
     /   \
    4     2
Output:1 $ 4 $ 4 2 $

Example 2:

Input:
            10
          /    \
        20      30
     /     \
    40     60
Output: 10 $ 20 30 $ 40 60 $
Your Task:
This is a function problem.
 You don't need to read input.
  Just complete the function levelOrder()
   that takes nodes as parameter and returns level order traversal as a 2D list.

Note: The driver code prints the levels '$' separated.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of edges <= 1000
0 <= Data of a node <= 100
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

public class Level_order_traversal_Line_by_Line {

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
            Level_Order_Traverse g = new Level_Order_Traverse();
            ArrayList<ArrayList<Integer>> result = g.levelOrder(root);
            for (ArrayList<Integer> values : result) {
                for (int value : values) {
                    System.out.print(value + " ");
                }
                System.out.print("$ ");
            }
            System.out.println();
            t--;

        }
    }

}// } Driver Code Ends

/*
 * class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class Level_Order_Traverse {
    static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.peek() == null) {
                    break;
                }
                ArrayList<Integer> b = new ArrayList<>();
                int n = a.size();
                for (int i = 0; i < n; i++) {
                    b.add(a.get(i));

                }
                ans.add(b);
                a.removeAll(a);
                q.add(null);

            } else {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                a.add(temp.data);
            }
        }
        ans.add(a);
        return ans;

    }
}




// =======================================
// 
//  GFG Editorial
// 
// =======================================


// class Level_Order_Traverse
// {
// 	  static ArrayList<ArrayList<Integer>> levelOrder(Node node) 
//       {
//           // initializing queue
// 		  Queue<Node> q = new LinkedList<>();
// 		  q.add(node);
// 		  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		  
// 		  while(true)
// 		  {
// 		      int size = q.size();
// 		      if(size == 0)
// 		         break;
// 		       // while queue is not empty
// 		       ArrayList<Integer> level = new ArrayList<Integer>();
// 		       while(size >0)
// 		       {
// 		           // pick the front element from queue
// 		           node = q.peek();
		           
// 		           // pop the element too
// 		           q.poll();
// 		           level.add(node.data);
		           
		           
// 		           // if left child exists
//                    // push it into exists
// 		           if(node.left != null)
// 		            q.add(node.left);
		            
// 		           // if right child exists
//                    // push it into exists
// 		           if(node.right != null)
// 		            q.add(node.right);
// 		            size--;
// 		       }
// 		       result.add(level);
// 		  }
// 		  return result;
 
// 	  }
    
// }