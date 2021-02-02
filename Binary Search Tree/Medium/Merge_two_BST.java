/*

 */

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Merge_two_BST {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// class Node
// {
// int data;
// Node left, right;

// public Node(int d)
// {
// data = d;
// left = right = null;
// }
// }
// ===============================
// 
// Solution using extra space
// 
// ===============================
class Solution {
    // Return a integer of integers having all the nodes in both the BSTs in a
    // sorted order.

    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        getInorder(a1, root1);
        getInorder(a2, root2);
        int i = 0, j = 0;
        int n1 = a1.size();
        int n2 = a2.size();
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n1 || j < n2) {
            if (i >= n1) {
                ans.add(a2.get(j));
                j++;
            } else if (j >= n2) {
                ans.add(a1.get(i));
                i++;
            } else if (a1.get(i) < a2.get(j)) {
                ans.add(a1.get(i));
                i++;
            } else {
                ans.add(a2.get(j));
                j++;

            }
        }
        return ans;

    }

    void getInorder(ArrayList<Integer> a, Node root) {
        if (root == null) {
            return;
        }
        getInorder(a, root.left);
        a.add(root.data);
        getInorder(a, root.right);
    }

}

// =============================
// 
//  GFG Editorial
// 
// ================================

// The idea is to use iterative inorder traversal. 
// We use two auxiliary stacks for two BSTs.
//  Since we need to print the elements in sorted form
//  , whenever we get a smaller element from any of the trees, we print it.
//  If the element is greater, then we push it back to stack for the next iteration.



// class Solution{
    
//     List<Integer> ans = new ArrayList<>();
    
//     public void inorder(Node root)
//     {
//         if(root==null)  return;
        
//         inorder(root.left);
//         ans.add(root.data);
//         inorder(root.right);
//     }
    
//     // Return the value of leftmost node
//     public Node minValueNode(Node nod)
//     {
//         Node current = nod;
//         while(current.left != null)
//             current = current.left;
//         return current;
//     }
    
    
//     public List<Integer> merge(Node root1,Node root2)
//     {
//         Stack<Node> s1 = new Stack<>();
//         Stack<Node> s2 = new Stack<>();
//         Node temp1 = root1,temp2 = root2;
        
//         ans.clear();
        
//         // If only one tree is present
//         // If root1 is null
//         if(root1==null)
//         {
//             inorder(root2);
//             return ans;
//         }
//         // If root2 is null
//         if(root2==null)
//         {
//             inorder(root1);
//             return ans;
//         }
        
//         // Iterative inorder traversal of both trees
//         while(temp1!=null || !s1.isEmpty() || temp2!=null || !s2.isEmpty())
//         {
//             if(temp1!=null || temp2!=null)
//             {
//                 if(temp1!=null)
//                 {
//                     s1.push(temp1);
//                     temp1 = temp1.left;
//                 }
                
//                 if(temp2!=null)
//                 {
//                     s2.push(temp2);
//                     temp2 = temp2.left;
//                 }
//             }
//             else 
//             {
//                 if(s1.empty())
//                 {
//                     while(!s2.empty())
//                     {
//                         temp2  = s2.peek();
//                         s2.pop();
//                         temp2.left= null;
//                         inorder(temp2);
//                     }
//                     return ans;
//                 }
                
//                 if(s2.empty())
//                 {
//                     while(!s1.empty())
//                     {
//                         temp1  = s1.peek();
//                         s1.pop();
//                         temp1.left = null;
//                         inorder(temp1);
//                     }
//                     return ans;
//                 }
                
//                 temp1 = s1.peek();
//                 temp2  = s2.peek();
//                 s1.pop();
//                 s2.pop();
                
//                 if(temp1.data < temp2.data)
//                 {
//                     ans.add(temp1.data);
//                     temp1 = temp1.right;
//                     s2.push(temp2);
//                     temp2 = null;
//                 }
//                 else
//                 {
//                     ans.add(temp2.data);
//                     temp2 = temp2.right;
//                     s1.push(temp1);
//                     temp1 = null;
//                 }
//             }
//         }
//         return ans;
//     }

      

// }
