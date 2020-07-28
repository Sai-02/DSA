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
      

    }
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
