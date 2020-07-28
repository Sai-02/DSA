/*
 
Given a doubly linked list, rotate the linked list counter-clockwise by P nodes.
 Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.

Input:
The first line of input contains an integer T denoting the no of test cases. For each test case,
 the first line of input contains two integers N and P denoting the number of nodes in Linked List 
 and the number of nodes to be rotated respectively.

Output:
For each test case, output the final linked list after the P rotations in it.

Constraints:
1 <= T <= 100
2 <= N <= 100
1 <= P <= N

Example:
Input:
1
6 2
1 2 3 4 5 6

Output:
3 4 5 6 1 2
 */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
  int data;
  Node prev, next;

  public Node(final int d) {
    this.data = d;
    prev = null;
    next = null;
  }
}

public class Rotate_doubly_Linked_List {

  static void display(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }

  public static void main(final String[] args) {
    final Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      final int n = sc.nextInt();
      final int p = sc.nextInt();

      //Entering the data
      final Node head = new Node(sc.nextInt());
      Node curr = head;

      //Entering the rest of the list
      for (int i = 0; i < n - 1; i++) {
        final int d = sc.nextInt();
        curr.next = new Node(d);
        curr = curr.next;
      }

      final Gfg2 obj = new Gfg2();
      display(obj.rotateP(head, p));
    }
  }
}

// } Driver Code Ends

//User function Template for Java

/*
class Node {
    int data;
    Node prev, next;
    
    public Node (int d){
        this.data = d;
        prev = null;
        next = null;
    }
}
*/

class Gfg2 {

  Node rotateP(Node head, final int p) {
    Node last = head;
    while (last.next != null) {
      last = last.next;
    }

    int i = 0;
    while (i < p) {
      i++;
      Node t = new Node(head.data);

      //   t.prev = last;
      last.next = t;
      last = last.next;
      head = head.next;
      head.prev = null;
      //   try{

      //       last.next=null;
      //     }
      //     catch(NullPointerException e){
      //         System.out.println(i);
      //     }
      //   //   head.prev = last;
      //   head = t.next;
      //   //   head.prev = null;
    }

    return head;
  }
}
