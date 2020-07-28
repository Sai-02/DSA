/*
Given a linked list, the task is to move all 0’s to the front of the linked list. 
The order of all another element except 0 should be same after rearrangement.

Input:
The first line of input contains an integer T denoting the number of test cases. 
For each test case, the first line contains an integer N 
denoting the number of elements in the Linked List and the second line
 contains N-space separated integer inputs i.e. elements in the Linked List.

Output:
For each test case, the output is the modified linked list having all 0's in front.

User Task:
The task is to complete the function moveZeroes() which should move all the 0's to the front of the list.

Constraints:
1 <= T <= 100
1 <= N <= 50
Note: List is from back to front.

Example:
Input:
2
10
0 1 0 1 2 0 5 0 4 0
7
0 0 0 3 2 1 1

Output:
0 0 0 0 0 4 5 2 1 1
0 0 0 1 1 2 3 
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

public class Move_all_zeros_to_the_front_of_the_linked_list {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      Node head = null;
      while (n-- > 0) {
        int a = sc.nextInt();
        if (head == null) {
          head = new Node(a);
        } else {
          Node temp = new Node(a);
          temp.next = head;
          head = temp;
        }
      }
      GfG3 g = new GfG3();
      head = g.moveZeroes(head);
      while (head != null) {
        System.out.print(head.data + " ");
        head = head.next;
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends

//User function Template for Java

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/

class GfG3 {

  public Node moveZeroes(Node head) {
    Node t = head;
    if (t.data == 0) {
      t = t.next;
    }
    while (t.next != null) {
      if ((t.next).data == 0) {
        Node temp = new Node(0);
        temp.next = head;
        head = temp;
        t.next = (t.next).next;
      } else {
        t = t.next;
      }
    }
    return head;
  }
}
