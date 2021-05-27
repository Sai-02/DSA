
/*
Given a linked list, write a function to reverse every alternate k nodes
 (where k is an input to the function) in an efficient way.
 Give the complexity of your algorithm.
 */
import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

}

public class Reverse_alternate_K_nodes_in_a_Singly_Linked_List {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ListNode temp = null, head = null;
        for (int i = 0; i < n; i++) {
            int data = scan.nextInt();
            if (i == 0) {
                head = new ListNode(data);
                temp = head;
            } else {
                ListNode newNode = new ListNode(data);
                temp.next = newNode;
                temp = newNode;
            }
        }
        int k = scan.nextInt();
        printList(head);
        head = reverseAlternateNodes(head, k);
        printList(head);

    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ===================================================
    //
    // Stack based Solution: Extra space O(k)
    //
    // ===================================================

    public static ListNode reverseAlternateNodesStack(ListNode head, int k) {
        boolean check = true;
        int count = 0;
        ListNode temp = head;
        ListNode t = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null && t != null) {
            count++;
            if (check) {
                st.add(temp.data);

            }
            if (count == k) {
                count = 0;
                if (check) {
                    while (!st.empty()) {
                        t.data = st.pop();
                        t = t.next;
                    }

                }
                check = !check;
                temp = temp.next;
                if (check) {
                    t = t.next;
                }

                continue;
            }
            temp = temp.next;

            if (!check) {
                t = t.next;
            }
        }
        if (count == k) {
            count = 0;
            if (check) {
                while (!st.empty()) {
                    t.data = st.pop();
                    t = t.next;
                }

            }
            check = !check;
        }

        return head;
    }

    // ============================================================
    //
    // Iterative solution : Space complexity O(1)
    //
    // ==============================================================
    public static ListNode reverseAlternateNodes(ListNode head, int k) {
        int count = 0;
        boolean check = true;
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        head = newNode;
        ListNode curr = head.next, temp = head;
        while (curr != null && temp.next != null) {
            count++;

            if (count == k) {
                count = 0;
                check = !check;

                if (!check) {
                    ListNode next = curr.next;
                    curr.next = null;
                    temp.next = reverse(temp.next);
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = next;
                    curr = next;

                }

            }
            curr = curr.next;
            if (!check) {
                temp = temp.next;
            }

        }

        return head.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}