/*
Given a sorted array with possibly duplicate elements. 
The task is to find indexes of first and last occurrences of an element X
 in the given array.

Note: If the element is not present in the array return {-1,-1} as pair.

 

Example 1:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
X = 5
Output:
2 5
Explanation:
Index of first occurrence of 5 is 2
and index of last occurrence of 5 is 5.
Example 2:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 7, 123, 125}
X = 7
Output:
6 6
 

Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function indexes() which takes the array
  v[] and an integer X as inputs and returns  the first and last occurrence
   of the element X. If the element is not present in the array return {-1,-1} as pair.


Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ v[i], X ≤ 1018
 */

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

public class Left_most_and_right_most_index {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int) (n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());

            Solution14 obj = new Solution14();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first + " " + ans.second);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class pair { long first, second; public pair(long first, long second) {
 * this.first = first; this.second = second; } }
 */

class Solution14 {

    public pair indexes(long a[], long x) {
        long left = -1;
        long right = -1;
        int l = 0, r = a.length - 1;
        // Get Left element
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] < x) {
                l = mid + 1;
            } else {
                if (a[mid] == x) {
                    left = mid;
                }
                r = mid - 1;
            }
        }
        l = 0;
        r = a.length - 1;
        // Get right element
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] > x) {
                r = mid - 1;
            } else {
                if (a[mid] == x) {
                    right = mid;
                }
                l = mid + 1;
            }

        }

        pair Pair = new pair(left, right);
        return Pair;

    }
}
