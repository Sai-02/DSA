/*
Given two lists sorted in increasing order,
 create a new list representing the intersection of the two lists.
  The new list should be made with its own memory — the original lists should 
  not be changed.

Example 1:

Input:
L1 = 1->2->3->4->6
L2 = 2->4->6->8
Output: 2 4 6
Explanation: For the given first two
linked list, 2, 4 and 6 are the elements
in the intersection.
Example 2:

Input:
L1 = 10->20->40->50
L2 = 15->40
Output: 40
Your Task:
The task is to complete the function intersection()
 which should find the intersection of two linked list
  and add all the elements in intersection to the third
   linked list and return the head of the third linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)
Note: n,m are the size of the linked lists.

Constraints:
1 <= size of linked lists <= 5000
1 <= Data in linked list nodes <= 1000
 */

// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

public class Intersection_of_two_sorted_Linked_lists {
    static Scanner sc = new Scanner(System.in);

    public static Node inputList(int size) {
        Node head, tail;
        int val;

        val = sc.nextInt();

        head = tail = new Node(val);

        size--;

        while (size-- > 0) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String args[]) {

        int t = sc.nextInt();
        while (t-- > 0) {
            int n, m;

            n = sc.nextInt();
            m = sc.nextInt();

            Node head1 = inputList(n);
            Node head2 = inputList(m);

            Sol00 obj = new Sol00();

            Node result = obj.findIntersection(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}// } Driver Code Ends

/*
 * Node of a linked list class Node { int data; Node next; Node(int d) { data =
 * d; next = null; } }
 */

class Sol00 {
    public static Node findIntersection(Node head1, Node head2) {
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        while (head1 != null) {
            h1.add(head1.data);
            head1 = head1.next;

        }
        Node head = new Node(0);
        Node temp = head;
        while (head2 != null) {
            if (h1.contains(head2.data)) {
                if (!h2.contains(head2.data)) {
                    if (head.data == 0) {
                        head.data = head2.data;
                        temp = head;
                    } else {
                        Node newNode = new Node(head2.data);
                        temp.next = newNode;
                        temp = temp.next;
                    }
                    h2.add(head2.data);

                }
            }
            head2 = head2.next;
        }
        return head;

    }
}


// =======================================================
// 
//  GFG Editorial
// 
// ======================================================


// class Sol
// {

//     public static Node findIntersection(Node head1, Node head2)
//     {
//         Node p1=head1, p2=head2;
//         Node head=null, tail=null;
        
//         while(p1!=null && p2!=null)
//             if(p1.data > p2.data)
//                 // nodes dont match
//                 // moving to next node in list with smaller node
//                 p2 = p2.next;
            
//             else if(p2.data > p1.data)
//                 // nodes dont match
//                 // moving to next node in list with smaller node
//                 p1 = p1.next;
            
//             else
//             {
//                 // nodes match
                
//                 if(head==null)
//                     head = tail = new Node(p1.data);
//                     // creating new head for intersection list
//                 else
//                 {
//                     // appending new node at the end
//                     tail.next = new Node(p1.data);
//                     tail = tail.next;
//                 }
//                 p1 = p1.next;
//                 p2 = p2.next;
//                 // moving to next nodes in both lists
//             }
        
//         return head;
//     }

// }
