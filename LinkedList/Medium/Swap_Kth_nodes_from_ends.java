/*
Given a singly linked list of size N, and an integer K.
 You need to swap the Kth node from beginning and Kth node from the end in the linked list.
Note: You need to swap the nodes through the links and not changing the content of the nodes.

Example 1:

Input:
N = 4,  K = 1
value[] = {1,2,3,4}
Output: 1
Explanation: Here K = 1, hence after
swapping the 1st node from the beginning
and end thenew list will be 4 2 3 1.
Example 2:

Input:
N = 5,  K = 3
value[] = {1,2,3,4,5}
Output: 1
Explanation: Here k = 3, hence after
swapping the 3rd node from the beginning
and end the new list will be 1 2 3 4 5.
Your Task: 
The task is to complete the function swapkthnode(),
 which has arguments head, num(no of nodes), and K,
  and it should return a new head.
   The validation is done internally by the driver code to ensure that the swapping is done by changing
    references/pointers only.  A correct code would always cause output as 1.

Expected Time Complexity: O(n)
Expected Auxillary space Complexity: O(1)

Constraints:
1 <= N <= 103
1 <= K <= 103 
*/
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Swap_Kth_nodes_from_ends {
    static Node head;
    static Node lastNode;

    public static void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();

            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }

            Node before[] = new Node[n];
            addressstore(before, head);
            GFG13 obj = new GFG13();

            head = obj.swapkthnode(head, n, K);

            Node after[] = new Node[n];
            addressstore(after, head);

            if (check(before, after, n, K) == true)
                System.out.println("1");
            else
                System.out.println("0");

        }
    }

    static boolean check(Node before[], Node after[], int num, int K) {
        if (K > num)
            return true;

        return (before[K - 1] == after[num - K]) && (before[num - K] == after[K - 1]);

    }

    static void addressstore(Node arr[], Node head) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp;
            i++;
            temp = temp.next;
        }
    }

}// } Driver Code Ends

// User function Template for Java

/*
 * Linked List Node class class Node { int data; Node next; Node(int data) {
 * this.data = data; next = null; } }
 */
class GFG13 {
    // Should swap Kth node from beginning and
    // Kth node from end in list and return new head.
    Node swapkthnode(Node head, int num, int K) {
        if (num < K || 2 * K - 1 == num)
            return head;
        Node x = head;
        Node x_prev = null;
        for (int i = 1; i < K; i++) {
            x_prev = x;
            x = x.next;
        }
        Node y = head;
        Node y_prev = null;
        for (int i = 1; i < num - K + 1; i++) {
            y_prev = y;
            y = y.next;
        }
        if (x_prev != null)
            x_prev.next = y;

        if (y_prev != null)
            y_prev.next = x;

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        if (K == 1)
            head = y;

        if (K == num)
            head = x;

        return head;

    }
}
// ==========================
// ==========================
//
// Approach
//
// ==========================
// ==========================
// if(n<k)return;

// // If x (kth node from start) and
// // y(kth node from end) are same
// if(2*k-1==n)return;

// // Find the kth node from beginning of linked list.
// // We also find previous of kth node because we need
// // to update next pointer of the previous.
// Node x = head;
// Node x_prev = null;for(
// int i = 1;i<k;i++)
// {
// x_prev = x;
// x = x.next;
// }

// // Similarly, find the kth node from end and its
// // previous. kth node from end is (n-k+1)th node
// // from beginning
// Node y = head;
// Node y_prev = null;for(
// int i = 1;i<n-k+1;i++)
// {
// y_prev = y;
// y = y.next;
// }

// // If x_prev exists, then new next of it will be y.
// // Consider the case when y->next is x, in this case,
// // x_prev and y are same. So the statement
// // "x_prev->next = y" creates a self loop. This self
// // loop will be broken when we change y->next.
// if(x_prev!=null)x_prev.next=y;

// // Same thing applies to y_prev
// if(y_prev!=null)y_prev.next=x;

// // Swap next pointers of x and y. These statements
// // also break self loop if x->next is y or y->next
// // is x
// Node temp = x.next;x.next=y.next;y.next=temp;

// // Change head pointers when k is 1 or n
// if(k==1)head=y;

// if(k==n)head=x;
// }