
/*
Given two singly linked lists of size N and M,
 write a program to get the point where two linked lists intersect each other.

Y ShapedLinked List
Above diagram shows an example with two linked list having 15 as intersection point.

Example 1:

Input:
LinkList1 = {10,20,5,10}
LinkList2 = {30,40,50,5,10}
Output: 5
Explanation:The point of intersection of
two linked list is 5, means both of them
get linked (intersects) with each other
at node whose value is 5.
Your Task:
The task is to complete the function intersetPoint() 
which finds the point of intersection of two linked list.
 The function should return data value of a node where two linked lists merge. 
 If linked list do not merge at any point, then it should return -1.

Challenge : Try to solve the problem without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100
1 <= value <= 1000 
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

public class Intersection_Point_in_Y_Shapped_Linked_Lists {
    Node head = null;
    Node tail = null;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            // Node temp = head;
            // while (temp.next != null)
            // temp = temp.next;

            // temp.next = node;
            tail.next = node;
            tail = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {

        /*
         * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
         */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            Intersection_Point_in_Y_Shapped_Linked_Lists llist1 = new Intersection_Point_in_Y_Shapped_Linked_Lists();
            Intersection_Point_in_Y_Shapped_Linked_Lists llist2 = new Intersection_Point_in_Y_Shapped_Linked_Lists();
            Intersection_Point_in_Y_Shapped_Linked_Lists llist3 = new Intersection_Point_in_Y_Shapped_Linked_Lists();

            int a1 = sc.nextInt();
            Node head1 = new Node(a1);
            Node tail1 = head1;

            for (int i = 1; i < n1; i++) {
                int a = sc.nextInt();
                tail1.next = (new Node(a));
                tail1 = tail1.next;
            }

            int b1 = sc.nextInt();
            Node head2 = new Node(b1);
            Node tail2 = head2;
            for (int i = 1; i < n2; i++) {
                int b = sc.nextInt();
                tail2.next = (new Node(b));
                tail2 = tail2.next;
            }

            int c1 = sc.nextInt();
            Node head3 = new Node(c1);
            tail1.next = head3;
            tail2.next = head3;
            Node tail3 = head3;
            for (int i = 1; i < n3; i++) {
                int c = sc.nextInt();
                tail3.next = (new Node(c));
                tail3 = tail3.next;
            }

            Intersect obj = new Intersect();
            System.out.println(obj.intersectPoint(head1, head2));
            t--;
        }
    }
}
// } Driver Code Ends

/*
 * Node of a linked list class Node { int data; Node next; Node(int d) { data =
 * d; next = null; } } Linked List class class LinkedList { Node head; // head
 * of list } This is method only submission. You only need to complete the
 * method.
 */
class Intersect {
    int length(Node head) {
        int l = 0;
        Node t = head;
        while (t != null) {
            t = t.next;
            l++;

        }
        return l;
    }

    int intersectPoint(Node headA, Node headB) {
        int nA = length(headA);
        int nB = length(headB);
        if (nA < nB) {
            Node temp = new Node(headA.data);
            temp.next = headA.next;
            headA.data = headB.data;
            headA.next = headB.next;
            headB.data = temp.data;
            headB.next = temp.next;

        }
        Node tA = headA;
        int d = Math.abs(nA - nB);
        for (int i = 1; i <= d; i++) {
            tA = tA.next;

        }
        Node tB = headB;
        while (tA.next != null) {
            if (tA.next == tB.next) {
                return tB.next.data;
            }
            tA = tA.next;
            tB = tB.next;
        }
        return -1;

    }
}
//==========================================================
//
//Approach
//
//==========================================================

// There are many methods to solve this problem.
// Method Using difference of node counts:

// 1) Get count of the nodes in the first list, let be c1.
// 2) Get count of the nodes in the second list, let be c2.
// 3) Get the difference of counts d = abs(c1 – c2)
// 4) Now traverse the bigger list from the first node till d nodes so that 
//   from here onwards both the lists have equal no of nodes.
// 5) Then we can traverse both the lists in parallel till we come across a common node.

