/*
Create a link list of size N according to the given input literals. 
Each integer input is accompanied by an indicator which can either be 0 or 1.
 If it is 0, insert the integer in the beginning of the link list. 
 If it is 1, insert the integer at the end of the link list. 
Hint: When inserting at the end, make sure that you handle NULL explicitly.

Input:
The first line of input contains the number of test cases T.
 For each test case, 
 the first line of input contains the length of linked list N and the next line contains 2*N integers,
  each element to be inserted into the list is followed by a 0 or 1 
  which indicates the position of insertion of the integer. 

Output:
For each test case, there will be a single line of output that contains the linked list elements.

Your Task:
This is a function problem. 
You only need to complete the functions insertAtBeginning() and insertAtEnd() 
that takes the head of link list and integer value of the data to be inserted as inputs and 
returns the head of the modified link list. The printing is done automatically by the driver code.

Expected Time Complexity: O(1) for insertAtBeginning() and O(N) for insertAtEnd().
Expected Auxiliary Space: O(1) for both.

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
3
5
9 0 5 1 6 1 2 0 5 0
3
5 1 6 1 9 1
4
15 0 36 0 95 0 14 0
Output:
5 2 9 5 6
5 6 9
14 95 36 15

Explanation:
Testcase 1:
Length of Link List = N = 5
9 0 indicated that 9 should be inserted in the beginning. Modified Link List = 9.
5 1 indicated that 5 should be inserted in the end. Modified Link List = 9,5.
6 1 indicated that 6 should be inserted in the end. Modified Link List = 9,5,6.
2 0 indicated that 2 should be inserted in the beginning. Modified Link List = 2,9,5,6.
5 0 indicated that 5 should be inserted in the beginning. Modified Link List = 5,2,9,5,6. 
Final linked list = 5, 2, 9, 5, 6. 
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

public class Linked_List_Insertion {

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
      Node head = null;
      for (int i = 0; i < n; i++) {
        int value = sc.nextInt();
        int indicator = sc.nextInt();

        Solution ob = new Solution();
        if (indicator == 0) head =
          ob.insertAtBeginning(head, value); else head =
          ob.insertAtEnd(head, value);
      }
      printList(head);
      t--;
    }
  }
}

// } Driver Code Ends

/*
    class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
    }
    */
class Solution {

  // Should insert a node at the beginning
  Node insertAtBeginning(Node head, int x) {
    Node t = new Node(x);
    t.next = head;
    return t;
  }

  // Should insert a node at the end
  Node insertAtEnd(Node head, int x) {
    Node temp = new Node(x);
    Node t = head;
    if (t == null) {
      return temp;
    }
    while (t.next != null) {
      t = t.next;
    }
    t.next = temp;
    return head;
  }
}
