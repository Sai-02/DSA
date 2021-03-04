
/*
Given an input stream arr[] of n integers, 
find the kth largest element for each element in the stream.

Example 1:

Input:
k = 4, n = 6
arr[] = {1, 2, 3, 4, 5, 6}
Output:
-1 -1 -1 1 2 3
Explanation:
k = 4
For 1, the 4th largest element doesn't
exist so we print -1.
For 2, the 4th largest element doesn't
exist so we print -1.
For 3, the 4th largest element doesn't
exist so we print -1.
For 4, the 4th largest element is 1.
For 5, the 4th largest element is 2.
for 6, the 4th largest element is 3.
Example 2:

Input:
k = 1, n = 2
arr[] = {3, 4}
Output:
3 4 
Explanation: 
For the 1st and 2nd element the 1st largest 
element is itself.
 

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function kthLargest() 
 which takes 2 Integers k, and n and also an array arr[] 
 of size n as input and returns the kth largest element in the stream.

 

Expected Time Complexity: O(nlogk)
Expected Auxiliary Space: O(n)

 

Constraints:
1 ≤ k ≤ n ≤ 105
1 ≤ arr[i] ≤ 105
 */
// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Kth_largest_element_in_a_stream {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);

            String S1[] = read.readLine().split(" ");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution7 ob = new Solution7();
            int[] ptr = ob.kthLargest(k, arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends

class Solution7 {
    static int[] kthLargest(int k, int[] arr, int n) {
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else {
                if (pq.peek() < arr[i]) {
                    pq.remove();
                    pq.add(arr[i]);

                }

            }
            if (pq.size() >= k) {
                ans[i] = pq.peek();
            }
        }
        return ans;

    }
}

// =================================================
// 
// GFG Editorial
// 
// ================================================


// . Maintain a Minheap of size K,
//  thus heap will contrain minimum element at the top in that pile size.
//   Remove top element and insert and new elemenr from input array. 
// Thus follow this procedure

// class Solution {
//     static int[] kthLargest(int k, int[] arr, int n) {
  
//         int []ans =new int[n];
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    
//         for(int i=0; i<n; i++)
//         {
//             if(pq.size() < k)
//                 pq.add(arr[i]);
//             else
//             {
//                 if(arr[i] > pq.peek())
//     			{
//     				pq.poll();
//     				pq.add(arr[i]);
//     			}
//             }
//             if(pq.size() < k)
//                 ans[i] = -1;
//             else
//                 ans[i] = pq.peek();
//         }
        
//         return ans;
//     }
// };
