/*
Given two sorted arrays of distinct elements.
 There is only 1 difference between the arrays.
  First array has one element extra added in between.
   Find the index of the extra element.

Example 1:

Input:
N = 7
A[] = {2,4,6,8,9,10,12}
B[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the second array, 9 is
missing and it's index in the first array
is 4.
Example 2:

Input:
N = 6
A[] = {3,5,7,9,11,13}
B[] = {3,5,7,11,13}
Output: 3
Your Task:
You don't have to take any input.
 Just complete the provided function findExtra()
  that takes array A[], B[] and size of A[] and
   return the valid index (0 based indexing).

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
2<=N<=104
1<=Ai<=105

Company Tags
Topic Tags

*/

// { Driver Code Starts
import java.util.*;

public class Index_Of_an_Extra_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++)
                b[i] = sc.nextInt();
            Solution2 g = new Solution2();
            System.out.println(g.findExtra(a, b, n));
        }
    }
}// } Driver Code Ends

/* Complete the function below */
class Solution2 {
    public int findExtra(int a[], int b[], int n) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (mid < b.length && a[mid] == b[mid]) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
}