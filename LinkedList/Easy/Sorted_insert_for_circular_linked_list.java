
/*
 * Given a sorted circular linked list, the task is to insert a new node in this
 * circular list so that it remains a sorted circular linked list.
 * 
 * Input: First line of input contains number of testcases T. For each testcase
 * first line of input contains length of the linked list, next line contains
 * the linked list elements and the last line contains the element to be
 * inserted into the linked list.
 * 
 * Output: For each testcase, print the new linked list.
 * 
 * User Task: The task is to complete the function sortedInsert() which should
 * insert the new node into the given circular linked list.
 * 
 * Expected Time Complexity: O(N) Expected Auxiliary Space: O(1)
 * 
 * Constraints: 1 <= T <= 100 0 <= N <= 200 Example: Input: 2 3 1 2 4 2 4 1 4 7
 * 9 5
 * 
 * Output: 1 2 2 4 1 4 5 7 9
 */
// { Driver Code Starts
// Code by:Saksham Raj Seth
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Sorted_insert_for_circular_linked_list {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Sorted_insert_for_circular_linked_list llist = new Sorted_insert_for_circular_linked_list();
            llist.head = null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            int value = sc.nextInt();
            Node phead = head;
            while (phead.next != null) {
                phead = phead.next;
            }
            phead.next = head;
            GfG9 g = new GfG9();
            g.insert(head, value, n);
            System.out.println();
        }
    }
}// } Driver Code Ends

/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * next; Node(int d){ data=d; next=null; } }
 */
class GfG9 {
    public static void insert(Node zhead, int value, int n) {
        Node t = zhead;
        if (zhead.data > value) {
            Node temp = new Node(value);
            temp.next = zhead;
            zhead = temp;
        } else {
            while (n-- > 0) {
                if (t.next.data >= value) {
                    Node temp = new Node(value);
                    temp.next = t.next;
                    t.next = temp;
                    break;
                } else {
                    t = t.next;
                }
            }

        }
        t = zhead;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }

    }
}