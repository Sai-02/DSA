/*
Given an array Arr[] of N distinct integers and a range from L to R,
 the task is to count the number of triplets having a sum in the range [L, R].


Example 1:

Input:
N = 4
Arr = {8 , 3, 5, 2}
L = 7, R = 11
Output: 1
Explaination: There is only one triplet {2, 3, 5}
having sum 10 in range [7, 11].

Example 2:

Input:
N = 5
Arr = {5, 1, 4, 3, 2}
L = 2, R = 7
Output: 2
Explaination: There two triplets having 
sum in range [2, 7] are {1,4,2} and {1,3,2}.

Your Task:
You don't need to read input or print anything.
 Your task is to complete the function countTriplets() 
 which takes the array Arr[] and its size N and L and R 
 as input parameters and returns the count.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 103
1 ≤ Arr[i] ≤ 103
1 ≤ L ≤ R ≤ 109

Company Tags
*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Triplets_with_sum_with_given_range {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[N];
            for (int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            String[] input = new String[2];
            input = read.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);

            Solution5 ob = new Solution5();
            System.out.println(ob.countTriplets(Arr, N, L, R));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution5 {
    static int countTriplets(int a[], int n, int l, int r) {
        Arrays.sort(a);
        int count1 = getTripletsCountLessThanOrEqual(a, 0, n - 1, r);
        int count2 = getTripletsCountLessThan(a, 0, n - 1, l);
        return count1 - count2;

    }

    static int getTripletsCountLessThanOrEqual(int a[], int l, int r, int key) {
        int n = r + 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = r;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum > key) {
                    k--;
                } else {
                    count += (k - j);
                    j++;
                }
            }
        }
        return count;
    }

    static int getTripletsCountLessThan(int a[], int l, int r, int key) {
        int n = r + 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = r;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum >= key) {
                    k--;
                } else {
                    count += (k - j);
                    j++;
                }
            }
        }
        return count;
    }
}


// ================================================================
// 
// GFG Editorial
// 
// ===============================================================


// class Solution {
//     public static int countTripletsLessThan(int[] arr, int n, int val) {
//         // sort the input array.
//         Arrays.sort(arr);

//         // Initialize result
//         int ans = 0;

//         int j, k;

//         // to store sum
//         int sum;

//         // Fix the first element
//         for (int i = 0; i < n - 2; i++) {

//             // Initialize other two elements
//             // as corner elements of subarray
//             // arr[j+1..k]
//             j = i + 1;
//             k = n - 1;

//             // Use Meet in the
//             // Middle concept.
//             while (j != k) {
//                 sum = arr[i] + arr[j] + arr[k];

//                 // If sum of current triplet
//                 // is greater, then to reduce it
//                 // decrease k.
//                 if (sum > val) k--;

//                 // If sum is less than or
//                 // equal to given value,
//                 // then add possible
//                 // triplets (k-j) to result.
//                 else {
//                     ans += (k - j);
//                     j++;
//                 }
//             }
//         }

//         return ans;
//     }

//     // Function to return count
//     // of triplets having sum
//     // in range [a, b].
//     public static int countTriplets(int arr[], int n, int a, int b) {

//         // to store count
//         // of triplets.
//         int res;

//         // Find count of triplets
//         // having sum less than or
//         // equal to b and subtract
//         // count of triplets having
//         // sum less than or equal
//         // to a-1.
//         res = countTripletsLessThan(arr, n, b) -
//               countTripletsLessThan(arr, n, a - 1);

//         return res;
//     }
// }