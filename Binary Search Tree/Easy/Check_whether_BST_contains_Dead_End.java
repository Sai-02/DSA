
/*

 Given a Binary search Tree that contains positive integer
  values greater then 0. The task is to complete the function
   isDeadEnd which returns true if the BST contains a dead end else returns false
   . Here Dead End means, we are not able to insert any element after that node.

Examples:

Input :   
               8
             /   \ 
           5      9
         /  \     
        2    7 
       /
      1     
          
Output : Yes
Explanation : Node "1" is the dead End because after that 
              we cant insert any element.       

Input :     
              8
            /   \ 
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at 
              node 9.  

Input:
The first line of the input contains an integer 'T' 
denoting the number of test cases. Then 'T' test cases follow.
 Each test case consists of three lines. F
 irst line of each test case contains an integer 
 N denoting the no of nodes of the BST . 
 Second line of each test case consists of 'N' 
 space separated integers denoting the elements of the BST.
  These elements are inserted into BST in the given order.

Output:
The output for each test case will be 1 if the BST contains a dead end else 0.
 

Constraints:
1<=T<=100
1<=N<=200
 

Example(To be used only for expected output):
Input:
2
6
8 5 9 7 2 1
6
8 7 10 9 13 2
Output:
1
1
 */

// { Driver Code Starts
import java.util.Scanner;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Check_whether_BST_contains_Dead_End {
    public static Node root;

    Check_whether_BST_contains_Dead_End() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }

    public static void inorder() {
        inorderRec(root);
    }

    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data);
            inorderRec(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Check_whether_BST_contains_Dead_End obj1 = new Check_whether_BST_contains_Dead_End();
            for (int i = 0; i < n; i++) {
                int b = sc.nextInt();
                obj1.insert(b);
            }
            // inorder();
            GFG obj = new GFG();
            boolean k = obj.isDeadEnd(root);
            if (k == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}

// } Driver Code Ends

/*
 * class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */

// Function should return true if a deadEnd is found in the bst otherwise return
// false.
class GFG {
    public static boolean isDeadEnd(Node root) {
        return solver(root, 1, Integer.MAX_VALUE);

    }

    public static boolean solver(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return solver(root.left, min, root.data - 1) || solver(root.right, root.data + 1, max);
    }
}