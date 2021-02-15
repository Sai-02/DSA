
/*
Given an array of digits (values are from 0 to 9), 
find the minimum possible sum of two numbers formed from digits of the array.
 All digits of given array must be used to form the two numbers.

 

Example 1:

Input:
N = 6
arr[] = {6, 8, 4, 5, 2, 3}
Output:
604
Explanation:
The minimum sum is formed by numbers 
358 and 246
 

Example 2:

Input:
N = 5
arr[] = {5, 3, 0, 7, 4}
Output:
82
Explanation:
The minimum sum is formed by numbers 
35 and 047


Your Task:
You don't have to print anything, printing is done by the driver code itself. 
Your task is to complete the function minSum() which takes the array A[]
 and its size N as inputs and returns the required sum.
 


Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 35
0 ≤ A[] ≤ 9
 */

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Min_sum_formed_by_digits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int) (n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Compute obj = new Compute();
            System.out.println(obj.minSum(a, n));

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Compute {

    public static long minSum(int arr[], int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        String sum1 = "";
        String sum2 = "";
        while (!pq.isEmpty()) {
            // System.out.println("inside");
            int value = pq.peek();
            pq.remove();
            sum1 = sum1 + value;
            if (pq.size() <= 0) {
                break;
            }
            value = pq.peek();
            pq.remove();
            sum2 = sum2 + value;
        }

        return Long.parseLong(sum1) + Long.parseLong(sum2);

    }
}


// =============================================
// 
//  GFG EDitorial
// 
// ============================================


// Since we want to minimize the sum of two numbers to be formed,
//  we must divide all digits in two halves and assign half-half digits to them. 
// We also need to make sure that the leading digits are smaller.