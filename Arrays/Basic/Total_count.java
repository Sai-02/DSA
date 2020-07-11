/*Given an array of positive integers and
 a number K where K is used as threshold value to divide each element of the array into sum of different numbers.
  Find the sum of count of the numbers in which array elements are divided.

Input:
The first line of input contains a single integer T denoting the number of test cases. 
Then T test cases follow. Each test case consist of two lines. 
The first line of each test case consists of an integer N and K,
 where N is the size of array and K is the threshold value.
  The second line of each test case contains N space separated integers denoting array elements.

Output:
Corresponding to each test case, print the total count.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 ≤ Ai ≤ 107
1 ≤ K ≤ 107

Example:
Input:
1
4 3
5 8 10 13

Output:
14
 */
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Total_count {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int k = scan.nextInt();

      int count = 0;
      for (int i = 0; i < n; i++) {
        int a = scan.nextInt();
        if (a % k == 0) {
          a = a / k;
        } else {
          a = a / k;
          a++;
        }

        count = count + a;
      }

      System.out.println(count);
    }
  }
}
