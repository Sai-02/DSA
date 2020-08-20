
/*
Given a linked list of size N. 
The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5
Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4
Your Task:
The task is to complete the function reverse() 
which should reverse the linked list in group of size k and return the head of the modified linked list.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)
 */
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Reverse_a_Linked_List_in_groups_of_given_size {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            GfG14 gfg = new GfG14();
            Node res = gfg.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}

// } Driver Code Ends

/*
 * node class of the linked list
 * 
 * class Node { int data; Node next; Node(int key) { data = key; next = null; }
 * }
 * 
 */

class GfG14 {
    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /*
         * next is now a pointer to (k+1)th node Recursively call for the list starting
         * from current. And make rest of the list as next of first node
         */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }
}
// =======================================================
//
// Approach
//
// =======================================================

// Reverse the first sub-list of size k. While reversing keep track of the next
// node and previous node.
// Keep two pointers, pointer to the next node be next and pointer to the
// previous node be prev.
// Recursively call for rest of the list and link the two sub-lists. /*
// (head->next=reverse(next, k)) */
// prev becomes the new head of the list.

// =========================================================
//
// GFG Solution
//
// ==========================================================

// class GfG {
//     public static Node reverse(Node node, int k) {
//         Node curr = node, prev = null, next = null;
//         int count = 0;

//         while (curr != null && count < k)
//         // reversing k elements :
//         {
//             next = curr.next; // marking next node
//             curr.next = prev; // reversing link
//             prev = curr; // updating prev
//             curr = next; // updating current
//             count++;
//         }

//         if (next != null) // checking if there are nodes ahead
//             node.next = reverse(next, k); // reversing those recursively

//         return prev;
//     }
// }
