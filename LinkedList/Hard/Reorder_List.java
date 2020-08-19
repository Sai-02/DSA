
/*
Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the nodes' values.

Input:
First line of input contains number of testcases T. For each testcase,
 there will be two lines of input,
  first of which contains length of linked list and next line contains elements of the nodes of linked list.

Output:
Reorder it as explained above.

User Task:
The task is to complete the function reorderList() which should reorder the list as required.

Note: Try to solve without using any auxilliary space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 200
1 <= N <= 104

Example:
Input:

2
3
1 2 3
4
1 7 3 4

Output:
1 3 2
1 4 7 3

Explanation:
Testcase 2: After rearranging the given list as required, we have list as 1 -> 4 -> 7 -> 3.
 
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

public class Reorder_List {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node */

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /*
         * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
         */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Reorder_List llist = new Reorder_List();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new gfg().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}// } Driver Code Ends

/* Following is the Linked list node structure */

/*
 * class Node { int data; Node next; Node(int d) { data = d; next = null; } }
 */

class gfg {
    Node reorderlist(Node head) {
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null) {

            return head;
        }

        Node t = head;
        int n = 0;
        while (t != null) {
            t = t.next;
            n++;
        }
        if (n % 2 == 0) {
            n = n / 2;
            n++;
        } else {
            n = n / 2;
            n++;
        }
        t = head;
        for (int i = 0; i < n - 1; i++) {
            t = t.next;
        }
        Node temp = new Node(t.next.data);
        temp.next = t.next.next;
        t.next = null;

        Node k = temp;
        // er
        while (k.next != null) {
            Node x = new Node((k.next).data);
            x.next = temp;
            temp = x;
            k.next = (k.next).next;
        }
        // tg
        k = temp;
        t = head;
        while (k != null) {
            Node y = new Node(k.data);
            y.next = t.next;
            t.next = y;
            k = k.next;
            t = t.next.next;
        }
        return head;

    }
}
//===============================================================
//
// Approach
//
//================================================================


// 1. Split the list into 2 halves.
//   Next reverse the second half.
// 2. Now, merge the 2 halves while picking elements alternatively from each half.    


//========================================
//
//    GfG Editorial
//
//========================================


// class gfg {
//     Node reorderlist(Node head) {
//         int n = 0;
//         Node cur = head;
//         while (cur != null) {
//             n++;
//             cur = cur.next;
//         }

//         Node head1 = head;
//         Node head2 = head;
//         Node prev = null;
//         int w = n / 2;
//         if (n % 2 == 1) {
//             w++;
//         }
//         for (int i = 0; i < w; i++) {
//             prev = head2;
//             head2 = head2.next;
//         }
//         if (prev != null) {
//             prev.next = null;
//         }
//         head2 = reverse(head2);
//         cur = head1;
//         for (int i = 0; i < n / 2; i++) {
//             Node temp = cur.next;
//             cur.next = head2;
//             Node temp2 = head2.next;
//             head2.next = temp;
//             cur = temp;
//             head2 = temp2;
//         }
//         return head1;
//     }
//     Node reverse(Node head) {
//         Node cur = head;
//         Node prev = null;
//         while (cur != null) {
//             Node temp = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = temp;
//         }
//         return prev;
//     }
// }
