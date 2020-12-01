/*

Given a Binary Tree of size N, your task is to complete the function rightLeafSum(),
 that should return the sum of all the leaf nodes that are right child of their parent
  of the given binary tree.
Example:

Input : 
         1
        /  \
       2    3
     /  \     \
    4    5     8 
     \        /  \
      2       6   7
Output :
sum = 2 + 5 + 7 = 14
Input:
The function takes a single arguments as input, the reference pointer to the root of 
the binary tree.
There are T test cases and for each test case the function will be called separately.

Output:
The function should return the sum of all the right leaf nodes of the binary tree.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
2
1 2 L 1 3 R
5
10 20 L 10 30 R 20 40 L 20 60 R 30 90 L
Output:
3
60

Explanation:
Test Case 1:
Tree formed is as follows:
      1
    /    \
  2      3

Here, there are 2 leaf nodes (2 and 3).
 Out of these, only 3 is a right child of its parent. Hence, the answer is 3.

Test Case 2:
The tree formed is as follows:
           10
         /       \
      20        30
    /     \      /
  40   60  90

Here, there are 3 leaf nodes (40, 60 and 90). Out of these,
 only 60 is a right child of its parent. Hence, the answer is 60.
 */

// { Driver Code Starts
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Sum_of_Right_Leaf_Nodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;
            while (n-- > 0) {
                int a = sc.nextInt();
                int a1 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (root == null) {
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
            GfG20 g = new GfG20();
            int ans = g.rightLeafSum(root);
            System.out.println(ans);
        }
    }

    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null)
            return;
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
        } else {
            insert(root.left, a, a1, lr);
            insert(root.right, a, a1, lr);
        }
    }
}
// } Driver Code Ends

/*
 * Complete the function below Node is as follows class Node{ int data; Node
 * left,right; Node(int d){ data=d; left=right=null; } }
 */
class GfG20 {
    public int rightLeafSum(Node root) {
        if (root == null) {
            return 0;
        }
        if (checkLeafNode(root.right)) {
            return root.right.data + rightLeafSum(root.left);
        }
        return rightLeafSum(root.left) + rightLeafSum(root.right);

    }

    public boolean checkLeafNode(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}