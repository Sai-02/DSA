/*
First K natural numbers 
Given an array of size n and a number k,
 we need to print first k natural numbers that are not there in given array.

Input:
First line consists of T test case. 
First line of every test case consists of N and K. 
Second line consists of elements of array.

Output:
Single line output, print the K missing numbers.

Constraints:
1<=T<=100
1<=N<=10^4
-1000<=Ai<=1000

Example:
Input:
2
3 3
1 4 3
3 3
-5 -6 1
Output:
2 5 6 
2 3 4 
 */
import java.io.*;
import java.lang.*;
import java.util.*;

// import java.Math.*;

public class First_K_natural_numbers {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int k = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      Arrays.sort(a);
      for (int i = 1;; i++) {
        if (k == 0) {
          break;
        }
        int j = 0;
        for (j = 0; j < n; j++) {
          if (i == a[j]) {
            break;
          }
        }
        if (j == n) {
          System.out.printf("%d ", i);
          k--;
        }
      }
      System.out.println("");
    }
  }
}
