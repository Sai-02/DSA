
/*
Given a single linked list and an integer x.
 Your task is to complete the function deleteAllOccurances()
  which deletes all occurences of a key x present in the linked list. 
  The function takes two arguments: the head of the linked list and an integer x. 
  The function should return the head of the modified linked list.

Input:
The first line of input contains an element T, denoting the number of test cases. 
Then T test cases follow. Each test case contains three lines.
 The first line of each test case contains an integer N denoting the no of elements of the linked list.
  Then in the next line are N space separated values of the linked list.
   The third line of each test case contains an integer x.

Output:
The output for each test case will be the space separated value of the returned linked list.

User Task:
The task is to complete the function deleteAllOccurances()
 which should delete all the occurrences of given number x from the list.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Constraints:
1 <= T <= 300
1 <= N <= 100
1 <= x <= N

Example:
Input:
2
5
2 2 1 4 4
4
6
1 2 2 3 2 3
2

Output:
2 2 1
1 3 3

Example:
Testcase 2: Given number to delete is 2.
 After deleting all occurrences of 2, we have elements in the list as 1, 3, and 3.
  
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

public class Delete_keys_in_a_Linked_list {
    Node head;

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            int x = sc.nextInt();
            GfG g = new GfG();
            Node result = g.deleteAllOccurances(head, x);
            printList(result);
            t--;
        }
    }
}// } Driver Code Ends

/*
 * Linked list Node class Node { int data; Node next;
 * 
 * Node(int d) { data = d; next = null; } }
 */

class GfG {
    public static Node deleteAllOccurances(Node head, int x) {
        return head;
    }
}