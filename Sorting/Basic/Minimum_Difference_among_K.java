/*

*/

// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
// User function Template for Java

class Solution6 {
    long minDiff(long a[], int n, int k) {
        Arrays.sort(a);
        long minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            long diff = a[i + k - 1] - a[i];
            minDiff = Math.min(diff, minDiff);

        }
        return minDiff;

    }
}

// { Driver Code Starts.

// Driver class
public class Minimum_Difference_among_K {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            // int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n = Integer.parseInt(a2[0]);
            int k = Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution6 ob = new Solution6();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans = ob.minDiff(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
