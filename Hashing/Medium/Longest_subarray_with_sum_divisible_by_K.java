/*
Given an array containing N integers and a positive integer K,
 find the length of the longest sub array with sum of the elements divisible by
  the given value K.

Example 1:

Input:
A[] = {2, 7, 6, 1, 4, 5}
K = 3
Output: 4
Explanation:The subarray is {7, 6, 1, 4}
with sum 18, which is divisible by 3.
Example 2:

Input:
A[] = {-2, 2, -5, 12, -11, -1, 7}
K = 3
Output: 5
Explanation:
The subarray is {2,-5,12,-11,-1} with
sum -3, which is divisible by 3.
 

Your Task:
The input is already taken care of by the driver code.
 You only need to complete the function longSubarrWthSumDivByK() 
 that takes an array (arr), sizeOfArray (n), positive integer K, 
 and return the length of the longest subarray which has sum divisible by K.
  The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).â€‹

Constraints:
1<=N,K<=106
-105<=A[i]<=105
 
 */

// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;

// } Driver Code Ends
// User function Template for Java

class Solution4 {
    int longSubarrWthSumDivByK(int arr[], int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(0, -1);
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (hm.containsKey(rem)) {
                int length = i - hm.get(rem);
                maxLength = Math.max(length, maxLength);
            } else {
                hm.put(rem, i);
            }
        }

        return maxLength;

    }

}

// { Driver Code Starts.

// Driver class
public class Longest_subarray_with_sum_divisible_by_K {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] element = line1.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            String line = br.readLine();
            String[] elements = line.trim().split("\\s+");

            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution4 obj = new Solution4();

            int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends