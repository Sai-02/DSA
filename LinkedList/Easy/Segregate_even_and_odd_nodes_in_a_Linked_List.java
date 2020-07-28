/*
Given a Linked List of integers, write a function to modify the linked list such that
 all even numbers appear before all the odd numbers in the modified linked list.
  Also, keep the order of even and odd numbers same.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of elements in Linked List.
The second line of each test case contains N input,elements in Linked List.

Output:

Print the all even numbers then odd numbers in the modified Linked List.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ size of elements ≤ 1000

Example:

Input
3
7
17 15 8 9 2 4 6
4
1 3 5 7
7
8 12 10 5 4 1 6

Output
8 2 4 6 17 15 9
1 3 5 7
8 12 10 4 6 5 1 
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class Segregate_even_and_odd_nodes_in_a_Linked_List {

  public static void main(String[] args) {
    FastReader scan = new FastReader();
    int t = scan.nextInt();
    while (t-- > 0) {
      // Easy solution using ArrayList
      //   ArrayList<Integer> ll = new ArrayList<Integer>();
      //   int n = scan.nextInt();
      //   while (n-- > 0) {
      //     int k = scan.nextInt();
      //     if (k % 2 == 0) {
      //       System.out.printf("%d ", k);
      //     } else {
      //       ll.add(k);
      //     }
      //   }
      //   for (int i = 0; i < ll.size(); i++) {
      //     System.out.printf("%d ", ll.get(i));
      //   }
      //   System.out.println();
      //
      //
      //
      //Solution using LinkedList
      int n = scan.nextInt();
      int k = scan.nextInt();
      Node head = new Node(k);
      n--;
      while (n-- > 0) {
        int a = scan.nextInt();

        Node temp = new Node(a);
        temp.next = head;
        head = temp;
      }
      head = func(head);
      Node node = head;
      while (node != null) {
        System.out.printf("%d ", node.data);
      }
      System.out.println();
    }
  }

  public static Node func(Node head) {
    Node last = head;
    while (last.next != null) {
      last = last.next;
    }
    Node t = head;
    while (head.data % 2 != 0) {
      Node temp = new Node(t.data);
      last.next = temp;
      head = head.next;
      last = temp;
    }

    while (t.next != null) {
      if ((t.next).data % 2 == 0) {
        t = t.next;
      } else {
        Node temp = new Node((t.next).data);
        last.next = temp;
        t.next = (t.next).next;
        last = temp;
      }
    }
    return head;
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
