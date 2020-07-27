/*
Given a linked list of size N and a key. The task is to insert the key in the middle of the linked list.

Input:
The first line of input contains the number of test cases T. 
For each test case, 
the first line contains the length of linked list N and
 the next line contains N elements to be inserted into the linked list 
 and the last line contains the element to be inserted to the middle.

Output:
For each test case, there will be a single line of output containing the element of the modified linked list.

User Task:
The task is to complete the function insertInMiddle() which takes head reference and element to be inserted
 as the arguments. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
2
3
1 2 4
3
4
10 20 40 50
30
Output:
1 2 3 4
10 20 30 40 50 
*/

// { Driver Code Starts
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

public class Insert_in_Middle_of_Linked_List {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      Node head = new Node(sc.nextInt());
      Node tail = head;

      for (int i = 0; i < n - 1; i++) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
      }
      int key = sc.nextInt();

      //display(head);
      Solution1 obj = new Solution1();
      obj.insertInMid(head, key);
      display(head);
      System.out.println();
    }
  }

  public static void display(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
  }
}

// } Driver Code Ends

/*
    Structure of node class is:
    class Node {
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    */
class Solution1 {

  public Node insertInMid(Node head, int data) {
    Node t = head;
    int n = 0;
    while (t != null) {
      t = t.next;
      n++;
    }
    if (n % 2 == 0) {
      n = n / 2;
    } else {
      n = n / 2;
      n++;
    }
    int i = 0;
    t = head;
    while (t != null) {
      i++;
      if (i == n) {
        Node temp = new Node(data);
        temp.next = t.next;
        t.next = temp;
        return head;
      }
      t = t.next;
    }
    return head;
  }
}
