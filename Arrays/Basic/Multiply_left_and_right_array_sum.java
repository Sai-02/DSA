/*Multiply left and right array sum. 
Pitsy needs help in the given task by her teacher. 
The task is to divide a array into two sub array (left and right) containing n/2 
elements each and do the sum of the subarrays and then multiply both the subarrays.

Input:
First line consists of T test cases. Only line of every test case consists of an integer N.​

Output:
Print the answer by dividing array into left and right array and 
add their elements individually and
 then multiply both the array

Constraints:
1<=T<=100
1<=N<=1000
1<=Ai<=100

Example:
Input:
2
4
1 2 3 4
3
4 5 6
Output:
21
44
*/

import java.io.*;
import java.lang.*;
import java.util.*;

public class  Multiply_left_and_right_array_sum {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      int suml = 0, sumr = 0;
      for (int i = 0; i < n / 2; i++) {
        suml = suml + a[i];
      }
      for (int i = n / 2; i < n; i++) {
        sumr = sumr + a[i];
      }
      suml = suml * sumr;
      System.out.println(suml);
    }
  }
}
