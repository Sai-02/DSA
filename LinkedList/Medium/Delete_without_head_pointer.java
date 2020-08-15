
/*
You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes.
 The task is to delete the node. Pointer/ reference to head node is not given. 
Note: No head reference is given to you.

Example 1:

Input:
N = 2
value[] = {1,2}
node = 1
Output: 2
Explanation: After deleting 1 from the
linked list, we have remaining nodes
as 2.
Example 2:

Input:
N = 4
value[] = {10,20,4,30}
node = 40
Output: 10 4 30
Explanation: After deleting 20 from
the linked list, we have remaining
nodes as 10, 4 and 30.
Your Task:
You only need to complete the function deleteNode that takes reference to the node that needs to be deleted. 
The printing is done automatically by the driver code.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= N <= 103 
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

public class Delete_without_head_pointer {
    Node head;
    Node tail;

    void printList(Node head) {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    Node search_Node(Node head, int k) {
        Node current = head;
        while (current != null) {
            if (current.data == k)
                break;
            current = current.next;
        }
        return current;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Delete_Node llist = new Delete_Node();
            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            int k = sc.nextInt();
            Node del = llist.search_Node(llist.head, k);

            GfG g = new GfG();
            if (del != null && del.next != null) {
                g.deleteNode(del);
            }
            llist.printList(llist.head);
            t--;
        }
    }
}

// } Driver Code Ends

/*
 * class Node { int data ; Node next; Node(int d) { data = d; next = null; } }
 */

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted











/*
=========================

Solution

=========================
*/


// There are 2 approahes to solve this problem
// 1. You can do this by swapping the values.
// 2. This method is a lot more efficient and requires you to have a good control over pointers. 
//     What if, you change the reference of the node to be deleted to the node placed just next to it?
//     Do you need to do something other than that?  ​Something to prevent memory leak situations? 
// 2. Copy the data of next node to the current node. 
// Then, link the node after the next node to the current node. 
// This way, next node is removed but its data is saved in the current node.
class GfG {
    void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
