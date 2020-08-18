
/* 
Given a singly linked list,
 remove all the nodes which have a greater value on its next adjacent element.

Input:
First line of input contains numbe of testcases T.
 For each testcase, first line of input contains length of the linked list 
 and next line contains the elements of the linked list.

Output:
For each testcase, print the modified linked list.

User Task:
The task is to complete the function compute() which should modify the list as required.
 The printing is done by the driver code,

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 1000
1 <= size of linked list <= 1000
1 <= element of linked list <= 1000
Note: Try to solve the problem without using any extra space.

Example:
Input:
3
8
12 15 10 11 5 6 2 3
6
10 20 30 40 50 60
6
60 50 40 30 20 10

Output:
15 11 6 3
60
60 50 40 30 20 10

Explanation:
Testcase 1: Since, 12, 10, 5 and 2 are the elements which have greater elements on their next node.
 So, after deleting them, the linked list would like be 15, 11, 6, 3.
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

public class Delete_nodes_having_greater_value_on_right {

    /* Function to print linked list */
    public static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {

        /*
         * Constructed Linked List is 1.2.3.4.5.6. 7.8.8.9.null
         */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt()) {
            int n = sc.nextInt();

            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt(); i++) {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            Node result = new GfG().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends

/*
 * class Node { int data; Node next;
 * 
 * Node(int data) { this.data = data; } }
 */
class GfG {
    Node compute(Node head) {

        if (head == null || head.next == null)
            return head;
        // Reverse the list
        Node t = head;
        while (t.next != null) {
            Node temp = new Node((t.next).data);
            temp.next = head;
            head = temp;
            t.next = (t.next).next;
        }
        t = head;
        Node max = head;
        while (t.next != null && t != null) {
            if (t.next.data < max.data) {
                t.next = t.next.next;

            } else {
                t = t.next;
                max = t;
            }
        }
        // Reverse the list
        t = head;
        while (t.next != null) {
            Node temp = new Node((t.next).data);
            temp.next = head;
            head = temp;
            t.next = (t.next).next;
        }

        return head;
    }
}
