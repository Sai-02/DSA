/*
Given an array of N positive integers, 
print k largest elements from the array. 

Example 1:

Input:
N = 5, k = 2
arr[] = {12,5,787,1,23}
Output: 787 23
Explanation: First largest element in
the array is 787 and the second largest
is 23.
Example 2:

Input:
N = 7, k = 3
arr[] = {1,23,12,9,30,2,50}
Output: 50 30 23
Explanation: Three Largest element in
the array are 50, 30 and 23.
Your Task:
Complete the function kLargest() that takes the array, 
N and K as input parameters and returns a list of k largest element in descending order. 

Expected Time Complexity: O(N log K)
Expected Auxiliary Space: O(K)

Constraints:
1 ≤ N ≤ 104
K ≤ N
1 ≤ array[i] ≤ 105
 */

//{Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class K_largest_elements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();
            Solution1 T = new Solution1();
            ArrayList<Integer> list = T.kLargest(arr, n, k);
            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution1 {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);

            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (pq.size() > 0) {
            ans.add(0, pq.remove());
        }
        // Collections.sort(ans);
        // Collections.reverse(ans);
        return ans;
    }
}

// ======================================
// 
//  GFG Editorial
// 
// ======================================

// 1. Build a min heap, and start inserting the elements into it.
// 2. If heap size becomes equal to K, then compare the incoming
//  element with the element at the top of the heap.
// 3. If element at the top is less than the incoming element,
//  then pop the top from heap and insert the new element into the heap.
// 4. Finally, you are having K largest elements in the heap.
//  Now, since you need to print the elements in decreasing order,
//   so you can now pop the elements
//  from heap one by one and store it in a vector.


// class Solution
// {
//     public static ArrayList<Integer> kLargest(int arr[], int n, int k)
//     {
//         Queue<Integer> q = new PriorityQueue<Integer>();
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int i = 0; i < n; i++)
//         {
//             if(q.size() == k)  
//             // if size becomes equal to k
//             { 
//                 if(q.peek() < arr[i])  
//                 // if top element is smaller than arr[i]
//                 {
//                     q.poll();
//                     q.add(arr[i]);
//                 }
//             }  
//             else 
//             {
//                 q.add(arr[i]);
//             }
//         }
        
//         while(!q.isEmpty())
//         {
//             list.add(q.peek()); 
//             // push all heap elements to list
//             q.poll();
//         }
//         Collections.reverse(list);
//         return list;
//     }
// }
