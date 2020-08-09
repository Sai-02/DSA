/*
Given a linked list of size N. 
The task is to complete the function countNodesinLoop() that checks 
whether a given Linked List contains a loop or not and 
if the loop is present then return the count of nodes in a loop or else return 0.
 C is the position of the node to which the last node is connected. If it is 0 then no loop.



Example 1:

Input:
N = 10
value[]={25,14,19,33,10,21,39,90,58,45}
C = 4
Output: 7
Explanation: The loop is 45->33. So
length of loop is 33->10->21->39->
90->58->45 = 7. The number 33 is
connected to the last node to form the
loop because according to the input the
4th node from the beginning(1 based
index) will be connected to the last
node for the loop.
Example 2:

Input:
N = 2
value[] = {1,0}
C = 1
Output: 2
Explanation: The length of the loop
is 2.
Your Task:
The task is to complete the function countNodesinLoop() 
which contains the only argument as reference to head of linked list 
and return the lenght of the loop ( 0 if there is no loop).

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 500
0 <= C <= N-1
*/
// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Find_length_of_Loop {
    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0)
            return;

        Node curr = head;
        for (int i = 1; i < x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            Solution x = new Solution();
            System.out.println(x.countNodesinLoop(head));
        }
    }
}
// } Driver Code Ends

/*
 * 
 * class Node { int data; Node next; Node(int d) {data = d; next = null; } }
 * 
 */

// Function should return the length of the loop in LL.

class Solution {
    static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return FindLength(slow);
            }

        }
        return 0;
    }

    static int FindLength(Node n) {
        int count = 1;
        Node l = n.next;
        while (l != n) {
            count++;
            l = l.next;
        }
        return count;
    }
}