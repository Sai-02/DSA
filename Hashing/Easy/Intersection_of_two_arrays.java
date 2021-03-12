/*
Given two arrays A and B respectively of size N and M,
 the task is to print the count of elements in the intersection 
 (or common elements) of the two arrays.

For this question, the intersection of two arrays can be defined as 
the set containing distinct common elements between the two arrays. 

Example 1:

Input:
5 3
89 24 75 11 23
89 2 4

Output: 
1

Explanation: 
89 is the only element 
in the intersection of two arrays.
Example 2:

Input:
6 5
1 2 3 4 5 6
3 4 5 6 7 

Output: 
4

Explanation: 
3 4 5 and 6 are the elements 
in the intersection of two arrays.
Your Task:
The task is to complete the function NumberofElementsInIntersection()
 which takes 4 inputs ie- array a, array b, n which is the size of 
 array a, m which is the size of array b. The function should return
  the count of the number of elements in the intersection.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(min(N,M)).

Constraints:
1 ≤ N, M ≤ 105
1 ≤ A[i], B[i] ≤ 105
*/

// { Driver Code Starts
// Initial Template for Java

/* package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Intersection_of_two_arrays {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of total testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, m;

            // taking count of elements in array a
            n = sc.nextInt();

            // taking count of elements in array b
            m = sc.nextInt();

            // Creating 2 arrays of n and m
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

            // calling NumberofElementsInIntersection method
            // and printing the result
            System.out.println(NumberofElementsInIntersection(a, b, n, m));
        }
    }

    // } Driver Code Ends
    // User function Template for Java

    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        int count = 0;
        HashSet<Integer> h = new HashSet<>();
        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < n; i++) {
            h.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            if (h.contains(b[i]) && !hm.contains(b[i])) {
                count++;
            }
            hm.add(b[i]);
        }
        return count;

    }

    // { Driver Code Starts.

}
// } Driver Code Ends


// ==========================================
// 
// GFG Editorial
// 
// ==========================================


// Use hashing to check common elements in both the arrays.

// Hash the elements of the first array.
//  Now traverse second array and check if element exists in the hash, if it exists,
//  then increase the count and erase that element from the hash.

// Insert all elements of first array in a Set or HashSet.
// Iterate over the second array.
// If any element is already present in the Set or HashSet, increment the counter.
// Delete that element from Set or HashSet.
// Return the counter.

//Function to return the count of the number of elements in
//the intersection of two arrays.
// public static int NumberofElementsInIntersection (int a[], int b[] , int n, int m)
//     {
//         //using HashSet to store the elements.
//     	HashSet<Integer> s1=new HashSet<>();
    	
//         int count = 0;
        
//         //we insert all the elements of first array in HashSet s1. 
//     	for(int i=0;i<n;i++)
//     		s1.add(a[i]);
    
//         //iterating over the second array.
//     	for(int i=0;i<m;i++)
//     	{
//     	    //if current element already exists in set, we update the counter.
//     		if(s1.contains(b[i])){
    		    
//     		    //erasing element from HashSet because if same element is
//     		    //present again in the array we don't need to count it again.
//     		    s1.remove(b[i]);
    		    
//     		    //incrementing the counter.
//     		    count++;
//     		}
//     	}
    	
//     	//returning the counter.
//     	return count;
//     }

