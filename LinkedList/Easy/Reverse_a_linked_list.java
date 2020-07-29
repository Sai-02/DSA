/*
Given a linked list of N nodes. The task is to reverse this list.

Input:
The first line of input contains the number of test cases T.
 For each test case, the first line contains the length of the linked list and
  the next line contains the elements of the linked list.

Output:
For each test case, print the reversed linked list in a new line.

User Task:
The task is to complete the function reverseList() with head reference
 as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
2
6
1 2 3 4 5 6
5
2 7 8 9 10
Output:
6 5 4 3 2 1
10 9 8 7 2 
*/

// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class Reverse_a_linked_list {

  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();

      Node head = new Node(sc.nextInt());
      Node tail = head;

      for (int i = 0; i < n - 1; i++) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
      }

      ReverseLL g = new ReverseLL();
      head = g.reverseList(head);
      printList(head);
      t--;
    }
  }
}

// } Driver Code Ends

//function Template for Java

/* linked list node class:
    
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    
    */

class ReverseLL {

  // This function should reverse linked list and return
  // head of the modified linked list.
  Node reverseList(Node head) {
    Node t = head;
    while (t.next != null) {
      Node temp = new Node((t.next).data);
      temp.next = head;
      head = temp;
      t.next = (t.next).next;
    }
    return head;
  }
}
