/*
Given a sorted linked list, delete all nodes that have duplicate numbers
 (all occurrences), leaving only numbers that appear once in the original list. 

Example 1:

Input: 
N = 8
Linked List = 23->28->28->35->49->49->53->53
Output: 
23 35
Explanation:
The duplicate numbers are 28, 49 and 53 which 
are removed from the list.
Example 2:

Input:
N = 6
Linked List = 11->11->11->11->75->75
Output: 
Empty list
Explanation:
All the nodes in the linked list have 
duplicates. Hence the resultant list 
would be empty.
Your task:
You don't have to read input or print anything.
 Your task is to complete the function removeAllDuplicates()
  which takes the head of the linked list, 
  removes all the occurences of duplicates in the linked list
   and returns the head of the modified linked list.
 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 
Constraints:
1 ≤ N ≤ 10^5
 

Company Tags
*/

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Remove_all_occurences_of_duplicates_in_a_linked_list {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            Remove_all_occurences_of_duplicates_in_a_linked_list llist = new Remove_all_occurences_of_duplicates_in_a_linked_list();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution11 ob = new Solution11();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }

}// } Driver Code Ends

// User function Template for Java

/*
 * Linked List Node class
 * 
 * class Node { int data; Node next; }
 * 
 */

// =========================================================================
//
// Solution in O(n) Time Complexity and O(n) Space Complexity
//
// =========================================================================

class Solution11 {
    public static Node removeAllDuplicates(Node head) {
        HashSet<Integer> h = new HashSet<>();
        Node temp = head, prev = null;
        while (temp != null) {
            if (prev != null) {
                if (prev.data == temp.data) {
                    h.add(prev.data);

                }
            }
            prev = temp;
            temp = temp.next;
        }
        while (h.contains(head.data)) {
            head = head.next;
            if (head == null)
                return head;
        }
        prev = null;
        Node curr = head;
        while (curr != null) {
            if (h.contains(curr.data)) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

}

// ===============================================================================
//
// Soluttion in O(n) time and O(1) space
//
// ================================================================================

class Solution11 {
    public static Node removeAllDuplicates(Node head) {
        boolean del = false;
        while (head != null) {
            if (head.next != null) {
                if (head.data == head.next.data) {
                    head.next = head.next.next;
                    del = true;
                } else {
                    if (del) {
                        head = head.next;
                        del = false;
                    } else {
                        break;
                    }
                }

            } else {
                return head;
            }
        }
        if (head == null || head.next == null) {

            return head;
        }
        Node prev = head, curr = head.next;
        del = false;
        while (curr != null) {
            if (curr.next != null) {
                if (curr.data == curr.next.data) {
                    curr.next = curr.next.next;
                    del = true;
                } else {
                    if (del) {
                        prev.next = curr.next;
                        curr = prev.next;
                        del = false;
                    } else {
                        prev = curr;
                        curr = curr.next;
                    }
                }
            } else {
                if (del) {
                    prev.next = null;
                }
                return head;
            }
        }

        return head;

    }
}
// ======================================================================
// 
// More Optimized Solution
// 
// ======================================================================

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode prev=dummyNode,curr=head,next=head.next;
        int lastRepeatedNodeValue=Integer.MIN_VALUE;
        while(curr!=null&&curr.next!=null){
            if(lastRepeatedNodeValue==curr.val){
                prev.next=curr.next;
                curr=prev.next;
            }
            else if(curr.val==curr.next.val){
                lastRepeatedNodeValue=curr.val;
                curr.next=curr.next.next;
            }
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        if(curr!=null&&curr.val==lastRepeatedNodeValue){
            prev.next=null;
        }
        return dummyNode.next;
    }
}