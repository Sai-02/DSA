/* 
Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the given list (if exists).
Note: Try not to use extra space. Expected time complexity is O(N). The nodes are arranged in a sorted way.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list and next line contains the linked list data.

Output:
For each testcase, there will be a single line of output which contains linked list with no duplicates.

User Task:
The task is to complete the function removeDuplicates() which should remove the duplicates from linked list. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
2
4
2 2 4 5
5
2 2 2 2 2
Output:
2 4 5
2

Explanation:
Testcase 1: In the given linked list 2 ->2 -> 4-> 5, only 2 occurs more than 1 time.
Testcase 2: In the given linked list 2 ->2 ->2 ->2 ->2, 2 is the only element and is repeated 5 times.
 
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

public class Remove_duplicate_element_from_sorted_Linked_List {
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
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      Remove_duplicate_element_from_sorted_Linked_List llist = new Remove_duplicate_element_from_sorted_Linked_List();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }

      GfG6 g = new GfG6();
      llist.head = g.removeDuplicates(llist.head);
      llist.printList();

      t--;
    }
  }
} // } Driver Code Ends

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG6 {

  // head: head node
  Node removeDuplicates(Node root) {
    try {
      Node prev, current, next;
      prev = null;
      current = root;
      next = root.next;
      while (current.data == next.data) {
        current.next = next.next;
        next = current.next;
      }
      //         else{

      //    current=root.next;
      //    prev=root;
      //    next=current.next;
      //         }
      while (current.next != null) {
        if (current.data == next.data) {
          prev.next = next;
          current = next;
          next = next.next;
        } else {
          prev = current;
          current = current.next;
          next = next.next;
        }
      }
      return root;
    } catch (Exception e) {
      return root;
    }
  }
}
