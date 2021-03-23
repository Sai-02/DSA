/*

Given an unsorted array of integers and a sum. 
The task is to count the number of subarray which adds to the given sum.

Example 1:

Input:
n = 5
arr[] = {10,2,-2,-20,10}
sum = -10
Output: 3
Explanation: Subarrays with sum -10 are: 
[10, 2, -2, -20], [2, -2, -20, 10] and 
[-20, 10].
Example 2:

Input:
n = 6
arr[] = {1,4,20,3,10,5}
sum = 33
Output: 1
Explanation: Subarray with sum 33 is: 
[20,3,10].
Your Task:
This is a function problem. 
You only need to complete the function subArraySum() 
that takes arr, n, sum as parameters and returns the count 
of subarrays which adds up to the given sum. 

Expected Time Comlexity: O(n)
Expected Auxilary Space: O(n)

Constraints:
1 <= n <= 105
-105 <= arr[i] <= 105
-105 <= sum <= 105
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

public class Subarray_range_with_given_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = sc.nextInt();
            System.out.println(new Solution15().subArraySum(arr, n, sum));

        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution15 {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int n, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            }
            if (hm.containsKey(sum)) {
                hm.replace(sum, hm.get(sum) + 1);

            } else {
                hm.put(sum, 1);
            }
        }
        return count;

    }
}

// ===============================================
// 
//  GFG Editorial
// 
// ==============================================

// Think of doing this with hashing.
//  Concept of prefix sum can be used with a hack to 
//  check if (current sum-given sum) occurred previously.
//   If (current sum- given sum) has been encountered previously,
//    this means elements between position of prefix sum equal t
//    o (current sum-given sum) 
// and current position is equal to the given sum.

// Algorithm :

// Use a map to store the prefix sum which has appeared already.
// Traverse over the array, store sum so far in current sum.
// If the value of current sum is equal to the desired sum at any instance increment count of subarrays by one.
// The value of current sum exceeds the desired sum by (current sum – sum). We check for this value in the map and if it is present it means there is a subarray with sum of elements equal to the given sum.
// Add the number of times (current sum – sum) has appeared in the map to the counter.
// Store the prefix sum in the map.
// Return the count of subarrays.



//Back-end complete function Template for Java

// class Solution
// {
//     //Function to count the number of subarrays which adds to the given sum.
//     static int subArraySum(int arr[], int n, int sum)
//     {
//         //using map to store the prefix sum which has appeared already.
//         HashMap<Integer, Integer> prevSum = new HashMap<>(); 
  
//         int res = 0; 
//         int currsum = 0; 
  
//         //iterating over the array elements.
//         for (int i = 0; i < n; i++) { 
  
//             //storing prefix sum which is sum of elements till current element. 
//             currsum += arr[i]; 
  
//             //checking if sum up to current element is equal to the given sum.
//             if (currsum == sum) 
//                 //updating the counter.
//                 res++; 
  
//             //if map contains (currsum - sum) i.e. difference of current and 
//     		//given sum, it means there is a subarray with sum of elements 
//     		//equal to sum given.
//             if (prevSum.containsKey(currsum - sum)) 
//                 //adding number of times (curr_sum - sum)has
//                 //appeared in map to the counter.
//                 res += prevSum.get(currsum - sum); 
  
//             //storing the prefix sum in map.
//             Integer count = prevSum.get(currsum); 
//             if (count == null) 
//                 prevSum.put(currsum, 1); 
//             else
//                 prevSum.put(currsum, count + 1); 
//         } 
//         //returning the count of subarrays.
//         return res; 
//     }
// }

