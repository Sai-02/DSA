/* Cyclically rotate an array by one 
Given an array, cyclically rotate an array by one.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. 
Each test case contains an integer n denoting the size of the array. 
Then following line contains 'n' integers forming the array. 

Output:
Output the cyclically rotated array by one.

Constraints:
1<=T<=1000
1<=N<=1000
0<=a[i]<=1000

Example:
Input:
2
5
1 2 3 4 5
8
9 8 7 6 4 2 1 3

Output:
5 1 2 3 4
3 9 8 7 6 4 2 1
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Cyclically_rotate_an_array_by_one {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        a.add(k);
      }
      int k = a.get(n - 1);
      a.remove(n - 1);

      a.add(0, k);
      for (int i = 0; i < n; i++) {
        System.out.printf("%d ", a.get(i));
      }
      System.out.println("");
    }
  }
}
