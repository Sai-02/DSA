/*

*/

// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

public class Flattening_a_Linked_List {
    Node head;

    void printList(Node node) {
        // Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Flattening_a_Linked_List list = new Flattening_a_Linked_List();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            // list.printList();
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}// } Driver Code Ends

/*
 * Node class used in the program class Node { int data; Node next; Node bottom;
 * 
 * Node(int d) { data = d; next = null; bottom = null; } }
 */
/*
 * Function which returns the root of the flattened linked list.
 */
class GfG {
    Node flatten(Node root) {
        Node dum = null;
        Node next = null;
        while (root != null) {
            next = root.next;
            root.next = null;
            dum = merge(dum, root);
            root = next;
        }
        return dum;

    }

    Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        // Node temp1=head1,temp2=head2;
        Node head = null, temp = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (head == null) {
                    head = head1;
                    head1 = head1.bottom;
                    temp = head;
                    temp.bottom = null;
                } else {
                    temp.bottom = head1;
                    head1 = head1.bottom;
                    temp = temp.bottom;
                    temp.bottom = null;
                }
            } else {
                if (head == null) {
                    head = head2;
                    head2 = head2.bottom;
                    temp = head;
                    temp.bottom = null;
                } else {
                    temp.bottom = head2;
                    head2 = head2.bottom;
                    temp = temp.bottom;
                    temp.bottom = null;
                }
            }
        }
        if (head1 != null) {
            temp.bottom = head1;
        }
        if (head2 != null) {
            temp.bottom = head2;
        }
        return head;

    }
}