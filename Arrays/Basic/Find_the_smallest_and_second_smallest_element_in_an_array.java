/* Given an array of integers, your task is to find the smallest and second smallest element in the array.
 If smallest and second smallest do not exist, print -1.

Input:
The first line of input contains an integer T denoting the number of test cases.
 Each test case contains an integer n denoting the size of the array.
  Then following line contains 'n' integers forming the array.

Output:
Print the smallest and second smallest element if possible,else print -1.

Constraints:
1<=T<=100
1<=n<=100
1<=a[i]<=1000

Example:
Input :
3
5
2 4 3 5 6
6
1 2 1 3 6 7
2
1 1
Output :
2 3
1 2
-1
*/

import java.io.*;
import java.util.*;

public class Find_the_smallest_and_second_smallest_element_in_an_array {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();
        if (!a.contains(k)) {
          a.add(k);
        }
      }
      if (a.size() >= 2) {
        Collections.sort(a);
        System.out.println(a.get(0) + " " + a.get(1));
      } else {
        System.out.println("-1");
      }
    }
  }
}
