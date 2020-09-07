/*
Given a singly linked list of N nodes. 
The task is to find the middle of the linked list.
 For example, if given linked list is 1->2->3->4->5 then the output should be 3.
If there are even nodes, then there would be two middle nodes,
 we need to print the second middle element.
 
 For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.

Input:

The first line of input contains the number of test cases T.
 For each test case, the first line of input contains the length of the linked list and 
 the next line contains data of nodes of the linked list.

Output:
For each test case, there will be a single line of output containing data of the middle element of the linked list.

User Task:
The task is to complete the function getMiddle()
 which takes a head reference as the only argument and should return the data at the middle node of the linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 500
1 <= N <= 5000

Example:
Input:
2
5
1 2 3 4 5
6
2 4 6 7 5 1

Output:
3
7

Explanation:
Testcase 1: Since there are 5 elements, therefore 3 is the middle element at index 2 (0-based indexing).
  
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

public class Finding_middle_element_in_a_linked_list {

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
      Solution1 g = new Solution1();
      int ans = g.getMiddle(head);
      System.out.println(ans);
      // printList(head);
      t--;
    }
  }
}

// } Driver Code Ends

/*
 * Node of a linked list class Node { int data; Node next; Node(int d) { data =
 * d; next = null; } }
 */

// class Solution {

// int getMiddle(Node head) {
// int n = 0;
// Node t = head;
// while (t != null) {
// t = t.next;
// n++;
// }

// n = n / 2;
// n++;
// t = head;
// int i = 1;
// while (t != null) {
// if (i == n) {
// return t.data;
// }
// i++;
// t = t.next;
// }
// return -1;
// }
// }

// =================================================
//
// Solution in one iteration using two pointers
//
// ==================================================

class Solution1 {
  int getMiddle(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.data;
  }
}
