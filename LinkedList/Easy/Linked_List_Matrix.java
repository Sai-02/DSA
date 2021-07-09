/*

Given a Matrix mat of N*N size, the task is to complete the function 
constructLinkedMatrix(), that constructs a 2D linked list representation
 of the given matrix.

Input : 2D matrix 
1 2 3
4 5 6
7 8 9

Output :
1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL
Input:
The fuction takes 2 argument as input, first the 2D matrix mat[][] and 
second an integer variable N, denoting the size of the matrix.
There will be T test cases and for each test case the function will be called separately.

Output:
The function must return the reference pointer to the head of the linked list.

Constraints:
1<=T<=100
1<=N<=150

Example:
Input:
2
3
1 2 3 4 5 6 7 8 9
2
1 2 3 4
Output:
1 2 3 4 5 6 7 8 9
1 2 3 4

Note:The Input/Ouput format and Example given are used for system's internal purpose,
 and should be used by a user for Expected Output only.
  As it is a function problem, hence a user should not read any input from stdin/console.
   The task is to complete the function specified, and not to write the full code.
*/

// { Driver Code Starts
import java.io.*;
import java.util.Scanner;

public class Linked_List_Matrix {
    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    // node of linked list

    static void display(Node head) {

        Node Rp;
        Node Dp = head;
        while (Dp != null) {
            Rp = Dp;
            while (Rp != null) {
                System.out.print(Rp.data + " ");
                Rp = Rp.right;
            }
            Dp = Dp.down;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int p = sc.nextInt();
                    arr[i][j] = p;
                }
            }
            GFG obj = new GFG();
            Node head = obj.construct(arr, n);
            display(head);
        }
    }

}// } Driver Code Ends

/*
 * class Node
 * 
 * class Node { int data; Node right,down;
 * 
 * Node(int data){ this.data = data; right = null; down = null; } }
 */
/* Function should return the head of the 2D LL. */
class GFG {
    static Node construct(int arr[][], int n) {
        return solver(arr, n, 0, 0);
    }

    static Node solver(int arr[][], int n, int i, int j) {
        if (i >= n || j >= n) {
            return null;
        }
        Node newNode = new Node(arr[i][j]);
        newNode.right = solver(arr, n, i, j + 1);
        newNode.down = solver(arr, n, i + 1, j);
        return newNode;
    }
}