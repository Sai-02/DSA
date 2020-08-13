/* 
Given two linked lists that represent two large positive numbers. 
The task is to subtract the given two numbers represented by the li
nked list. Subtract the smaller from the larger one.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. 
The first line of each test case contains an integer N
 denoting the size of the first linked list (L1) 
  In the next line are the space-separated values of the first linked list
  . The third line of each test case contains an integer M denoting the 
  size of the second linked list (L2). In the fourth line are space-separated values
   of the second linked list.

Output:
For each test case, the output will be space-separated 
values of the resultant linked list. 

User Task:
The task is to complete the function subLinkedList()
 which should subtract the numbers represented by the linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N, M <= 10000

Example:
Input:
1
3
1 0 0
2
1 2

Output:
8 8
*/
// { Driver Code Starts
// driver

import java.util.*;
import java.math.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Subtraction_in_Linked_List {

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

            Solution1 g = new Solution1();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends

/*
 * Structure of Linked list node
 * 
 * class Node { int data; Node next; Node(int d) { data = d; next = null; } }
 * 
 */

class Solution1 {
    // static int length(Node n) {
    // int count = 0;
    // Node t = n;
    // while (t != null) {
    // count++;
    // t = t.next;
    // }
    // return count;
    // }

    // static Node subLinkedList(Node l1, Node l2) {
    // Node t1 = l1;
    // Node t2 = l2;
    // while (t1.next != null) {
    // Node temp = new Node((t1.next).data);
    // temp.next = l2;
    // l1 = temp;
    // t1.next = (t1.next).next;
    // }
    // while (t2.next != null) {
    // Node temp = new Node((t2.next).data);
    // temp.next = l2;
    // l2 = temp;
    // t2.next = (t2.next).next;
    // }
    // int n1 = length(l1);
    // int n2 = length(l2);
    // if (n1 >= n2) {
    // t1 = l1;
    // t2 = l2;

    // } else {
    // t1 = l2;
    // t2 = l1;
    // }
    // int i = 0;
    // Node head = new Node(0);
    // Node t = head;
    // while (t1 != null) {
    // int small = 0;
    // if (t2 != null) {
    // small = t2.data;
    // }
    // if (t1.data < small) {
    // t1.next.data = t1.next.data - 1;
    // t1.data = t1.data + 10;
    // // taking carry
    // }
    // Node temp = new Node(t1.data - small);
    // if (i == 0) {
    // t.data = temp.data;
    // i++;
    // } else {
    // t.next = temp;
    // t = t.next;
    // }
    // t1 = t1.next;
    // if (t2.next != null) {
    // t2 = t2.next;
    // }

    // }
    // // while (head.next != null && head.data == 0) {

    // // head = head.next;
    // // }

    // return head;
    // }
    static int length(Node n) {
        int ret = 0;
        while (n != null) {
            ret += 1;
            n = n.next;
        }
        return ret;
    }

    static Node reverse(Node head)
    // this function reverses the linked list
    {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next; // storing next node
            current.next = prev; // linking current node to previous
            prev = current; // updating prev
            current = next; // updating current
        }

        return prev;
    }

    static Node subLinkedList(Node l1, Node l2) {
        while (l1 != null && l1.data == 0)
            l1 = l1.next;
        // removing trailing zeroes from l1

        while (l2 != null && l2.data == 0)
            l2 = l2.next;
        // removing trailing zeroes from l2

        int n1 = length(l1);
        int n2 = length(l2);

        if (n2 > n1) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // making sure l1 list has the bigger number

        if (n1 == n2) {
            Node t1 = l1, t2 = l2;
            while (t1.data == t2.data)
            // finding which number is greater
            {
                t1 = t1.next;
                t2 = t2.next;

                if (t1 == null)
                    return new Node(0);
                // returning zero if both numbers are same
            }
            if (t2.data > t1.data) {
                Node temp = l1;
                l1 = l2;
                l2 = temp;
            }
            // making sure l1 list has the bigger number
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        Node res = null;
        Node t1 = l1, t2 = l2;
        while (t1 != null) {
            int small = 0;
            if (t2 != null)
                small = t2.data;
            // 'small' holds the next digit of number to be subtracted

            if (t1.data < small) {
                t1.next.data = t1.next.data - 1;
                t1.data = t1.data + 10;
                // taking carry
            }

            Node n = new Node(t1.data - small);
            // creating new node for storing difference
            n.next = res;
            res = n;

            t1 = t1.next;
            if (t2 != null)
                t2 = t2.next;
        }

        while (res.next != null && res.data == 0)
            res = res.next;
        // removing trailing zeroes from result list

        return res;
    }
}