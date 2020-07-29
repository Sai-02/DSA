/*
Given a linked list consisting of L nodes and given a number N. 
The task is to find the Nth node from the end of the linked list.

Input:
The first line of input contains the number of testcase T. 
For each testcase, 
the first line of input contains the number of nodes in the linked list and the number N. 
The next line contains L nodes of the linked list.

Output:
For each testcase, output the data of node which is at Nth distance from the end or -1 in case node doesn't exist.

User Task:
The task is to complete the function getNthFromLast() which takes two arguments: 
reference to head and N and you need to return Nth from the end.

Note:
Try to solve in single traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 200
1 <= L <= 103
1 <= N <= 103

Example:
Input:
2
9 2
1 2 3 4 5 6 7 8 9
4 5
10 5 100 5
Output:
8
-1

Explanation:
Testcase 1: In the first example, there are 9 nodes in linked list and we need to find 2nd node from end.
 2nd node from end os 8.  
Testcase 2: In the second example, 
there are 4 nodes in the linked list and we need to find 5th from the end. 
Since 'n' is more than the number of nodes in the linked list, the output is -1. 
*/
// { Driver Code Starts
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class Nth_node_from_end_of_linked_list {
  Node head;
  Node tail;

  /* Function to print linked list */
  void printList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  /* Inserts a new Node at front of the list. */
  public void addToTheLast(Node node) {
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  /* Drier program to test above functions */
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      Nth_node_from_end_of_linked_list llist = new Nth_node_from_end_of_linked_list();
      //int n=Integer.parseInt(br.readLine());
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }

      //System.out.println(llist.head.data);
      GfG7 g = new GfG7();
      //System.out.println(k);
      System.out.println(g.getNthFromLast(llist.head, k));

      t--;
    }
  }
}

// } Driver Code Ends

/* Structure of node
    
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */

class GfG7 {

  // Function to find the nth node from end in the linked list
  // head: head of the linked list
  // n: nth node from end to find
  int getNthFromLast(Node head, int n) {
    Node t = head;
    int l = 0;
    while (t != null) {
      t = t.next;
      l++;
    }
    l = l - n;
    if (l < 0) {
      return -1;
    } else {
      t = head;
      n = 0;
      while (t != null) {
        if (l == n) {
          return t.data;
        }
        t = t.next;
        n++;
      }
    }
    return -1;
  }
}
