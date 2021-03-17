/*
Given an array of integers and a number K.
 Find the count of distinct elements in every window of size K in the array.

Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
Explanation: Window 1 of size k = 4 is
1 2 1 3. Number of distinct elements in
this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number
of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number
of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number
of distinct elements in this window are 3.
Example 2:

Input:
N = 3, K = 2
A[] = {4,1,1}
Output: 2 1
Your Task:
Your task is to complete the function countDistinct()
 which takes the array A[], the size of the array(N) 
 and the window size(K) as inputs and returns an array 
 containing the count of distinct elements in every contiguous
  window of size K in the array A[].

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= K <= 105
1 <= A[i] <= 105 , for each valid i
 */

// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

public class Count_distinct_elements_in_every_window {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Solution13 g = new Solution13();

            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends

class Solution13 {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        // Logic
        for (int i = 0; i < k - 1; i++) {
            if (hm.containsKey(A[i])) {
                int count = hm.get(A[i]);
                count++;
                hm.replace(A[i], count);
            } else {
                hm.put(A[i], 1);
            }
        }
        for (int j = 0, i = k - 1; i < n;) {
            if (hm.containsKey(A[i])) {
                int count = hm.get(A[i]);
                count++;
                hm.replace(A[i], count);
            } else {
                hm.put(A[i], 1);
            }

            a.add(hm.size());
            if (hm.get(A[j]) > 1) {
                hm.replace(A[j], hm.get(A[j]) - 1);

            } else {
                hm.remove(A[j]);
            }
            i++;
            j++;

        }
        return a;
    }
}


// ==================================
// 
//  GFG Editorial
// 
// ==================================


// Use hash map and calculate number of distinct elements of every window of size k.


// An Efficient Solution is to use the count of the previous window 
// while sliding the window. The idea is to create a hash map that
//  stores elements of the current window. When we slide the window,
//   we remove an element from the hash and add an element.
//  We also keep track of distinct elements.

// class Solution
// {
//     ArrayList<Integer> countDistinct(int A[], int n, int k)
//     {
//         ArrayList<Integer> result = new ArrayList<Integer>();
//         HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//         // count number of distinct elements for first window of size k
//         for (int i = 0; i < k; i++)
//         {
//             if (hm.containsKey(A[i]))
//                 hm.put(A[i], hm.get(A[i]) + 1);
//             else
//                 hm.put(A[i], 1);
//         }
//         result.add(hm.size());

//         // calculate answer for rest of the windows
//         for (int i = k; i < n; i++)
//         {
//             // if frequency of last element of the window is greater than 1
//             // then decrease the frequency
//             if (hm.get(A[i - k]) > 1)
//             {
//                 hm.put(A[i - k], hm.get(A[i - k]) - 1);
//                 // insert new element into the window
//                 if (hm.containsKey(A[i]))
//                     hm.put(A[i], hm.get(A[i]) + 1);
//                 else
//                     hm.put(A[i], 1);
//             } 
//             else
//             {
//                 // remove last element from window
//                 hm.remove(A[i - k]);
//                 // insert new element into the window
//                 if (hm.containsKey(A[i]))
//                     hm.put(A[i], hm.get(A[i]) + 1);
//                 else
//                     hm.put(A[i], 1);
//             }

//             result.add(hm.size());
//         }
//         return result;
//     }
// }
