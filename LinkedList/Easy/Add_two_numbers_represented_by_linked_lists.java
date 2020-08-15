
/*
 * Given two numbers represented by two linked lists of size N and M. The task
 * is to return a sum list. The sum list is a linked list representation of the
 * addition of two input numbers.
 * 
 * Example 1:
 * 
 * Input: N = 2 valueN[] = {4,5} M = 3 valueM[] = {3,4,5} Output: 3 9 0
 * Explanation: For the given two linked list (4 5) and (3 4 5), after adding
 * the two linked list resultant linked list will be (3 9 0). Example 2:
 * 
 * Input: N = 2 valueN[] = {6,3} M = 1 valueM[] = {7} Output: 7 0 Explanation:
 * For the given two linked list (6 3) and (7), after adding the two linked list
 * resultant linked list will be (7 0). Your Task: The task is to complete the
 * function addTwoLists() which has node reference of both the linked lists and
 * returns the head of the new list.
 * 
 * Expected Time Complexity: O(N) + O(M) Expected Auxiliary Space: O(N) + O(M)
 * 
 * Constraints: 1 <= N, M <= 5000
 */
// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Add_two_numbers_represented_by_linked_lists {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution5 g = new Solution5();
            Node res = g.addLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends

/*
 * node for linked list
 * 
 * class Node { int data; Node next;
 * 
 * Node(int d) { data = d; next = null; } }
 * 
 */

class Solution5 {
    static Node reverse(Node first) {

        Node t1 = first;
        while (t1.next != null) {
            Node temp = new Node(t1.next.data);
            temp.next = first;
            first = temp;
            t1.next = t1.next.next;

        }
        return first;
    }

    static int length(Node k) {
        int n = 0;
        Node t = k;
        while (t != null) {
            n++;
            t = t.next;
        }
        return n;
    }

    static Node addLists(Node first, Node second) {

        int n1 = length(first);
        int n2 = length(second);
        if (n2 > n1) {
            Node temp = new Node(first.data);
            temp.next = first.next;
            first = second;
            second = temp;
        }
        first = reverse(first);
        second = reverse(second);
        Node head = new Node((first.data + second.data) % 10);
        int carry = (first.data + second.data) / 10;

        Node t = head;
        if (carry > 0) {

            try {

                first.next.data = first.next.data + carry;

            } catch (NullPointerException e) {
                Node g = new Node(carry);
                t.next = g;
                return reverse(head);

            }
        }
        first = first.next;
        second = second.next;
        while (first != null) {
            int start = 0;
            if (second != null) {
                start = second.data;

            }
            int k = (first.data + start) % 10;
            carry = (first.data + start) / 10;

            Node temp = new Node(k);
            t.next = temp;
            t = t.next;
            if (carry > 0) {

                try {

                    first.next.data = first.next.data + carry;
                } catch (NullPointerException e) {
                    Node g = new Node(carry);
                    t.next = g;
                    break;

                }
            }
            first = first.next;
            if (second != null) {
                second = second.next;
            }
        }
        head = reverse(head);

        return head;
    }
}