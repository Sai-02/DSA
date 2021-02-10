/*
Given two sorted linked lists consisting of N and M nodes respectively. 
The task is to merge both of the list (in-place) and return head of the merged list.
 

Example 1:

Input:
N = 4, M = 3 
valueN[] = {5,10,15,40}
valueM[] = {2,3,20}
Output: 2 3 5 10 15 20 40
Explanation: After merging the two linked
lists, we have merged list as 2, 3, 5,]
10, 15, 20, 40.
Example 2:

Input:
N = 2, M = 2
valueN[] = {1,1}
valueM[] = {2,4}
Output:1 1 2 4
Explanation: After merging the given two
linked list , we have 1, 1, 2, 4 as
output.
Your Task:
The task is to complete the function sortedMerge()
 which takes references to the heads of two linked lists as 
 the arguments and returns the head of merged linked list.

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N, M <= 104
1 <= Node's data <= 105

Company Tags
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

public class Merge_two_sorted_linked_lists {
    Node head;

    /* Function to print linked list */
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
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
            Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for (int i = 0; i < n1 - 1; i++) {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
            Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for (int i = 0; i < n2 - 1; i++) {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }

            LinkedList obj = new LinkedList();
            Node head = obj.sortedMerge(head1, head2);
            printList(head);

            t--;

        }
    }
}
// } Driver Code Ends

/*
 * Merge two linked lists head pointer input could be NULL as well for empty
 * list Node is defined as class Node { int data; Node next; Node(int d) {data =
 * d; next = null; } }
 */

class LinkedList {
    Node sortedMerge(Node headA, Node headB) {
        Node head = new Node(0);
        Node curr = head;
        while (headA != null || headB != null) {
            if (headA == null) {
                curr.next = headB;
                break;

            } else if (headB == null) {
                curr.next = headA;
                break;
            } else if (headA.data > headB.data) {
                curr.next = headB;
                headB = headB.next;
            } else {
                curr.next = headA;
                headA = headA.next;
            }
            curr = curr.next;
        }
        return head.next;

    }
}


// ====================================
// 
//  GFG Editorial
// 
// ====================================


// 1. Take a r_head node which should be the head of merged linked list.
//  Two pointers seperate to the head of given linked lists as h1 and h2.
// 2. Now, compare the head of the first and second linked list.
//  Assign the r_head to the head of that linked list and increment
//   head of that list to next. 
//     Also, take pointer temp which should keep track of the nodes in resultant merged list.
//      First assigned to smallest node.
// 3. Now, after following the above two steps you determined the first smallest node. Agai, move the h1 or h2 accordingly (whose node is smaller).
// 4. Do the comparison again between h1 and h2. Also, whomsoever is smaller (move tail->next to that node), and tail = tail->next. Do the steps  
//     continuously till all nodes of any of the list gets exhausted.







// class LinkedList
// {
// 	Node sortedMerge(Node headA, Node headB) 
//     { 
      
//     /* a dummy first node to  
//        hang the result on */
//     Node dummyNode = new Node(0); 
      
//     /* tail points to the  
//     last result node */
//     Node tail = dummyNode; 
//     while(true)  
//     { 
          
//         /* if either list runs out,  
//         use the other list */
//         if(headA == null) 
//         { 
//             tail.next = headB; 
//             break; 
//         } 
//         if(headB == null) 
//         { 
//             tail.next = headA; 
//             break; 
//         } 
          
//         /* Compare the data of the two 
//         lists whichever lists' data is  
//         smaller, append it into tail and 
//         advance the head to the next Node 
//         */
//         if(headA.data <= headB.data) 
//         { 
//             tail.next = headA; 
//             headA = headA.next; 
//         }  
//         else
//         { 
//             tail.next = headB; 
//             headB = headB.next; 
//         } 
          
//         /* Advance the tail */
//         tail = tail.next; 
//     } 
//     return dummyNode.next; 
// }  
// }

 