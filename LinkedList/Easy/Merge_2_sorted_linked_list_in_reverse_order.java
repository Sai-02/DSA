/*
Given two linked lists of size N and M, which are sorted in non-decreasing order.
 The task is to merge them in such a way that the resulting list is in decreasing order.

Input:
First line of input contains number of testcases T. For each testcase, first line 
of input conatains length of both linked lists N and M respectively. Next two lines
 contains N and M elements of two linked lists.

Output:
For each testcase, print the merged linked list which is in non-increasing order.

User Task:
The task is to complete the function mergeResult()
 which takes reference to the heads of both linked list and 
 returns the pointer to the merged linked list.

Constraints:
1 <=T<= 50
1 <= N, M <= 1000

Example:
Input:
2
4 3
5 10 15 40 
2 3 20
2 2
1 1
2 4

Output:
40 20 15 10 5 3 2
4 2 1 1 

Explanation:
Testcase 1: After merging the two lists in decreasing order,
 we have new lists as 40->20->15->10->5->3->2.
*/
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Merge_2_sorted_linked_list_in_reverse_order {
    Node head;

    void addToTheLast(Node node) {
        if (head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String nums[] = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            Merge_2_sorted_linked_list_in_reverse_order list = new Merge_2_sorted_linked_list_in_reverse_order();
            nums = br.readLine().split(" ");
            int a1 = Integer.parseInt(nums[0]);
            Node head = new Node(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n1; i++) {
                int a = Integer.parseInt(nums[i]);
                list.addToTheLast(new Node(a));
            }
            // list.printList(list.head);

            Merge_2_sorted_linked_list_in_reverse_order list2 = new Merge_2_sorted_linked_list_in_reverse_order();
            nums = br.readLine().split(" ");
            int b1 = Integer.parseInt(nums[0]);
            Node head1 = new Node(b1);
            list2.addToTheLast(new Node(b1));
            for (int j = 1; j < n2; j++) {
                int b = Integer.parseInt(nums[j]);
                list2.addToTheLast(new Node(b));
            }
            // list.printList(list2.head);

            GfG g = new GfG();
            Node result = g.mergeResult(list.head, list2.head);
            list.printList(result);
            t--;
        }
    }
}// } Driver Code Ends

/* Structure of the node */
/*
 * class Node { int data; Node next;
 * 
 * Node(int d) { data = d; next = null; } }
 */

class GfG {
    Node mergeResult(Node node1, Node node2) {
        return reverse(merge(node1, node2));

    }

    Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node head = null, temp = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (head == null) {
                    head = head1;
                    temp = head;
                    head1 = head1.next;
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
                    temp = head;
                    head2 = head2.next;
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

    Node reverse(Node head) {
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
