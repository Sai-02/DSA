/* One day Jay, on getting his first salary, 
decides to distribute apples among the poverty-stricken persons.
 He gave each person 1kg of apples. 
 People are coming in a queue and he makes sure that he gives every person 1 kg of apples only once.
  Every person is identified by a specific integer.

Given the length of the queue N followed by an array of N integers, 
denoting the persons in that queue, 
find the minimum kg's of apples Jay will have to distribute.

Input:
The first line of the input contains an integer T denoting the number of test cases.
 For each test case there will be two test lines.
  The first line contains the length of queue N. 
  The second line contains the N space seperated integers which denotes the people in the queue.

Output:
For each test case, output a single line containing the answer.

Constraints:
1 ≤ T ≤ 20
1 ≤ N ≤ 105
1 ≤ Ai ≤ 105

Example:
Input:
2
5
1 1 1 1 1
5
1 2 3 1 2

Output:
1
3
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Jay_s_Apples {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      int n = scan.nextInt();

      HashSet<Integer> hs = new HashSet<Integer>();
      for (int i = 0; i < n; i++) {
        int k = scan.nextInt();

        hs.add(k);
      }
      System.out.println(hs.size());
    }
  }
}
