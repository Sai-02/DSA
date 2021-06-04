/*

Given an unsorted array A of size N that contains only non-negative integers,
 find a continuous sub-array which adds to a given number S.

 

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
 

Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.
 

Your Task:
You don't need to read input or print anything. The task is to complete the function 
subarraySum() which takes arr, N and S as input parameters and returns a 
list containing the starting and ending positions of the first
 such occurring subarray from the left where sum equals to S. 
 The two indexes in the list should be according to 1-based indexing. 
 If no such subarray is found, return an array consisting only one element that is -1.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= Ai <= 1010

 

Company Tags
Topic Tags
 */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Subarray_with_given_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution9 obj = new Solution9();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends

class Solution9 {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> a = new ArrayList<>();
        int l = 0, r = 0;
        int sum = 0;
        while (r <= n && l <= r) {

            if (sum == s) {
                a.add(l + 1);
                a.add(r);
                return a;
            } else if (sum < s) {
                if (r < n) {
                    sum += arr[r];
                    r++;
                } else {
                    break;
                }

            } else {

                sum -= arr[l];
                l++;
            }

        }
        if (sum == s) {
            a.add(l + 1);
            a.add(r);
            return a;
        }
        a.add(-1);
        return a;
    }
}


// ========================================================
// 
// GFG Editorial
// 
// ========================================================


// We need to use Sliding window Method to solve this Problem.

// Add the elements, to current sum till it is less than S. 
// If it becomes more than S, start deleting elements from start in the current sum.
//  if the current sum again becomes less than S, again start adding elements to it.
//   In between also check, if the current sum becomes equal to S.
// If yes, then output start and end index, 
// else after traversing array no such solution is found, output -1.

// The complete solution is in next hint.


// The complete solution is

// Maintain start and last index to store and print these values 
// Iterate the complete array.
// Add array elements to current sum
// If current sum becomes greater than S, then remove elements starting from start index,
//  till it become less than or equal to S, and increment start.
// if current sum becomes equals to S, then return the starting and last index.
// if the current sum never matches to S, then return -1.


// class Solution
// {
//     //Function to find a continuous sub-array which adds up to a given number.
//     static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
//     {
//         int start = 0;
//         int last = 0;
//         boolean flag=false;
//         int currsum=0;
//         ArrayList<Integer> res = new ArrayList<Integer>();
        
//          //iterating over the array.
//         for(int i=0;i<n;i++)
//         {
//             //storing sum upto current element.
//             currsum+= arr[i];
            
//             //checking if current sum is greater than or equal to given number.
//             if(currsum>=s)
//             {
//                 last=i;
//                 //we start from starting index till current index and do the 
//                 //excluding part while s(given number) < currsum.
//                 while(s<currsum && start<last)
//                 {
//                     //subtracting the element from left i.e., arr[start]
//                     currsum-= arr[start];
//                     ++start;
//                 }
                
//                 //now if current sum becomes equal to given number, we store 
//                 //the starting and ending index for the subarray.
//                 if(currsum==s)
//                 {
//                     res.add(start + 1);
//                     res.add(last + 1);
                    
//                     //flag is set to true since subarray exists.
//                     flag = true;
//                     break;
//                 }
//             }
//         }
//         //if no subarray is found, we store -1 in result else the found indexes.
//         if (flag==false) {
//             res.add(-1);
//         } 
//         //returning the result.
//         return res;    
//     }
// }
 

