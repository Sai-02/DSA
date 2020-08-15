
/*
Given a singly linked list, your task is to remove every kth node from the linked list.

Input:
The first line of input contains number of test cases T.
 Then T test cases follow.
 Every test case contains 3 lines. 
 First line of every test case contains an integer N denoting the size of the linked list .
  The second line contains N space separated values of the linked list.
   The third line contains an integer K.

Output:
Output for each test case will be space separated values of the nodes of the new transformed linked list.

User Task:
The task is to complete the function deleteK() which should delete every kth nodes from the linked list.

Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= element of linked list <= 1000
0 <= k <= 100

Example:
Input:
2
8
1 2 3 4 5 6 7 8
3
4
1 2 3 4
2

Output:
1 2 4 5 7 8
1 3

Explanation:
Testcase 1: After removing every 3rd element from the linked list,
 we have updated list as 1, 2, 4, 5, 7 and 8, and the elements which are removed are 3 and 6.
*/
// { Driver Code Starts
import java.util.*;

class Node {
    Node next;
    int data;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Remove_every_k_th_node {
    Node head;

    void addToTheLast(Node node) {
        if (head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Remove_every_k_th_node list = new Remove_every_k_th_node();
            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                list.addToTheLast(new Node(a));
            }
            int k = sc.nextInt();
            // System.out.println(list.head.data+" "+ k);
            list.head = new GfG10().delete(list.head, k);
            Node temp = list.head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends

/*
 * Link list Node class Node { Node next; int data; Node(int d) { data = d; next
 * = null; } }
 */
class GfG10 {
    /* You are required to complete this method */
    Node delete(Node head, int k) {
        Node t = head;
        if (k == 0) {
            return head;
        }
        if (k == 1) {
            return null;
        }
        int i = 1;
        while (t != null) {

            i++;
            try {

                if (i % k == 0) {
                    t.next = t.next.next;
                } else {
                    t = t.next;
                }
            } catch (NullPointerException e) {
                break;
            }

        }

        return head;
    }
}