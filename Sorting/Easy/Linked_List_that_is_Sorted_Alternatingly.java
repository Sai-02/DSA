/*
Given a Linked list of size N, 
the list is in alternating ascending and descending orders. 
Sort the given linked list in non-decreasing order.

 

Example 1:

Input:
LinkedList: 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: After sorting the given
list will be 1-> 2-> 3-> 7-> 8-> 9.
 

Example 2:

Input:
LinkedList: 13->99->21->80->50
Output: 13 21 50 80 99
Explanation: After sorting the given list 
will be 12-> 21-> 50-> 80-> 99.
 

Your Task:
You do not need to read input or print anything.
 The task is to complete the function sort() which should sort the linked list
  in non-decreasing order. 

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the linked list <= 103

Company Tags
Topic Tags
Related Courses
*/

// /{Driver Code Starts
/*package whatever //do not write package name here */
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Linked_List_that_is_Sorted_Alternatingly {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.sort(head);
            printList(head);
        }
    }
}
// } Driver Code Ends

/*
 * Structure of node class is:
 * 
 * class Node { int data; Node next;
 * 
 * public Node (int data){ this.data = data; this.next = null; } }
 */
class Solution {

    public Node sort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp1 = head;
        Node head2 = head.next;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.next != null) {

                temp1.next = temp1.next.next;
                temp1 = temp1.next;
            }
            if (temp2.next != null) {

                temp2.next = temp2.next.next;
                temp2 = temp2.next;
            }
        }
        head2 = reverse(head2);
        return merge(head, head2);

    }

    // ========================================
    //
    // Merge method taking O(n) extra space
    //
    // ========================================

    // public Node merge(Node head1, Node head2) {
    //     Node head = null;
    //     Node temp = null;
    //     Node temp1 = head1, temp2 = head2;
    //     while (temp1 != null && temp2 != null) {
    //         if (temp1.data < temp2.data) {
    //             if (head == null) {
    //                 head = new Node(temp1.data);
    //                 temp = head;
    //             } else {
    //                 Node newNode = new Node(temp1.data);
    //                 temp.next = newNode;
    //                 temp = temp.next;

    //             }
    //             temp1 = temp1.next;

    //         } else {
    //             if (head == null) {
    //                 head = new Node(temp2.data);
    //                 temp = head;
    //             } else {
    //                 Node newNode = new Node(temp2.data);
    //                 temp.next = newNode;
    //                 temp = temp.next;

    //             }
    //             temp2 = temp2.next;

    //         }
    //     }
    //     while (temp1 != null) {
    //         if (head == null) {
    //             head = new Node(temp1.data);
    //             temp = head;
    //         } else {
    //             Node newNode = new Node(temp1.data);
    //             temp.next = newNode;
    //             temp = temp.next;

    //         }
    //         temp1 = temp1.next;

    //     }
    //     while (temp2 != null) {
    //         if (head == null) {
    //             head = new Node(temp2.data);
    //             temp = head;
    //         } else {
    //             Node newNode = new Node(temp2.data);
    //             temp.next = newNode;
    //             temp = temp.next;

    //         }
    //         temp2 = temp2.next;
    //     }
    //     return head;
    // }


    // ======================================
    // 
    // Merge method taking O(1) extra space
    // 
    // ====================================
    public Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head2;
        Node head = null, temp = null;
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                if (head == null) {
                    head = temp1;
                    temp1 = temp1.next;
                    temp = head;
                    temp.next = null;

                } else {
                    temp.next = temp1;
                    temp1 = temp1.next;
                    temp = temp.next;
                    temp.next = null;
                }

            } else {
                if (head == null) {
                    head = temp2;
                    temp2 = temp2.next;
                    temp = head;
                    temp.next = null;

                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                    temp = temp.next;
                    temp.next = null;
                }

            }
        }
        while (temp1 != null) {
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
            temp.next = null;

        }
        while (temp2 != null) {
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
            temp.next = null;

        }
        return head;
    }

    public Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

}