/*
Given an array of positive integers. 
Find the length of the longest sub-sequence such that elements in the subsequence
 are consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. 
Your task is to complete the function findLongestConseqSubseq()
 which takes the array arr[] and the size of the array as inputs and r
 eturns the length of the longest subsequence of consecutive integers. 


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= N <= 105
0 <= a[i] <= 105

Company Tags
Topic Tags
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

public class Longest_consecutive_subsequence {
    // Driver Code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            System.out.println(new Solution3().findLongestConseqSubseq(a, n));

            t--;
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution3 {

    static int findLongestConseqSubseq(int arr[], int n) {
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            h.add(arr[i]);
        }
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (h.contains(arr[i])) {
                count = 1;
                int prev = arr[i] - 1;
                while (h.contains(prev)) {
                    count++;
                    h.remove(prev);
                    prev--;
                }
                int next = arr[i] + 1;
                while (h.contains(next)) {
                    count++;
                    h.remove(next);
                    next++;
                }
                maxCount = Math.max(count, maxCount);

            }
        }
        return maxCount;

    }
}

// =============================================
// 
// GFG Editorial
// 
// ============================================

// Algorithm: 

// Create an empty hash.
// Insert all array elements to hash.
// Do following for every element arr[i].
// Check if this element is the starting point of a subsequence.
//  To check this, simply look for arr[i] – 1 in the hash,
//   if not found, then this is the first element of a subsequence.
// If this element is the first element, then count the number of consecutive 
// elements present in the hash starting with this element. Iterate from arr[i] + 1 
// till the last element that can be found.
// If the count is more than the previous longest subsequence found, then update it.




// class Solution
// {   
//     //Function to return length of longest subsequence of consecutive integers.
// 	static int findLongestConseqSubseq(int a[], int n)
// 	{
// 	    //using a HashSet to store elements.
// 		HashSet<Integer> hs = new HashSet<Integer>();
// 		int ans = 0;
		
// 		//inserting all the array elements in HashSet.
// 		for(int i=0; i<n; i++)
// 			hs.add(a[i]);
		
// 		//checking each possible sequence from the start. 
// 		for(int i=0; i<n; i++)
// 		{
// 		    //if current element is starting element of a sequence then only 
//             //we try to find out the length of sequence. 
// 			if(!hs.contains(a[i]-1))
// 			{
// 				int j = a[i];
// 				//then we keep checking whether the next consecutive elements
//                 //are present in HashSet and we keep incrementing the counter. 
// 				while(hs.contains(j))
// 				{
// 					j++;
// 				}
				
// 				//storing the maximum count.
// 				if(ans<j-a[i])
// 					ans=j-a[i];
// 			}
// 		}
// 		//returning the length of longest subsequence.
// 		return ans;
// 	}
// }
