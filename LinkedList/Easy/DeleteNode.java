/*
Delete xth node from a singly linked list. Your task is to complete the method deleteNode() which takes two arguments: the address of the head of the linked list and an integer x. The function returns the head of the modified linked list.

Input:
The first line of input contains an element T, denoting the number of test cases. 
Then T test cases follow. Each test case contains three lines. 
The first line of each test case contains an integer N denoting the number of elements of the linked list.
 Then in the next line are N space separated values of the linked list.
  The third line of each test case contains an integer x.

Output:
The output for each test case will be the space separated value of the returned linked list.

User Task:
The task is to complete the function deleteNode() which should delete the node at required position.

Constraints:
1 <= T <= 300
2 <= N <= 100
1 <= x <= N

Example:
Input:
2
3
1 3 4
3
4
1 5 2 9
2

Output:
1 3
1 2 9

Explanation:
Testcase 1: After deleting the node at 3rd position (1-base indexing), the linked list is as 1-> 3.
Testcase 2: After deleting the node at 2nd position (1-based indexing), the linked list is as 1-> 2-> 9. 
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

public class DeleteNode {
  Node head;

  void printList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public void addToTheLast(Node node) {
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null) temp = temp.next;

      temp.next = node;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();
      //int k = sc.nextInt();
      DeleteNode llist = new DeleteNode();
      //int n=Integer.parseInt(br.readLine());
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));
      }
      int x = sc.nextInt();
      //System.out.println(llist.head.data);
      GfG g = new GfG();
      //System.out.println(k);
      //System.out.println(g.getNthFromLast(llist.head,k));
      Node result = g.deleteNode(llist.head, x);
      llist.printList(result);
      t--;
    }
  }
} // } Driver Code Ends

/* Linklist node structure
    class Node
    {
        int data;
        Node next;
        
        Node(int d)
        {
            data = d;
            next = null;
        }
    }*/
/*You are required to complete below method*/
class GfG {

  Node deleteNode(Node head, int x) {
    if (x == 1) {
      return head.next;
    }
    Node t = head;
    for (int i = 1; i < x - 1; i++) {
      t = t.next;
    }
    t.next = (t.next).next;
    return head;
  }
}
