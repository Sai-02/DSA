/*
Given three arrays sorted in increasing order.
 Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.
 

Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function commonElements() which take the 3 arrays
  A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and 
  returns an array containing the common element present in all the 3 arrays in
   sorted order. 
If there are no such elements return an empty array.
 In this case the output will be printed as -1.

 

Expected Time Complexity: O(n1 + n2 + n3)
Expected Auxiliary Space: O(n1 + n2 + n3)

 

Constraints:
1 <= n1, n2, n3 <= 10^5
The array elements can be both positive or negative integers.
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class Common_elements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];

            for (int i = 0; i < n1; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < n2; i++) {
                B[i] = sc.nextInt();
            }
            for (int i = 0; i < n3; i++) {
                C[i] = sc.nextInt();
            }

            Solution10 sol = new Solution10();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0) {
                System.out.print(-1);
            } else {
                for (int i = 0; i < res.size(); i++) {
                    System.out.print(res.get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution10 {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = new ArrayList<>();

        int a = 0, b = 0, c = 0;
        while (a < n1 && b < n2 && c < n3) {
            if (A[a] == B[b] && B[b] == C[c]) {
                if (ans.size() > 0 && ans.get(ans.size() - 1) == A[a]) {

                } else {

                    ans.add(A[a]);
                }
                a++;
                b++;
                c++;
                continue;
            }
            int max = Math.max(A[a], Math.max(B[b], C[c]));
            if (A[a] < max) {
                a++;
            }
            if (B[b] < max) {
                b++;
            }
            if (C[c] < max) {
                c++;
            }

        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;

    }
}


// ===============================================================
// 
// GFG Editorial
// 
// ==============================================================


// Can you extend the idea of the 2-pointer approach to something like a 3 pointer approach?
// Maintain 3 pointers,
//  one for each array and traverse till any of them reaches the end of the array.


// class Solution 
// {
//     ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
//     {
//         int i = 0, j = 0, k = 0;
//         ArrayList<Integer> res = new ArrayList<Integer>();
//         int last = Integer.MIN_VALUE;

//         while (i < n1 && j < n2 && k < n3)
//         {
//             if (A[i] == B[j] && A[i] == C[k] && A[i] != last) 
//             {
//                 res.add (A[i]);
//                 last = A[i];
//                 i++;
//                 j++;
//                 k++;
//             }
//             else if (Math.min (A[i], Math.min(B[j], C[k])) == A[i]) i++;
//             else if (Math.min (A[i], Math.min(B[j], C[k])) == B[j]) j++;
//             else k++;
//         }
//         return res;
//     }
// }
