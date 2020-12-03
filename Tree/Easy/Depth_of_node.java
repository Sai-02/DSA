
/*
Given a binary tree, 
find the depth of the deepest odd level leaf node in a binary tree.
 If there is no leaf at odd level then return 0.
Consider that level starts with 1.
 Depth of a leaf node is number of nodes on the path from root to leaf 
 (including both leaf and root).

Input Format:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case contains an integer n 
 denoting the number of edges. The next line contains the edges of the binary tree.

Output Format:
Print the depth of the deepest odd level leaf node in the binary tree.

Your task:
You don't need to read input/output. Complete the function depthOfOddLeafUtil

Constraints:
1<=T<=1000
1<=n<=1000
1<=data of node<=1000

Example:
Input:
2
10
1 2 L 2 4 L 1 3 R 3 5 L 3 6 R 5 7 R 7 9 L 6 8 R 8 10 R 10 11 L
4
1 2 L 2 4 L 1 3 R 3 5 L

Output:
5
3
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class Depth_of_node {
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

            // GfG g=new GfG();
            System.out.println(depthOfOddLeaf(root));

        }
    }

    public static int depthOfOddLeaf(Node root) {
        int level = 1;
        int depth = 0;
        GfG16 gfg = new GfG16();
        return gfg.depthOfOddLeafUtil(root, level);
    }
}
// } Driver Code Ends

class GfG16 {
    static int level = 0;

    public static int depthOfOddLeafUtil(Node root, int currentlevel) {
        depth(root, currentlevel);
        currentlevel = level;
        level = 0;
        return currentlevel;

    }

    public static void depth(Node root, int currentLevel) {
        if (root == null) {
            return;
        }
        if (checkLeaf(root) && ((currentLevel & 1) == 1)) {

            level = Math.max(currentLevel, level);
        }
        depth(root.left, currentLevel + 1);
        depth(root.right, currentLevel + 1);
    }

    public static boolean checkLeaf(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}
