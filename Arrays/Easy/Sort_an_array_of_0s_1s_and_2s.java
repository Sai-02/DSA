/*Given an array of size N containing 0s, 1s, and 2s; sort the array in ascending order.

Input:
First line of input contains number of testcases T. 
For each testcase, there will be two lines, 
first of which will contain N.
 The second lines contains the elements of the array.

Output: 
Print sorted array.

Your Task:
Complete the function sort012() that takes array and n and sorts the array in place. 

Constraints: 
1 <= T <= 50
1 <= N <= 10^5
0 <= A[i] <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */
// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

public class Sort_an_array_of_0s_1s_and_2s {

  // } Driver Code Ends

  //User function template for Java

  public static void sort012(int a[], int n) {
    int z = 0, t = 0, o = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        z++;
      } else if (a[i] == 1) {
        o++;
      } else {
        t++;
      }
    }
    for (int i = 0; i < n; i++) {
      if (z > 0) {
        a[i] = 0;
        z--;
      } else if (o > 0) {
        a[i] = 1;
        o--;
      } else {
        a[i] = 2;
      }
    }
  }

  // { Driver Code Starts.

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      int arr[] = new int[n];
      String inputLine[] = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }
      sort012(arr, n);
      StringBuffer str = new StringBuffer();
      for (int i = 0; i < n; i++) {
        str.append(arr[i] + " ");
      }
      System.out.println(str);
    }
  }
}
// } Driver Code Ends
