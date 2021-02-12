/*
Given two linked lists, your task is to complete 
the function makeUnion(), that returns the union of two linked lists. 
This union should include all the distinct elements only.

Example 1:

Input:
L1 = 9->6->4->2->3->8
L2 = 1->2->8->6->2
Output: 1 2 3 4 6 8 9
Your Task:
The task is to complete the function makeUnion()
 which makes the union of the given two lists and returns
  the head of the new list.

Note: The new list formed should be in non-decreasing order.

Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1<size of the linked lists<=5000
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

public class Union_of_Two_Linked_Lists {
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

            Sol5 obj = new Sol5();

            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}// } Driver Code Ends

/*
 * class Node { int data; Node next; Node(int d) {data = d; next = null; } }
 */

class Sol5 {
    public static Node findUnion(Node head1, Node head2) {
        ArrayList<Integer> a = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();
        while (head1 != null) {
            if (!h.contains(head1.data)) {
                a.add(head1.data);
                h.add(head1.data);
            }
            head1 = head1.next;
        }

        while (head2 != null) {
            if (!h.contains(head2.data)) {
                a.add(head2.data);
                h.add(head2.data);
            }
            head2 = head2.next;
        }
        Collections.sort(a);
        int length = a.size();
        Node head = null;
        Node temp = null;
        for (int i = 0; i < length; i++) {
            if (head == null) {
                head = new Node(a.get(i));
                temp = head;
            } else {
                Node newNode = new Node(a.get(i));
                temp.next = newNode;
                temp = temp.next;
            }
        }
        return head;

    }
}

// ========================================
// 
//  GFG Editorial
// 
// ========================================


// class Sol
// {
// 	public static Node findUnion(Node head1,Node head2)
// 	{
//         Node cur=null,start=null;
        
//         TreeSet<Integer> s = new TreeSet<Integer>();        
//         // using tree set to store numbers in sorted order
        
//         while(head1!=null)
//         {
//             // adding all numbers in list1 to set
//             s.add(head1.data);
//             head1=head1.next;
//         }
//         while(head2!=null)
//         {
//             // adding all numbers in list2 to set
//             // duplicates will be ignored in set
//             s.add(head2.data);
//             head2=head2.next;
//         }
//         for(Integer i : s)
//         { 
//             Node ptr=new Node(i);
//             if(start==null)
//             {
//                 // creating new head
//                 start=ptr;
//                 cur=ptr;
//             }
//             else
//             {
//                 // appending node at the end
//                 cur.next=ptr;
//                 cur=ptr;
//             }
//         }
//         return start;
// 	}
// }
