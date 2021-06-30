/*
Given an unsorted array arr[] of n positive integers.
 Find the number of triangles that can be formed with three different array
  elements as lengths of three sides of triangles. 

Example 1:

Input: 
n = 3
arr[] = {3, 5, 4}
Output: 
1
Explanation: 
A triangle is possible 
with all the elements 5, 3 and 4.
Example 2:

Input: 
n = 5
arr[] = {6, 4, 9, 7, 8}
Output: 
10
Explanation: 
There are 10 triangles
possible  with the given elements like
(6,4,9), (6,7,8),...
 

Your Task: 
This is a function problem. You only need to complete the function
 findNumberOfTriangles() that takes arr[] and n as input parameters
  and returns the count of total possible triangles.

Expected Time Complexity: O(n2).
Expected Space Complexity: O(1).

Constraints:
3 <= n <= 103
1 <= arr[i] <= 103

Company Tags
Topic Tags
Related Courses
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Count_the_number_of_possible_triangles {
    public static void main(String args[]) throws IOException {
        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t > 0) {
            // taking elements count
            int n = sc.nextInt();

            // creating an array of length n
            int arr[] = new int[n];

            // adding elements to the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            // creating an object of class Solutions
            Solution6 ob = new Solution6();

            // calling the method findNumberOfTriangles()
            // of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr, n));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution6 {
    // Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            int k = i - 1, j = 0;
            while (j < k) {
                int sum = arr[j] + arr[k];
                if (arr[i] >= sum) {
                    j++;
                } else {
                    count += k - j;
                    k--;
                }
            }
        }
        return count;
    }
}


// =========================================================
// 
//  GFG Editorial
// 
// ========================================================



// 1. Sort the elements of the array. Sorting would help you to maintain the condition that 
//  for any three sides of  the triangle  a,b and c , 

//    max(a,b) <=c.

// 2. Now, traverse for each pair of element in the array and make the count of triplets
//  such that (a+b)>c.

 
 
// class Solution{
//     //Function to count the number of possible triangles.
//     static int findNumberOfTriangles(int arr[], int n)
//     {
//         //Sorting the input array.
//         Arrays.sort(arr);
//         int count = 0;
        
//         //Traversing the array.
//         for(int i = 0; i < n-2; i++)
//         {
//             //Storing the third index starting from ith index in k.
//             int k = i+2;
            
//             //Traversing all the elements after ith index.
//             for (int j = i+1; j < n; ++j)
//             {
//                 //Traversing all the elements after jth index to check if there
//                 //exists any element which can satisfy the condition of triangle
//                 //with the elements at ith, jth and kth index.
//                 while (k < n && arr[(int)i] + arr[(int)j] > arr[(int)k])
//                         ++k;
                        
//                 //Incrementing the count of triangles.       
//                 count += k - j - 1;
//             }
//         }
//         //returning the count of triangles.
//         return count;
//     }
// }
