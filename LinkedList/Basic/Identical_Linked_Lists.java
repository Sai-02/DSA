/*
Given two Singly Linked List of N and M nodes respectively. 
The task is to check whether two linked lists are identical or not. 
Two Linked Lists are identical when they have same data and with same arrangement too.

Input:
The first line of input contains the number of test cases T.
 For each test case, the first line of input contains the length of linked lists N and M and
  the next line contains elements of the linked lists.

Output:
For each test, the output will be 'Identical' if two lists are identical else 'Not identical'.

User Task:
The task is to complete the function areIdentical() 
which takes the head of both linked lists as arguments and returns True or False.

Constraints:
1 <= T <= 100
1 <= N <= 103

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Example:
Input:
2
6
1 2 3 4 5 6
4
99 59 42 20
5
1 2 3 4 5
5
1 2 3 4 5
Output:
Not identical
Identical 
*/

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class Identical_Linked_Lists {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Node head1 = null, head2 = null, tail1 = null, tail2 = null;

      //Input first LL
      int n1 = sc.nextInt();
      int d1 = sc.nextInt();
      head1 = new Node(d1);
      tail1 = head1;

      while (n1-- > 1) {
        Node n = new Node(sc.nextInt());
        tail1.next = n;
        tail1 = tail1.next;
      }

      //Input second LL
      int n2 = sc.nextInt();
      int d2 = sc.nextInt();
      head2 = new Node(d2);
      tail2 = head2;

      while (n2-- > 1) {
        Node n = new Node(sc.nextInt());
        tail2.next = n;
        tail2 = tail2.next;
      }

      Solution obj = new Solution();
      if (obj.isIdentical(head1, head2)) System.out.println(
        "Identical"
      ); else System.out.println("Not identical");
    }
  }

  public static void po(Object o) {
    System.out.println(o);
  }

  public static void show(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}

// } Driver Code Ends

/*
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}*/

class Solution {

  // Function which returns true if both linked
  // lists are identical else return false
  public boolean isIdentical(Node head1, Node head2) {
    Node t1 = head1;
    Node t2 = head2;
    while (t1 != null || t2 != null) {
      if (t1 == null) {
        return false;
      } else if (t2 == null) {
        return false;
      } else {
        if (t1.data == t2.data) {
          t1 = t1.next;
          t2 = t2.next;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
