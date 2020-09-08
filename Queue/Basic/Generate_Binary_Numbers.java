
/*
 * Given a number N. The task is to generate and print all binary numbers with
 * decimal values from 1 to N.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. There will be a single line for each testcase which contains N.
 * 
 * Output: Print all binary numbers with decimal values from 1 to N in a single
 * line.
 * 
 * Constraints: 1 ≤ T ≤ 106 1 ≤ N ≤ 106
 * 
 * Example: Input: 2 2 5
 * 
 * Output: 1 10 1 10 11 100 101
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Generate_Binary_Numbers {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            Queue<String> q = new LinkedList<String>();
            q.add("1");
            while (n-- > 0) {
                String s1 = q.peek();
                q.remove();
                System.out.print(s1 + " ");
                String s2 = s1;
                q.add(s2 + "0");
                q.add(s2 + "1");

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
