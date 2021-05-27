/*
Given a singly linked list of size N.
 The task is to rotate the linked list counter-clockwise by k nodes,
  where k is a given positive integer smaller than or equal to length of the linked list.

Example 1:

Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output: 8 9 2 4 7
Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
Example 2:

Input:
N = 8
value[] = {1, 2, 3, 4, 5, 6, 7, 8}
k = 4
Output: 5 6 7 8 1 2 3 4
 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function rotate() 
 which takes a head reference as the first argument
  and k as the second argument, and returns the head 
  of the rotated linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
1 <= k <= N

Company Tags
 */

// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Rotate_a_Linked_List {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();

            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends

/*
 * node of linked list:
 * 
 * class Node{ int data; Node next; Node(int d){ data=d; next=null; } }
 * 
 */

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        Node temp = head, prev = null;
        int count = 0;
        while (temp != null && count < k) {
            count++;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = reverse(head);
        temp = reverse(temp);
        prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = temp;
        head = reverse(head);
        return head;

    }

    public Node reverse(Node head) {
        Node curr = head, prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
