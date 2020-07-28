/*
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains a number of nodes in the linked list, and the next line contains node data for N nodes.

Output:
For each test case, print the linked list with no repeating elements.

User Task:
You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list.
 You should not read any input from the stdin/console.
  Your function should return a pointer to a linked list with no duplicate element.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
1 <= size of linked lists <= 104
1 <= numbers in list <= 104

Example:
Input:
2
4
5 2 2 4
5
2 2 2 2 2
Output:
5 2 4
2 
*/
// { Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class Remove_duplicates_from_an_unsorted_linked_list {
  Node head;
  Node temp;

  public void addToTheLast(Node node) {
    if (head == null) {
      head = node;
      temp = node;
    } else {
      temp.next = node;
      temp = node;
    }
  }

  void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  /* Drier program to test above functions */
  public static void main(String args[]) {
    /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();
      Remove_duplicates_from_an_unsorted_linked_list llist = new Remove_duplicates_from_an_unsorted_linked_list();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }
      //llist.printList();
      GfG4 g = new GfG4();
      llist.head = g.removeDuplicates(llist.head);
      llist.printList();

      t--;
    }
  }
}

// } Driver Code Ends

/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class GfG4 {
  // Function to remove duplicates from the given linked list
  HashSet<Integer> a = new HashSet<Integer>();

  public Node removeDuplicates(Node head) {
    Node t = head;
    a.add(t.data);

    while (t.next != null) {
      if (a.contains((t.next).data)) {
        t.next = (t.next).next;
      } else {
        a.add((t.next).data);
        t = t.next;
      }
    }
    return head;
  }
}
