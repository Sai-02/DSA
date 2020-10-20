
/*
 * Given a Binary Tree of size N, your task is to complete the function sumBt(),
 * that should return the sum of all the nodes of the given binary tree.
 * 
 * Input:
 * 
 * First line of input contains the number of test cases T. For each test case,
 * there will be two lines:
 * 
 * First line of each test case will be an integer N denoting the number of
 * parent child relationships.
 * 
 * Second line of each test case will print the level order traversal of the
 * tree in the form of N space separated triplets. The description of triplets
 * is as follows:
 * 
 * Each triplet will contain three space-separated elements of the form (int,
 * int char).
 * 
 * The first integer element will be the value of parent.
 * 
 * The second integer will be the value of corresponding left or right child. In
 * case the child is null, this value will be -1.
 * 
 * The third element of triplet which is a character can take any of the three
 * values ‘L’, ‘R’ or ‘N’. L denotes that the children is a left child, R
 * denotes that the children is a Right Child and N denotes that the child is
 * NULL.
 * 
 * 
 * Please note that the relationships are printed only for internal nodes and
 * not for leaf nodes.
 * 
 * Output: The function should return the sum of all the nodes of the binary
 * tree.
 * 
 * User Task: As it is a functional problem. So, you don't need to worry about
 * the input you just have to complete the function sumBT() that takes a node as
 * a parameter and returns the sum of all the nodes.
 * 
 * Constraints: 1<=T<=100 1<=N<=100
 * 
 * Example: Input: 2 2 1 2 L 1 -1 N 6 1 2 L 1 3 R 2 -1 N 2 -1 N 3 3 L 3 -1 N
 * Output: 3 9
 * 
 */
// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }

}

public class Sum_of_Binary_Tree {

    public static void main(String[] args) throws IOException {
        // Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            Queue<Node> q = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");

            Node root = null;
            int j = 0;
            while (n > 0) {
                int a1 = Integer.parseInt(input[j]);
                int a2 = Integer.parseInt(input[j + 1]);
                char lr = input[j + 2].charAt(0);
                j += 3;

                if (root == null) {
                    root = new Node(a1);
                    q.add(root);
                }

                Node pick = q.peek();

                q.remove();

                if (lr == 'L') {
                    pick.left = new Node(a2);
                    q.add(pick.left);
                }
                a1 = Integer.parseInt(input[j]);
                a2 = Integer.parseInt(input[j + 1]);
                lr = input[j + 2].charAt(0);
                j += 3;

                if (lr == 'R') {
                    pick.right = new Node(a2);
                    q.add(pick.right);
                }

                n -= 2;
            }
            System.out.println(BinaryTree.sumBT(root));
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

class BinaryTree {
    static int sumBT(Node head) {
        if (head == null) {
            return 0;
        }
        return head.data + sumBT(head.left) + sumBT(head.right);
    }
}
