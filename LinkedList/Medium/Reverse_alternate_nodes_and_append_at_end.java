
/*
Given a linked list, you have to perform the following task:

Extract the alternative nodes from starting from second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.
Input:
First line of input contains number of testcases T. 
For each testcase, first line of input contains number of testcases T. 
For each testcase, first line of input contains length of the linked list 
and next line contains the elements of the linked list.

Output:
The task is to modify the linked list as required.

User Task:
The task is to complete the function rearrange() which should rearrange the list as required.

Note: Try to solve the problem without using any extra memory.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 50
1 <= Node_value <= 1000

Input:
2
8
10 4 9 1 3 5 9 4
5
1 2 3 4 5

Output:
10 9 3 9 4 5 1 4
1 3 5 4 2 

Explanation:
Testcase 1: Reversing the alternative nodes from the given list, 
and then appending them to the end of the list results in a list with the elements as 10 9 3 9 4 5 1 4.
  
*/
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Reverse_alternate_nodes_and_append_at_end {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }

            GfG12 gfg = new GfG12();
            gfg.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }

    public static void printLast(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends

/*
 * node class of the linked list class Node { int data; Node next; Node(int key)
 * { data = key; next = null; } }
 */
class GfG12 {
    public static void rearrange(Node odd) {
        if (odd == null || odd.next == null)
            return;

        Node t = odd;

        Node Odd = new Node(0);
        Node store = Odd;
        int i = 0;
        while (t != null && t.next != null) {
            Node temp = new Node(t.next.data);
            if (i == 0) {
                Odd.data = temp.data;
                store = Odd;
                i++;

            } else {
                store.next = temp;
                store = store.next;
            }
            t.next = t.next.next;
            try {

                t = t.next;
            } catch (NullPointerException e) {
                break;
            }

        }
        t = Odd;
        while (t.next != null) {
            Node temp = new Node((t.next).data);
            temp.next = Odd;
            Odd = temp;
            t.next = (t.next).next;
        }
        t = odd;
        while (t.next != null) {
            t = t.next;
        }
        t.next = Odd;

    }
}
