/*
Given a singly linked list and a number k.
 Write a function to find the (N/k)th element, 
 where N is the number of elements in the list.
  We need to consider ceil value in case of decimals.

Input:
The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case consists of an integer N. The second line consists of N spaced integers.
 The last line consists of an integer k.

Output:
Print the data value of (N/k)th node in the Linked List.

User Task:
The task is to complete the function fractional_node()
 which should find the n/kth node in the linked list and return its data value.

Constraints: 
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
1 2 3 4 5 6
2
5
2 7 9 3 5
3

Output:
3
7 
*/
// { Driver Code Starts
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class Find_nByk_th_node_in_Linked_list {
  static Node head;

  public static void addToTheLast(Node node) {
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null) temp = temp.next;
      temp.next = node;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        addToTheLast(new Node(a));
      }
      int k = sc.nextInt();
      GfG2 gfg = new GfG2();
      System.out.println(gfg.nknode(head, k));
    }
  }
} // } Driver Code Ends

/*
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

class GfG2 {

  public static int nknode(Node head, int k) {
    int n = 0;
    Node t = head;
    while (t != null) {
      n++;
      t = t.next;
    }
    t = head;
    if (n % k == 0) {
      n = (int) n / k;
    } else {
      n = (int) n / k;
      n++;
    }

    k = 0;
    while (t != null) {
      k++;
      if (n == k) {
        return t.data;
      }
      t = t.next;
    }
    return -1;
  }
}
