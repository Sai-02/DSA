/*
Given a singly linked list and a number K, you are required to complete the function modularNode()
 which returns the modular node of the linked list.
A modular node is the last node of the linked list whose Index is divisible by the number K, i.e. i%k==0.

Input:
First line of input contains number of testcases T. For each testcase, 
first line of input contains length of Linked list N. 
Next line contains elements of the linked list and last line contains K.

Output:
For each test case the function must return the modular Node data, if no such node is possible then return "-1".

User Task:
The task is to complete the function modularNode()
 which should return the data of the modular node if exists else return -1.

Constraints:
1 <= T <= 100
1 <= N <= 500

Example:
Input:
2
7
1 2 3 4 5 6 7
3
5
19 28 37 46 55
2

Output:
6
46 
*/

// { Driver Code Starts
import java.util.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class Modular_Node {
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
      GfG3 gfg = new GfG3();
      System.out.println(gfg.moduarNode(head, k));
    }
  }
}

// } Driver Code Ends

/*node class of the linked list is as:
    class Node {
        int data;
         Node next;
         Node(int key)
         {
             data = key;
             next = null;
         }
    }
    */
// Your task is to complete the function
// function should return the modular Node
// if no such node is present then return -1
class GfG3 {

  public static int moduarNode(Node head, int k) {
    int i = 1;
    int n = 0;
    Node t = head;
    while (t != null) {
      t = t.next;
      n++;
    }
    int j = n % k;
    t = head;
    n = n - j;
    if (n > 0) {
      while (t != null) {
        if (i == n) {
          return t.data;
        }
        t = t.next;
        i++;
      }
    }

    return -1;
  }
}
