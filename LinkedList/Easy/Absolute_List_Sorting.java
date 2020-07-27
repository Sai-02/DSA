/*
Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data.
 Sort the linked list according to the actual values.
Ex: Input : 1 -> -2 -> -3 -> 4 -> -5 
      Output: -5 -> -3 -> -2 -> 1 -> 4

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 Each test case consists of two lines. 
 The first line of each test case contains a positive integer N denoting the size of linked list.
  The second line of each test case contains N space separated integers denoting the values of N nodes.


Output
Corresponding to each test case, the expected output will be space separated values of the sorted linked list.


Constraints
1 <= T <= 100
0 <   N  <= 30
-100 <= L[i] <= 100

Examples 

Input
2
3
1 -3 -4
4
0 -2 3 -10


Output
-4  -3  1
-10 -2  0  3 
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

public class Absolute_List_Sorting {
  Node head;

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
    } else {
      Node temp = head;
      while (temp.next != null) temp = temp.next;

      temp.next = node;
    }
  }

  /* Drier program to test above functions */
  public static void main(String args[]) {
    /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();
      Absolute_List_Sorting llist = new Absolute_List_Sorting();
      //int n=Integer.parseInt(br.readLine());
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }

      GfG1 gfgobj = new GfG1();
      llist.head = gfgobj.sortedList(llist.head);
      llist.printList(llist.head);

      t--;
    }
  }
}

// } Driver Code Ends

/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class GfG1 {

  Node sortedList(Node head) {
    Node t = head;

    while (t != null) {
      try {
        if ((t.next).data < 0) {
          Node h = new Node(head.data);
          h.next = head.next;
          head.next = h;
          head.data = (t.next).data;
          try {
            t.next = (t.next).next;
          } catch (NullPointerException e) {
            t.next = null;
            // return head;
            break;
          }
        } else {
          t = t.next;
        }
      } catch (NullPointerException e) {
        // return head;

        break;
      }
    }
    return head;
  }
}
