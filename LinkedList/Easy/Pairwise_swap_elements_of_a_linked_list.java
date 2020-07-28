/*
Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.

Input:
The first line of input contains the number of test cases T. For each test case, 
the first line of input contains the length of the linked list and the next line contains linked list data.

Output:
Output the linked list after swapping pairwise nodes.

User Task:
The task is to complete the function pairWiseSwap() 
which takes the head node as the only argument and returns the modified head.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
1
8
1 2 2 4 5 6 7 8

Output:
2 1 4 2 6 5 8 7 
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

public class Pairwise_swap_elements_of_a_linked_list {

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

      Solution g = new Solution();
      head = g.pairwiseSwap(head);
      printList(head);
      t--;
    }
  }
}

// } Driver Code Ends

/* node class of the linked list
    
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    */

class Solution {

  // Function to pairwise swap elements of a linked list.
  // It should returns head of the modified list
  public Node pairwiseSwap(Node head) {
    try {
      if (head.next == null) {
        return head;
      }
      Node t = head;
      int temp = t.data;
      t.data = (t.next).data;
      (t.next).data = temp;
      t = t.next;
      t = t.next;
      while (t != null) {
        int Temp = t.data;
        t.data = (t.next).data;
        (t.next).data = Temp;
        t = t.next;
        t = t.next;
      }
    } catch (Exception e) {
      return head;
    }

    return head;
  }
}
