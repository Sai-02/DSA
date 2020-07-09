/*Repeated I.Ds 
Raghav is given a task to select at most 10 employees for a company project. 
Each employee is  represented by a single digit I.D.
 number which is unique for all the selected employees of the project.
  Raghav has a technical problem in his system which printed I.D. number multiple times.
   Help him to get rid of the repeated numbers.
Input:
First line contain T test cases. 
Second line contain the Total number (N) of employees where repeated I.Ds. are present. 
Third line contain the array A[N] of size N containing the I.Ds. of employees.
Output:
Print the non repeated selected I.D. of employees in a new line in the same sequence they appear in Input.
Constraints:
1<=T<=100
0<=N<=1000
Example:
Input:
5
5
8 8 6 2 1
6
7 6 7 4 2 7
9
1 9 6 7 4 8 1 4 5
3
1 1 1
5
0 1 0 1 2
Output:
8 6 2 1
7 6 4 2
1 9 6 7 4 8 5
1
0 1 2 
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Repeated_IDs {

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
      for (int i = 0; i < a.size(); i++) {
        System.out.printf("%d ", a.get(i));
      }
      System.out.println("");
    }
  }
}
