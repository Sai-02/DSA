
/*

Given a binary tree of size N+1, 
your task is to complete the function tiltTree(),
 that return the tilt of the whole tree. 
 The tilt of a tree node is defined as the absolute difference between
  the sum of all left subtree node values and the sum of all right subtree node values.
   Null nodes are assigned tilt to be zero. 
   Therefore, tilt of the whole tree is defined as the sum of all nodes’ tilt.

Examples:

Input :
    1
   / \
  2   3
Output : 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

Input :
    4
   / \
  2   9
 / \   \
3   5   7
Output : 15
Explanation: 
Tilt of node 3 : 0
Tilt of node 5 : 0
Tilt of node 7 : 0
Tilt of node 2 : |3-5| = 2
Tilt of node 9 : |0-7| = 7
Tilt of node 4 : |(3+5+2)-(9+7)| = 6
Tilt of binary tree : 0 + 0 + 0 + 2 + 7 + 6 = 15
Input:
The function takes a single argument as input, 
the reference pointer to the root of the binary tree.
There will be T test cases, and for each test case
 the function will be called separately.

Output:
For each test case output the tilt of the binary tree on a new line.

Constraints:
1<=T<=100
0<=N<=500

Example:
Input:
2
2
1 2 L 1 3 R
5
10 20 L 10 30 R 20 40 L 20 60 R 30 90 L
Output:
1
110
 */

// { Driver Code Starts
//Initial Template for Java
import java.util.Scanner;

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

public class Tilt_of_Binary_Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            Node root = null;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int a1 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (i == 0) {
                    root = new Node(a);
                    switch (lr) {
                        case 'L':
                            root.left = new Node(a1);
                            break;
                        case 'R':
                            root.right = new Node(a1);
                            break;
                    }
                } else {
                    insert(root, a, a1, lr);
                }
            }
            // inorder(root);
            GfG10 g = new GfG10();
            System.out.println(g.tilt(root));
        }
    }

    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}// } Driver Code Ends

// User function Template for Java
/*
 * Node defined as class Node{ int data; Node left,right; Node(int d){ data=d;
 * left=right=null; } }
 */
class GfG10 {
    public int tilt(Node root) {
        if (root == null) {
            return 0;
        }

        int absDiff = Math.abs(getSum(root.right) - getSum(root.left));
        return absDiff + tilt(root.right) + tilt(root.left);

    }

    public int getSum(Node root) {
        if (root == null) {
            return 0;
        }

        return root.data + getSum(root.left) + getSum(root.right);
    }
}