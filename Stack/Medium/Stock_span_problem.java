
/*
 * The stock span problem is a financial problem where we have a series of n
 * daily price quotes for a stock and we need to calculate the span of stock’s
 * price for all n days. The span Si of the stock’s price on a given day i is
 * defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than or equal to
 * its price on the given day. For example, if an array of 7 days prices is
 * given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
 * corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The first line of each test case is N, N is the size of the
 * array. The second line of each test case contains N input C[i].
 * 
 * Output: For each testcase, print the span values for all days.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ N ≤ 200 1 ≤ C[i] ≤ 800
 * 
 * Example: Input: 2 7 100 80 60 70 60 75 85 6 10 4 5 90 120 80
 * 
 * Output: 1 1 1 2 1 4 6 1 1 2 4 5 1
 * 
 * 
 * 
 * 
 */

//===========================
//
// Brute force having O(n2)
//
//==========================

// import java.util.*;
// import java.lang.*;
// import java.io.*;
// import java.math.*;

// public class Stock_span_problem {
//     public static void main(String[] args) {
//         FastReader scan = new FastReader();
//         int t = scan.nextInt();
//         while (t-- > 0) {
//             int n = scan.nextInt();
//             int[] spanValues = new int[n];

//             int[] a = new int[n];
//             for (int i = 0; i < n; i++) {
//                 a[i] = scan.nextInt();
//                 spanValues[i] = 0;
//             }
//             for (int i = n - 1; i >= 0; i--) {
//                 for (int j = i; j >= 0; j--) {
//                     if (a[i] >= a[j]) {
//                         spanValues[i]++;
//                     } else {
//                         break;
//                     }
//                 }
//             }
//             for (int i = 0; i < n; i++) {
//                 System.out.print(spanValues[i] + " ");

//             }
//             System.out.println();

//         }

//     }

//     static class FastReader {
//         BufferedReader br;
//         StringTokenizer st;

//         public FastReader() {
//             br = new BufferedReader(new InputStreamReader(System.in));
//         }

//         String next() {
//             while (st == null || !st.hasMoreElements()) {
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }

//         int nextInt() {
//             return Integer.parseInt(next());
//         }

//         long nextLong() {
//             return Long.parseLong(next());
//         }

//         double nextDouble() {
//             return Double.parseDouble(next());
//         }

//         String nextLine() {
//             String str = "";
//             try {
//                 str = br.readLine();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return str;
//         }
//     }
// }

// ==============================================
//
// Solution in O(n) using stack
//
// =================================================

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Stock_span_problem {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n];
            int[] span = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }
            Stack<Integer> s = new Stack<Integer>();
            s.push(0);
            span[0] = 1;
            for (int i = 1; i < n; i++) {
                while (!s.empty() && a[i] > a[s.peek()]) {
                    s.pop();
                }
                if (s.empty()) {
                    span[i] = i + 1;
                } else {
                    span[i] = i - s.peek();
                }
                s.push(i);

            }
            for (int i = 0; i < n; i++) {
                System.out.print(span[i] + " ");
            }
            System.out.println();

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
