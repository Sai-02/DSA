/*
Given a singly linked list with N nodes and a number X. The task is to find the node at the given index (X)(1 based index) of linked list. 

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains space seperated two integers, length of linked list and X.

Output:
For each testcase, there will be single line of output containing data at Xth node.

User Task:
The task is to complete the function GetNth() which takes head reference and index as arguments and should return the data at Xth position in the linked list.

Constraints:
1 <= T <= 30
1 <= N <= 100
K <= N
1 <= value <= 103

Example:
Input:
2
6 5
1 2 3 4 657 76
10 2
8 7 10 8 6 1 20 91 21 2

Output:
657
7 
*/

// { Driver Code Starts
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

public class Node_at_a_given_index_in_linked_list {
  static Node head;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      int a1 = sc.nextInt();
      Node head = new Node(a1);
      addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        addToTheLast(new Node(a));
      }

      GfG1 gfg = new GfG1();
      System.out.println(gfg.getNth(head, k));
    }
  }

  public static void addToTheLast(Node node) {
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null) temp = temp.next;
      temp.next = node;
    }
  }
}

// } Driver Code Ends

/*node class of the linked list
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
class GfG1 {

  public static int getNth(Node node, int ind) {
    int i = 0;
    Node t = node;
    while (t != null) {
      i++;
      if (i == ind) {
        return t.data;
      }
      t = t.next;
    }
    return -1;
  }
}
