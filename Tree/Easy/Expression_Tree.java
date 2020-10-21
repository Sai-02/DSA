
/*

Given a full binary expression tree consisting of basic binary operators (+ , – ,*, /)
 and some integers, Your task is to evaluate the expression tree.

Example 1:

Input: 
              +
           /     \
          *       -
        /  \    /   \
       5    4  100  20 

Output: 100

Explanation:
((5 * 4) + (100 - 20)) = 100

Example 2:

Input:
            -
          /   \
         4     7

Output: -3

Explanation:
4 - 7 = -3

Your Task:  
You dont need to read input or print anything.
 Complete the function evalTree() which takes root node as input
  parameter and returns an integer denoting
   the result obtained by simplifying the expression tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)

 */
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    String data;
    Node left, right;

    Node(String d) {
        data = d;
        left = null;
        right = null;
    }
}

public class Expression_Tree {
    static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++)
                s[i] = sc.next();
            GfG1 g = new GfG1();

            root = null;
            makeTree(s, n);
            System.out.println(g.evalTree(root));
        }
    }

    public static boolean isExpression(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }

    public static void makeTree(String[] s, int n) {
        int p = 0;
        root = new Node(s[p++]);
        Queue<Node> qq = new LinkedList<Node>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node f = qq.poll();
            Node l = null, r = null;
            if (isExpression(f.data)) {
                l = new Node(s[p++]);
                r = new Node(s[p++]);
                f.left = l;
                f.right = r;
                qq.add(l);
                qq.add(r);
            }
        }
    }
}
// } Driver Code Ends

/*
 * A Tree node is defined as class Node { String data; Node left,right;
 * 
 * Node(String data) { this.data = data; this.left = null; this.right = null; }
 * 
 * }
 */

class GfG1 {
    public int evalTree(Node root) {

        if (root.data.equals("+")) {
            return evalTree(root.left) + evalTree(root.right);
        } else if (root.data.equals("-")) {
            return evalTree(root.left) - evalTree(root.right);
        } else if (root.data.equals("*")) {
            return evalTree(root.left) * evalTree(root.right);
        } else if (root.data.equals("/")) {
            return evalTree(root.left) / evalTree(root.right);
        }
        return Integer.parseInt(root.data);
    }
}