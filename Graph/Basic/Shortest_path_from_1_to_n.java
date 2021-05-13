/*

 */

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Shortest_path_from_1_to_n {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution1 ob = new Solution1();
            System.out.println(ob.minStep(n));
        }
    }
}// } Driver Code Ends

// User function Template for Java

class Solution1 {
    static int minStep(int n) {
        int count = 0;

        while (n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                n--;
            }
            count++;
        }

        return count;

    }
}

// ===============================================
//
// GFG Editorial
//
// =============================================

// Since the task is to minimize number of edges,
// we would prefer to follow 3*i.