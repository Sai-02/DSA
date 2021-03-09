/*
Given two arrays A and B of size N and M respectively.
 The task is to find union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements
 from both the arrays. If there are repetitions, 
 then only one occurrence of element should be printed in union.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3

Output: 
5

Explanation: 
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.
Example 2:

Input:
6 2 
85 25 1 32 54 6
85 2 

Output: 
7

Explanation: 
85, 25, 1, 32, 54, 6, and
2 are the elements which comes in the
union set of both arrays. So count is 7.
Your Task:
Complete doUnion funciton that takes a, n, b, m as parameters 
and returns the count of union elements of the two arrays.
The printing is done by the driver code.

Constraints:
1 ≤ N, M ≤ 105
1 ≤ A[i], B[i] < 105

Expected Time Complexity : O((n+m)log(n+m))
Expected Auxilliary Space : O(n+m)
 */

// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Union_of_two_arrays {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total count of testcases
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {

            int n, m;

            // taking size of array a
            n = sc.nextInt();

            // taking size of array b
            m = sc.nextInt();

            // Creating 2 array of size n and m
            int a[] = new int[n];
            int b[] = new int[m];

            // inserting elements to array a
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // inserting elements to array b
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            // calling doUnion method and printing the results
            System.out.println(doUnion(a, n, b, m));
        }

    }

    // } Driver Code Ends
    // User function Template for Java

    // Function to return the count of number of elements in union of two arrays.
    public static int doUnion(int a[], int n, int b[], int m) {
        int count = 0;
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (h.contains(a[i])) {
                count++;
            } else {
                h.add(a[i]);
            }
        }
        for (int i = 0; i < m; i++) {
            if (h.contains(b[i])) {
                count++;
            } else {
                h.add(b[i]);
            }
        }

        return m + n - count;
    }

    // { Driver Code Starts.

} // } Driver Code Ends

// ======================================
// 
//  GFG Editorial
// 
// =====================================

// Use hashing to store distinct elements from both the arrays.

// Algorithm:

// Insert all elements of first array in a Set or HashSet.
// Insert all elements of second array in the Set or HashSet.
// Remember Set or HashSet does not contain duplicate elements.
// Return the size of Set or HashSet which is total number of elements in them.


//Function to return the count of number of elements in union of two arrays.
// public static int doUnion(int a[], int n, int b[], int m) 
//     {
//         //using HashSet to store the elements.
//         HashSet<Integer> s=new HashSet<>();
    	    
//     	//we insert all the elements of first array in HashSet.
//     	for(int i = 0;i<n;i++)
//     	   s.add(a[i]);
    	    
//     	 //we insert all the elements of second array in HashSet.
// 	     //HashSet does not contain duplicates.
//     	 for(int i = 0;i<m;i++)
//     	    s.add(b[i]);
    	    
//     	  //returning the size of HashSet which is total number
//     	  //of elements in HashSet.
//     	  return s.size() ;
    	    
//      }


