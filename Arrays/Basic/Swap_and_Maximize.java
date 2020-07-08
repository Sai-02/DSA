// Swap and Maximize
// Given an array of n elements. Consider array as circular array i.e element after an is a1.
// The task is to find maximum sum of the difference between consecutive elements
//  with rearrangement of array element allowed i.e after rearrangement of element
//  find |a1 – a2| + |a2 – a3| + …… + |an – 1– an| + |an – a1|.

// Input:
// The first line of input contains an integer T denoting the number of test cases.
//  Each test case contains the number of elements in the array a[]
//   as n and next line contains space separated n elements in the array a[].

// Output:
// Print an integer which denotes the maximized sum.

// Constraints:
// 1<=T<=100
// 1<=n<=10000
// 1<=a[i]<=100000​

// Example:
// Input:
// 2
// 4
// 4 2 1 8
// 3
// 10 12 15​
// Output:
// 18​
// 10

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Swap_and_Maximize {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      //  int[] b=new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      Arrays.sort(a);
      ArrayList<Integer> b = new ArrayList<Integer>();
      if (n % 2 == 0) {
        for (int i = 0; i < n / 2; i++) {
          b.add(a[i]);
          b.add(a[n - 1 - i]);
        }
      } else {
        for (int i = 0; i < (n / 2) + 1; i++) {
          b.add(a[i]);
          b.add(a[n - 1 - i]);
        }
      }
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
        sum = sum + Math.abs(b.get(i + 1) - b.get(i));
      }
      sum = sum + Math.abs(b.get(0) - b.get(n - 1));
      System.out.println(sum);
    }
  }
}
