/*
Given two linked lists, the task is to complete the function findIntersection(),
 that returns the intersection of two linked lists. 
 Each of the two linked list contains distinct node values.

Example 1:

Input:
LinkedList1: 9->6->4->2->3->8
LinkedList2: 1->2->8->6
Output: 6 2 8
Your Task:
You task is to complete the function findIntersection() 
which takes the heads of the 2 input linked lists as parameter 
and returns the head of intersection list. Returned list will be
 automatically printed by driver code.
Note: The order of nodes in this list should be same as the order
 in which those particular nodes appear in input list 1.

Constraints:
1 <= n,m <= 104

Expected time complexity: O(m+n)
Expected auxiliary space: O(m+n)
 */

//{Driver Code Starts
//

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

public class Intersection_of_Two_Linked_Lists {
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
            Node head1 = inputList(n);

            m = sc.nextInt();
            Node head2 = inputList(m);

            Sol obj = new Sol();

            Node result = obj.findIntersection(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

/*
 * structure of list Node:
 * 
 * class Node { int data; Node next;
 * 
 * Node(int a) { data = a; next = null; } }
 * 
 */

class Sol {
    public static Node findIntersection(Node head1, Node head2) {
        HashSet<Integer> h = new HashSet<>();
        Node temp = head2;
        while (temp != null) {
            h.add(temp.data);
            temp = temp.next;
        }
        while (!h.contains(head1.data)) {
            head1 = head1.next;
        }
        Node prev = null;
        temp = head1;
        Node next = head1.next;
        while (temp != null) {
            if (!h.contains(temp.data)) {
                prev.next = next;
                temp = next;
                if (next != null) {

                    next = next.next;
                }
            } else {

                prev = temp;
                temp = temp.next;
                if (next != null) {
                    next = next.next;
                }
            }
        }
        return head1;
    }
}


// ====================================
// 
//  GFG Editorial
// 
// ====================================

// Use set/hashmap to store data from nodes of list 2.

// Then iterate over list 1. If any node in list 1 is found in set/hashmap,
//  add the data to intersection list.

//  class Sol
// {
//     public static Node findIntersection(Node head1, Node head2)
//     {
//         HashSet<Integer> st = new HashSet<Integer>();
//         while(head2!=null)
//         {
//             st.add(head2.data);
//             head2 = head2.next;
//         }
        
//         Node newHead=null, newTail=null;
        
//         while(head1!=null)
//         {
//             if( st.contains(head1.data) )
//             {
//                 if(newHead==null)
//                     newHead = newTail = new Node(head1.data);
//                 else
//                 {
//                     newTail.next = new Node(head1.data);
//                     newTail = newTail.next;
//                 }
//             }
//             head1 = head1.next;
//         }
        
//         return newHead;
//     }

// }
