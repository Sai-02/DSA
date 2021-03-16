/*
Given an array of positive and negative numbers.
 Find if there is a subarray (of size at-least one) with 0 sum.

Example 1:

Input:
5
4 2 -3 1 6

Output: 
Yes

Explanation: 
2, -3, 1 is the subarray 
with sum 0.
Example 2:

Input:
5
4 2 0 1 6

Output: 
Yes

Explanation: 
0 is one of the element 
in the array so there exist a 
subarray with sum 0.
Your Task:
You only need to complete the function subArrayExists()
 that takes array and n as parameters and returns true or
  false depending upon whether there is a subarray present with 0-sum or not.
   Printing will be taken care by the drivers code.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= N <= 104
-105 <= a[i] <= 105

 
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Subarray_with_0_sum {
    public static void main(String[] args) {
        // code
        // code

        // taking input using class Scanner
        Scanner scan = new Scanner(System.in);

        // taking total number of testcases
        int t = scan.nextInt();
        while (t > 0) {
            // taking total count of elements
            int n = scan.nextInt();

            // Declaring and Initializing an array of size n
            int arr[] = new int[n];

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            t--;

            // calling the method findSum
            // and print "YES" or "NO" based on the result
            System.out.println(new Solution12().findsum(arr, n) == true ? "Yes" : "No");
        }
    }

}// } Driver Code Ends

class Solution12 {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                return true;
            } else {
                hm.put(sum, i);
            }

        }

        return false;
    }
}

// ===================================================
// 
// GFG Editorial
// 
// ===================================================


// A simple solution is to consider all subarrays one by one and 
// check the sum of every subarray. We can run two loops: 
// the outer loop picks a starting point i and the inner loop tries
//  all subarrays starting from i
// . Time complexity of this method is O(n2).

// But, think of doing this with hashing.
//  Concept of prefix sum can be used with a hack to check 
//  if current sum occurred previously. If current sum encountered previously,
//   this means elements between previous sum and current sum makes them 0.



// Algorithm:

// Iterate through the array and for every element arr[i], 
// calculate prefix sum.
// If we consider all prefix sums, we can notice that there is a subarray with
//  0 sum when either a prefix sum repeats or prefix sum becomes 0.
// In both cases, we return true else we store the prefix sum in map or set and keep iterating.
// Return false if you don't get any subarray with 0 sum.




// class Solution{
//     //Function to check whether there is a subarray present with 0-sum or not.
//     static boolean findsum(int arr[], int n)
//     {
//             //using Hashmap to store the prefix sum which has appeared already.
//             HashMap<Integer, Integer> hM =  
//                             new HashMap<Integer, Integer>(); 
              
//             int sum = 0;      
              
//             //iterating over the array. 
//             for (int i = 0; i < arr.length; i++) 
//             {  
//                 //storing prefix sum.
//                 sum += arr[i]; 
                  
//                 //if prefix sum is 0 or if it is already present in Hashmap 
//                 //then it is repeated which means there is a subarray whose 
//                 //summation is 0, so we return true.
//                 if (sum == 0 || hM.get(sum) != null)                          
//                     return true; 
                  
//                 //storing every prefix sum obtained in Hashmap.
//                 hM.put(sum, i); 
//             }  
//             //returning false if we don't get any subarray with 0 sum.
//             return false;
//     }
// }
