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
    static Node subLinkedList(Node l1, Node l2) {
        Node t1 = l1;
        Node t2 = l2;

        while (t1.next != null) {
            Node temp = new Node(t1.next.data);
            temp.next = l1;
            l1 = temp;

            try {
                

                t1.next = t1.next.next;
            } catch (Exception e) {
                break;
            }

        }
        // System.out.println(count);
        while (t2.next != null) {
            Node temp = new Node(t2.next.data);
            temp.next = l2;
            l2 = temp;
            try {

                t2.next = t2.next.next;
            } catch (Exception e) {
                break;
            }

        }
        t1 = l1;
        t2 = l2;
        Node head = new Node(0);

        Node t = head;
        int i = 0;

        while (t2 != null) {
            if (t1.data <= 0) {
                t1.data = t1.data + 10;
                t1.next.data--;
            }
            int k = Math.abs(t1.data - t2.data);
            Node temp = new Node(k);
            if (i == 0) {
                t.data = temp.data;
                i++;
            } else {

                t.next = temp;
                t = t.next;
                t1 = t1.next;
                t2 = t2.next;
            }

        }
        while (t1 != null) {
            if (t1.data <= 0 && t1.next == null) {
                return head;
            }
            if (t1.data < 0) {
                t1.data = t1.data + 10;
                t1.next.data--;
            }
          
            int k = t1.data;
            Node temp = new Node(k);
            t.next = temp;
            t = t.next;
            t1 = t1.next;

        }

        return head;
    }
}