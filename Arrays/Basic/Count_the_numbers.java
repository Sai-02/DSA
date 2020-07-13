/* Given a number N, count the numbers from 1 to N which comprise of digits, only in set 1, 2, 3, 4 and 5. 

Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow.
  Each test case consist of one line.
  Each line of each test case is N, where N is the range from 1 to N.

Output:
Print the count of numbers in the given range from 1 to N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103

Example:
Input:
2
100
10
Output:
30
5

Explanation:
When N is 20 then answer is 10 because 1 2 3 4 5 11 12 13 14 15 are only in given set.
 16 is not beause 6 is not in given set, only 1 2 3 4 5 in set.
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Count_the_numbers {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();
      int count = 0;
      for (int i = 1; i <= n; i++) {
        String s = "" + i;
        int j;
        for (j = 0; j < s.length(); j++) {
          int k = (int) s.charAt(j);
          if (49 <= k && k <= 53) {
            continue;
          } else {
            break;
          }
        }
        if (j == s.length()) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
