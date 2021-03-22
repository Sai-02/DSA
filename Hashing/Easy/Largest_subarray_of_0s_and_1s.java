/*
Given an array of 0s and 1s.
 Find the length of the largest subarray with equal number of 0s and 1s.

Example 1:

Input:
N = 4
A[] = {0,1,0,1}
Output: 4
Explanation: The array from index [0...3]
contains equal number of 0's and 1's.
Thus maximum length of subarray having
equal number of 0's and 1's is 4.
Example 2:

Input:
N = 5
A[] = {0,0,1,0,0}
Output: 2
Your Task:
You don't need to read input or print anything. 
Your task is to complete the function maxLen()
 which takes the array arr[] and the size of the array
  as inputs and returns the length of the largest subarray
   with equal number of 0s and 1s.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
0 <= A[] <= 1
 */

// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

public class Largest_subarray_of_0s_and_1s {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = sc.nextInt();

            Solution14 g = new Solution14();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}
// } Driver Code Ends

class Solution14 {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array

    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                a[i]--;
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int maxLength = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (hm.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }

        }
        return maxLength;
    }
}

// ==========================================
// 
// GFG Editorial
// 
// =========================================


// 1. Convert all the 0's to -1, 
// thus the problem reduces to find the length of largest subarray giving sum 0.


// 2. After converting 0's, we can maintain hashmap to keep track of indices
//  of getting subarray sum equal to 0.
// Also we will keep updating maxLen of subarray by subtracting last zero sum 
// index from current index.



// class Solution
// {

//     int maxLen(int[] arr, int N)
//     {

//         int sum[] = new int[arr.length];
//         sum[0] = arr[0] == 0 ? -1 : 1;
//         for (int i = 1; i < sum.length; i++) 
//             sum[i] = sum[i - 1] + (arr[i] == 0 ? -1 : 1);
        

//         Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
//         int maxLen = 0;
//         int i = 0;
//         for (int s : sum)
//         {
//             if (s == 0) 
//                 maxLen = Math.max(maxLen, i + 1);
            
//             if (pos.containsKey(s)) 
//                 maxLen = Math.max(maxLen, i - pos.get(s));
//             else 
//                 pos.put(s, i);
            
//             i++;
//         }
//         return maxLen;
//     }
// }

