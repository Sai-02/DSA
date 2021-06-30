/*
 
Given an array of integers and another number.
 Find all the unique quadruple from the given array that sums up to the given number.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.
Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.
Your Task:
You don't need to read input or print anything.
 Your task is to complete the function fourSum() 
 which takes the array arr[] and the integer k as
  its input and returns an array containing all
   the quadruples in a lexicographical manner.
    Also note that all the quadruples should be
     internally sorted, ie for any quadruple
      [q1, q2, q3, q4] the following should follow:
       q1 <= q2 <= q3 <= q4.  (In the output each quadruple is separate by $. 
       The printing is done by the driver's code)

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= N <= 100
-1000 <= K <= 1000
-100 <= A[] <= 100
 
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Find_All_Four_Sum_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution7 sln = new Solution7();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution7 {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        HashSet<ArrayList<Integer>> h = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        list.add(arr[l]);
                        if (!h.contains(list)) {
                            ans.add(list);
                            h.add(list);
                        }
                    }
                    if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }

                }
            }

        }
        return ans;

    }
}