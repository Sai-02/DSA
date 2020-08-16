
/*
You are given a linked list of N nodes. The task is to remove the loop from the linked list, if present. 

Note: C is the position of the node to which the last node is connected. If it is 0 then no loop.

Example 1:

Input:
N = 3
value[] = {1,3,4}
C = 2
Output: 1
Explanation: In the first test case
N = 3.The linked list with nodes
N = 3 is given. Here, x = 2 which
means last node is connected with xth
node of linked list. Therefore, there
exists a loop. 

Example 2:
Input:
N = 4
value[] = {1,8,3,4}
C = 0
Output: 1
Explanation: N = 4 and x = 0, which
means lastNode->next = NULL, thus
the Linked list does not contains
any loop.
Your Task:
Your task is to complete the function removeLoop().
 The only argument of the function is head pointer of the linked list. 
 Simply remove the loop in the list (if present) without disconnecting any nodes from the list.
  The driver code will print 1 if your code is correct.

Expected time complexity : O(n)

Expected auxiliary space : O(1)

Constraints:
1 <= N <= 104

  
*/
// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
}

public class Remove_loop_in_Linked_List {
    public static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x) {
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x) {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head) {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise) {
            if (hare == null || hare.next == null)
                return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head) {
        int ret = 0;
        while (head != null) {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, pos);

            solver x = new solver();
            x.removeLoop(head);

            if (detectLoop(head) || length(head) != n)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends

/*
 * class Node { int data; Node next; }
 */

class solver {

    // public static boolean IsLoop(Node head) {
    // Node slow = head;
    // Node fast = head;
    // while (slow != null && fast != null && fast.next != null) {
    // slow = slow.next;
    // fast = fast.next.next;
    // if (slow == fast) {
    // return true;
    // }

    // }
    // return false;

    // }

    // public static void removeLoop(Node head) {
    // Node fast, slow, start;
    // slow = fast = head;
    // if (IsLoop(head)) {

    // while (slow != null && fast != null && fast.next != null) {
    // fast = fast.next.next;
    // slow = slow.next;
    // if (slow == fast) {
    // break;

    // }
    // }
    // int k = 0;

    // while (fast.next != slow) {
    // fast = fast.next;
    // k++;

    // }

    // fast = head;
    // start = head;
    // for (int i = 0; i < k; i++) {
    // fast = fast.next;

    // }

    // while (fast != start) {
    // fast = fast.next;
    // start = start.next;
    // }
    // start.next = null;
    // }
    // }

    public static void removeLoop(Node head) {
        if (head == null)
            return;

        Node fast = head.next;
        Node slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return;
            fast = fast.next.next;
            slow = slow.next;
        }

        int size = 1;
        fast = fast.next;
        while (fast != slow) {
            size += 1;
            fast = fast.next;
        }

        slow = head;
        fast = head;
        for (int i = 0; i < size - 1; i++)
            fast = fast.next;

        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
    }
}