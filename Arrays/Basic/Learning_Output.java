/*Being a Programmer you have to learn how to make your output looks better.
 According to the company, its company programmers have to present its output in a different manner as :
  If your output is 10.000000 you can save the decimal places and thus your output becomes 10.
   Now u have the learn the way to output.
    You are given elements of an array A[N] and you have to divide N by total no. of +ve integers, 
    N by total no. of -ve integers and N by total no. of zero value integers.

Input : 
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. 
Second line contains N - array size. Third line contains the elements of array.

Output : 
For each test case in a new line print the division value of
N by Total no. of +ve integers
N by Total no. of -ve integers
N by Total no. of zero value integers

Constraints :
1 ≤ T ≤ 50
1 ≤ N ≤ 100
1 ≤ A[i] ≤ 1000

Input : 
1
10
7 7 7 7 7 7 -9 -9 -9 0

Output : 
1.66667
3.33333
10
 */

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Learning_Output {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      int p = 0, ng = 0, z = 0;
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
        if (a[i] > 0) {
          p++;
        } else if (a[i] < 0) {
          ng++;
        } else {
          z++;
        }
      }
      if (n % p == 0) {
        p = n / p;
        System.out.println(p);
      } else {
        float P = (float) n / p;
        System.out.printf("%f\n", P);
      }
      if (n % ng == 0) {
        ng = n / ng;
        System.out.println(ng);
      } else {
        float P = (float) n / ng;
        System.out.printf("%f\n", P);
      }
      if (n % z == 0) {
        z = n / z;
        System.out.println(z);
      } else {
        float P = (float) n / z;
        System.out.printf("%f\n", P);
      }
    }
  }
}
