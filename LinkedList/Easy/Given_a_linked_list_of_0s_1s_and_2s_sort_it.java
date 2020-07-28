/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. 
The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side,
 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Input:
The first line of input contains the number of test cases T. 
For each test case, the first line of input contains the length of the linked list and
 next line contains N elements as the data in the linked list.

Output:
For each test case, segregate the 0s, 1s, and 2s and display the linked list.

Your Task:
The task is to complete the function segregate() which segregates
 the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. 
 The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
8
1 2 2 1 2 0 2 2
4
2 2 0 1
Output:
0 1 1 2 2 2 2 2
0 1 2 2

Explanation:
Testcase 1: All the 0s are segregated to the left end of the linked list, 
2s to the right end of the list, and 1s in between.
Testcase 2: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.

  
*/
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class Given_a_linked_list_of_0s_1s_and_2s_sort_it {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      Node head = new Node(sc.nextInt());
      Node tail = head;
      while (n-- > 1) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
      }

      head = new LinkedList().segregate(head);
      printList(head);
      System.out.println();
    }
  }

  public static void printList(Node head) {
    if (head == null) return;

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }
}

// } Driver Code Ends

//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList {

  static Node segregate(Node head) {
    Node t = head;
    int zero = 0, one = 0;
    while (t != null) {
      if (t.data == 0) {
        zero++;
      } else if (t.data == 1) {
        one++;
      }
      t = t.next;
    }
    t = head;
    while (t != null) {
      if (zero > 0) {
        t.data = 0;
        zero--;
      } else if (one > 0) {
        t.data = 1;
        one--;
      } else {
        t.data = 2;
      }
      t = t.next;
    }
    return head;
  }
}
