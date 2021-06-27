/*
Given Pointer/Reference to the head of the linked list, 
the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should
 go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort()
 which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort()
 and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
1 <= N <= 105

 

Company Tags
*/
//{
// Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Merge_Sort_for_Linked_List {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while (n-- > 1) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = new Solution2().mergeSort(head);
            printList(head);
            System.out.println();
        }
    }

    public static void printList(Node head) {
        if (head == null)
            return;

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

// } Driver Code Ends

// User function Template for Java
/*
 * class Node { int data; Node next; Node(int key) { this.data = key; next =
 * null; } }
 */

class Solution2 {
    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        head = mergeSort(head);
        slow = mergeSort(slow);
        Node ans = merge(head, slow);
        return ans;

    }

    static Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node head = null, temp = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (head == null) {
                    head = head1;
                    head1 = head1.next;
                    temp = head;
                    temp.next = null;
                } else {
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next;
                    temp.next = null;
                }
            } else {
                if (head == null) {
                    head = head2;
                    head2 = head2.next;
                    temp = head;
                    temp.next = null;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                    temp = temp.next;
                    temp.next = null;
                }
            }

        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return head;
    }
}
