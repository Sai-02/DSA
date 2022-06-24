
/**
 * You are given N number of books. Every ith book has Ai number of pages. The
 * books are arranged in ascending order.
 * 
 * You have to allocate contiguous books to M number of students. There can be
 * many ways or permutations to do so. In each permutation, one of the M
 * students will be allocated the maximum number of pages. Out of all these
 * permutations, the task is to find that particular permutation in which the
 * maximum number of pages allocated to a student is the minimum of those in all
 * the other permutations and print this minimum value.
 * 
 * Each book will be allocated to exactly one student. Each student has to be
 * allocated at least one book.
 * 
 * Note: Return -1 if a valid assignment is not possible, and allotment should
 * be in contiguous order (see the explanation for better understanding).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * N = 4
 * A[] = {12,34,67,90}
 * M = 2
 * Output:113
 * Explanation:Allocation can be done in
 * following ways:{12} and {34, 67, 90}
 * Maximum Pages = 191{12, 34} and {67, 90}
 * Maximum Pages = 157{12, 34, 67} and {90}
 * Maximum Pages =113. Therefore, the minimum
 * of these cases is 113, which is selected
 * as the output.
 * 
 * Example 2:
 * 
 * Input:
 * N = 3
 * A[] = {15,17,20}
 * M = 2
 * Output:32
 * Explanation: Allocation is done as
 * {15,17} and {20}
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the
 * function findPages() which takes 2 Integers N, and m and an array A[] of
 * length N as input and returns the expected answer.
 * 
 * 
 * Expected Time Complexity: O(NlogN)
 * Expected Auxilliary Space: O(1)
 * 
 * 
 * Constraints:
 * 1 <= N <= 105
 * 1 <= A [ i ] <= 106
 * 1 <= M <= 105
 * 
 * 
 */

// Hint: Binary Search in Search space
class Solution {
    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M) {
        int high = 0;
        for (int val : A)
            high += val;
        int low = A[N - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(A, mid, M)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isPossible(int a[], int mid, int M) {
        int sum = 0, count = 1;
        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] <= mid) {
                sum += a[i];
            } else {
                sum = a[i];
                count++;
            }
        }
        if (count > M)
            return false;
        return true;
    }
};